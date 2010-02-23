package br.com.navita.mobile.console;

import java.util.Map;
import java.util.logging.Logger;

import br.com.navita.mobile.console.bizz.LoginService;
import br.com.navita.mobile.console.bizz.MSWindowsLoginService;
import br.com.navita.mobile.console.dao.LdapConfigDAO;
import br.com.navita.mobile.console.dao.MobileApplicationDAO;
import br.com.navita.mobile.console.deployable.DeployableProcessor;
import br.com.navita.mobile.console.domain.LdapConfig;
import br.com.navita.mobile.console.domain.LoginResult;
import br.com.navita.mobile.console.domain.MobileApplication;
import br.com.navita.mobile.console.domain.MobileBean;
import br.com.navita.mobile.console.jdbc.DataSourceAppProcessor;
import br.com.navita.mobile.console.jdbc.JdbcAppProcessor;
import br.com.navita.mobile.console.sap.SapMobileProcessor;
import br.com.navita.mobile.console.stat.StaticProcessor;
import br.com.navita.mobile.console.util.NavitaMobileParamsUtil;

public class NavitaMobileDispatcher {
	
	private static final Logger LOG = Logger.getLogger(NavitaMobileDispatcher.class.getName());
	
	private MobileApplicationDAO mobileApplicationDAO;
	private LdapConfigDAO ldapConfigDAO;
	private LoginService msLoginService;
	
	private SapMobileProcessor sapMobileProcessor;
	private StaticProcessor staticProcessor;
	private GenericWsProcessor genericWsProcessor;
	private DataSourceAppProcessor dsAppProcessor;
	private JdbcAppProcessor jdbcAppProcessor;
	private DeployableProcessor deployableProcessor;
	
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
	public void setGenericWsProcessor(GenericWsProcessor genericWsProcessor) {
		this.genericWsProcessor = genericWsProcessor;
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
		
		MobileApplication mobApp;
		try {
			mobApp = mobileApplicationDAO.findById(app[0]);
		} catch (Exception e) {
			MobileBean resultBean = new MobileBean();
			resultBean.setResultCode(1);
			resultBean.setMessage("Aplication not found "+app[0]);
			return resultBean;
		}
		
		
		if(operation == null || operation.length != 1){
			MobileBean resultBean = new MobileBean();
			resultBean.setResultCode(1);
			resultBean.setMessage("Invalid operation parameter");
			return resultBean;
		}
		
		try {
			LOG.info("Dispatching "+operation[0]);			
			return processApplication( mobApp,operation[0],params);
		} catch (Throwable e) {
			MobileBean resultBean = new MobileBean();
			resultBean.setResultCode(1);
			String message = e.getMessage();
			if(null == message){
				message = e.toString();
			}
			resultBean.setMessage(message);
			resultBean.setObject(e.toString());
			return resultBean;
		}		
		
		
		
	}

	private MobileBean processApplication(MobileApplication mobApp,	String operation, Map<?, ?> params) throws Exception {
		Map<String, Object> processedParams = NavitaMobileParamsUtil.extractFromRequestMap(mobApp,params);	
		
		if("login".equals(operation) && mobApp.isUsingNativeLoginService()){
			return processMSWindowsLoginOperation(mobApp, processedParams);
		}
		
		String url = mobApp.getUrl(); 
		
		if(url.startsWith("sap://")){
			return sapMobileProcessor.processApplication(mobApp,operation, processedParams);
		}
		
		if(url.startsWith("static://")){
			return staticProcessor.processApplication(mobApp,operation,processedParams);
		}
		
		if(url.startsWith("ds://")){
			return dsAppProcessor.processApplication(mobApp, operation, processedParams);			
		}
		if( url.startsWith("jdbc://")){
			return jdbcAppProcessor.processApplication(mobApp, operation, processedParams);
		}
		if( url.startsWith("jar://")){
			return deployableProcessor.processApplication(mobApp, operation, processedParams);
		}
		
		return genericWsProcessor.processApplication(mobApp, operation, processedParams);
	}

	

	private MobileBean processMSWindowsLoginOperation(MobileApplication mobApp,	Map<String, Object> params) {	
		
		LdapConfig serviceProperties = ldapConfigDAO.getServiceProperties(mobApp.getLoginServiceId());
		String ip = serviceProperties.getIp();
		String domainName = serviceProperties.getName(); 
		
		((MSWindowsLoginService) msLoginService).setConfig(serviceProperties);		
		String login = params.get("user").toString();
		LOG.info("Login in "+login +" on "+domainName+" using server "+ip);
		LoginResult result = msLoginService.login(login, params.get("password").toString());
		MobileBean bean = new MobileBean();
		bean.setMessage(result.getMessage());
		bean.setResultCode(result.isLogged()?0:1);
		bean.setList(result.getGroups());
		
		LOG.info("Login in operation for "+login+" done.");
		return bean;
	}

	

	

	

	

	

}
