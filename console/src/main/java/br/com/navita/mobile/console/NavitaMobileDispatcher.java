package br.com.navita.mobile.console;

import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.navita.mobile.console.bizz.LoginService;
import br.com.navita.mobile.console.bizz.MSWindowsLoginService;
import br.com.navita.mobile.console.dao.LdapConfigDAO;
import br.com.navita.mobile.console.dao.MobileApplicationDAO;
import br.com.navita.mobile.console.domain.LdapConfig;
import br.com.navita.mobile.console.domain.LoginResult;
import br.com.navita.mobile.console.domain.MobileApplication;
import br.com.navita.mobile.console.domain.entity.LicenseBundle;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.exception.InvalidDeviceDataException;
import br.com.navita.mobile.console.exception.InvalidLicenseKeyException;
import br.com.navita.mobile.console.exception.InvalidMobileUrlException;
import br.com.navita.mobile.console.exception.MobileApplictionNotFoundException;
import br.com.navita.mobile.console.jar.DeployableProcessor;
import br.com.navita.mobile.console.jdbc.DataSourceAppProcessor;
import br.com.navita.mobile.console.jdbc.JdbcAppProcessor;
import br.com.navita.mobile.console.proxy.ProxyServletProcessor;
import br.com.navita.mobile.console.remote.EjbProcessor;
import br.com.navita.mobile.console.sap.SapMobileProcessor;
import br.com.navita.mobile.console.service.LicenseService;
import br.com.navita.mobile.console.stat.StaticProcessor;
import br.com.navita.mobile.console.util.Decryptor;
import br.com.navita.mobile.console.util.DecryptorException;
import br.com.navita.mobile.console.util.NavitaMobileParamsUtil;
import br.com.navita.mobile.console.view.rawdata.LicenseActivationRaw;
import br.com.navita.mobile.domain.MobileBean;
import br.com.navita.mobile.ws.processor.GenericWsProcessor;

public class NavitaMobileDispatcher {

	private static final Logger LOG = Logger.getLogger(NavitaMobileDispatcher.class.getName());
	private static String PRIVATE_KEY = "RrSe916DqrdQANfFKaQkgQ==";

	private LicenseService licenseService;

	private MobileApplicationDAO mobileApplicationDAO;
	private LdapConfigDAO ldapConfigDAO;
	private LoginService msLoginService;

	private SapMobileProcessor sapMobileProcessor;
	private StaticProcessor staticProcessor;	
	private DataSourceAppProcessor dsAppProcessor;
	private JdbcAppProcessor jdbcAppProcessor;
	private DeployableProcessor deployableProcessor;	
	private EjbProcessor ejbProcessor;
	private GenericWsProcessor genericWsProcessor;
	private ProxyServletProcessor proxyServletProcessor;


	public void setLicenseService(LicenseService licenseService) {
		this.licenseService = licenseService;
	}

	public void setProxyServletProcessor(
			ProxyServletProcessor proxyServletProcessor) {
		this.proxyServletProcessor = proxyServletProcessor;
	}

	public void setGenericWsProcessor(GenericWsProcessor genericWsProcessor) {
		this.genericWsProcessor = genericWsProcessor;
	}

	public void setEjbProcessor(EjbProcessor ejbProcessor) {
		this.ejbProcessor = ejbProcessor;
	}

	public void setDeployableProcessor(DeployableProcessor deployableProcessor) {
		this.deployableProcessor = deployableProcessor;
	}

	public void setJdbcAppProcessor(JdbcAppProcessor jdbcAppProcessor) {
		this.jdbcAppProcessor = jdbcAppProcessor;
	}

	public void setDsAppProcessor(DataSourceAppProcessor dsAppProcessor) {
		this.dsAppProcessor = dsAppProcessor;
	}

	public void setSapMobileProcessor(SapMobileProcessor sapMobileProcessor) {
		this.sapMobileProcessor = sapMobileProcessor;
	}

	public void setStaticProcessor(StaticProcessor staticProcessor) {
		this.staticProcessor = staticProcessor;
	}


	public void setMsLoginService(LoginService msLoginService) {
		this.msLoginService = msLoginService;
	}

	public void setLdapConfigDAO(LdapConfigDAO ldapConfigDAO) {
		this.ldapConfigDAO = ldapConfigDAO;
	}


	public void setMobileApplicationDAO(
			MobileApplicationDAO mobileApplicationDAO) {
		this.mobileApplicationDAO = mobileApplicationDAO;
	}

	public MobileBean dispatch(Map<?, ?> params) {

		String[] operation = (String[]) params.get("operation");
		String[] app = (String[]) params.get("app");
		if(app == null || app.length != 1){
			MobileBean resultBean = new MobileBean();
			resultBean.setResultCode(1);
			resultBean.setMessage("Invalid Aplication parameter");
			return resultBean;
		}
		
		if(operation == null || operation.length != 1){
			MobileBean resultBean = new MobileBean();
			resultBean.setResultCode(1);
			resultBean.setMessage("Invalid operation parameter");
			return resultBean;
		}

		MobileApplication mobApp;
		
		try {
			mobApp = mobileApplicationDAO.findById(app[0]);
		} catch (Exception e) {
			MobileBean resultBean = new MobileBean();
			resultBean.setResultCode(1);
			resultBean.setMessage("Aplication not found "+app[0]);
			return resultBean;
		}
		
		if(mobApp == null){
			return getFailedBean(1, new MobileApplictionNotFoundException("Application not found: " + app[0] ));
		}
		

		try {
			if(! hasLicenseToRun(mobApp,operation[0],params)){
				MobileBean resultBean = new MobileBean();
				resultBean.setResultCode(1);
				resultBean.setMessage("Invalid/Expired License");
				return resultBean;
			}
		} catch (InvalidLicenseKeyException e1) {
			return getFailedBean(1,e1);			
		} catch (InvalidDeviceDataException e) {
			return getFailedBean(1,e);		
		}

		try {
			LOG.info("Dispatching "+operation[0]);			
			return processApplication( mobApp,operation[0],params);
		} catch (Throwable e) {
			return getFailedBean(1,e);
		}		



	}

	private boolean hasLicenseToRun(MobileApplication app, String operation, Map<?, ?> params) throws InvalidDeviceDataException, InvalidLicenseKeyException {
		LicenseBundle bundle = null;
		try {
			bundle = licenseService.getBundle(app.getLicenseBundleId());
		} catch (EntityNotFoundException e1) {
			throw new InvalidLicenseKeyException("License Bundle not found");
		}
		if(bundle == null || !bundle.isEnabled()){
			throw new InvalidLicenseKeyException("Disabled License Bundle");
		}
		
		String licenseKey = app.getLicenseActivationKey();
		String plain = null;
		try {
			plain = Decryptor.decrypt(licenseKey, PRIVATE_KEY);
		} catch (DecryptorException e) {
			throw new InvalidLicenseKeyException(e.getMessage());
		}
		//NOME|EXPIREDATE
		if(plain == null || plain.indexOf("|") == -1){
			LOG.log(Level.WARNING,"Invalid key " + licenseKey);
			return false;
		}

		String[] values = plain.split("\\|");
		if(!app.getName().equals(values[0])){
			LOG.log(Level.WARNING,"Invalid key " + licenseKey);
			return false;
		}

		long max  = Long.parseLong(values[1]);
		if(max < System.currentTimeMillis()){
			LOG.log(Level.WARNING,"Key " + licenseKey + " expired since " + new Date(max));
			return false;
		}

		LOG.log(Level.INFO,"Key valid until " + new Date(max));

		try{
			registerLicenseUse(app,params);
		}catch (Throwable t) {
			throw new InvalidLicenseKeyException(t);
		}

		return true;
	}

	private void registerLicenseUse(final MobileApplication app, final Map<?, ?> params) throws InvalidDeviceDataException {
		final String[] pin = (String[]) params.get("pin");
		if(pin == null){
			throw new InvalidDeviceDataException("PIN parameter not found");
		}

		final String[] email = (String[]) params.get("email");
		if(email == null){
			throw new InvalidDeviceDataException("EMAIL parameter not found");
		}

		final String[] device = (String[]) params.get("device");
		if(device == null){
			throw new InvalidDeviceDataException("DEVICE model parameter not found");
		}

		final String[] brand = (String[]) params.get("brand");
		if(brand == null){
			throw new InvalidDeviceDataException("BRAND parameter not found");
		}

		final String[] carrier = (String[]) params.get("carrier");
		if(carrier == null){
			throw new InvalidDeviceDataException("CARRIER parameter not found");
		}

		LicenseActivationRaw activationRaw = new LicenseActivationRaw(){
			@Override
			public String getBundleId() {				
				return app.getLicenseBundleId();
			}
			@Override
			public String getId() {				
				return null;
			}
			public String getName() {
				return "";
			}
			@Override
			public Date getActivationDate() {
				
				return new Date();
			}
			@Override
			public String getBrand() {
				
				return brand[0];
			}
			@Override
			public String getCarrier() {
				
				return carrier[0];
			}
			@Override
			public String getEmail() {
				
				return email[0];
			}
			@Override
			public String getModel() {
				
				return device[0];
			}
			@Override
			public String getPin() {
				
				return pin[0];
			};
			
		};
		

		try {
			licenseService.doLicenseActivation(activationRaw);
		} catch (EntityNotFoundException e) {
			throw new InvalidDeviceDataException("Invalid license configuration",e);
		}


	}

	private MobileBean processApplication(MobileApplication mobApp,	String operation, Map<?, ?> params) throws Exception {
		Map<String, Object> processedParams = NavitaMobileParamsUtil.extractFromRequestMap(mobApp,params);	

		if("login".equals(operation) && mobApp.isUsingNativeLoginService()){
			return processMSWindowsLoginOperation(mobApp, processedParams);
		}

		String url = mobApp.getUrl(); 

		MobileAppProcessor processor = lookupProcessor(url);

		if(processor == null){		
			throw new InvalidMobileUrlException(url);
		}else{
			return processor.processApplication(mobApp, operation, processedParams);
		}
	}

	private MobileAppProcessor lookupProcessor(String url) {
		MobileAppProcessor processor = null;

		if(url.startsWith("sap://")){
			processor = sapMobileProcessor;
		}

		if(url.startsWith("static://")){
			processor = staticProcessor;
		}

		if(url.startsWith("ds://")){
			processor = dsAppProcessor;			
		}

		if( url.startsWith("jdbc://")){
			processor = jdbcAppProcessor;
		}

		if( url.startsWith("jar://")){
			processor = deployableProcessor;
		}

		if( url.startsWith("ejb://")){
			processor = ejbProcessor;
		}

		if(url.startsWith("ws://")){
			processor = genericWsProcessor;
		}

		if(url.startsWith("proxy://")){
			processor = proxyServletProcessor;
		}

		return processor;
	}



	private MobileBean processMSWindowsLoginOperation(MobileApplication mobApp,	Map<String, Object> params) {	
		MobileBean bean = new MobileBean();

		LdapConfig serviceProperties = ldapConfigDAO.getServiceProperties(mobApp.getLoginServiceId());
		String ip = serviceProperties.getIp();
		String domainName = serviceProperties.getName(); 

		((MSWindowsLoginService) msLoginService).setConfig(serviceProperties);		
		String login = (String) params.get("login");
		if(null == login){
			//tenta usar 'user'
			login = (String) params.get("user");
		}
		LOG.info("Login in "+login +" on "+domainName+" using server "+ip);
		String passwd = (String) params.get("passwd");
		if(null == passwd){
			//tenta usar 'password'
			passwd = (String) params.get("password");
		}
		LoginResult result = msLoginService.login(login, passwd);
		String token = "";
		if(result.isLogged() && ! "none".equalsIgnoreCase(mobApp.getTokenGeneratorUrl())){
			LOG.info("Searching token on " + mobApp.getTokenGeneratorUrl());
			try {
				MobileBean tokenBean = callTokenGenerator(mobApp, params);
				token = tokenBean.getToken();
				if(tokenBean.getResultCode() != 0){
					bean.setObject(tokenBean);
				}

			} catch (Exception e) {
				return getFailedBean(1, e);
			}
		}

		bean.setMessage(result.getMessage());
		bean.setResultCode(result.isLogged()?0:1);
		bean.setList(result.getGroups());

		bean.setToken(token);

		LOG.info("Login in operation for "+login+" done.");
		return bean;
	}

	private MobileBean callTokenGenerator(MobileApplication mobApp,	Map<String, Object> params) throws Exception {
		MobileAppProcessor proc = lookupProcessor(mobApp.getTokenGeneratorUrl());
		MobileBean b = new MobileBean();
		if(proc != null){
			b = proc.processApplication(mobApp, "getToken", params);
		}

		return b;
	}


	private MobileBean getFailedBean(int code, Throwable t) {		
		MobileBean bean = new MobileBean();
		bean.setResultCode(code);		
		bean.setMessage(t.getMessage() == null ? t.toString():t.getMessage());
		bean.setObject(t.getClass().getName());
		return bean;
	}









}
