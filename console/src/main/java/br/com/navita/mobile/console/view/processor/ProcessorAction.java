package br.com.navita.mobile.console.view.processor;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.sf.json.JSONSerializer;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.interceptor.ParameterAware;

import br.com.navita.mobile.console.domain.AuthContainer;
import br.com.navita.mobile.console.domain.Connector;
import br.com.navita.mobile.console.domain.LoginResult;
import br.com.navita.mobile.console.domain.Operation;
import br.com.navita.mobile.console.domain.SapConnector;
import br.com.navita.mobile.console.exception.InvalidDeviceDataException;
import br.com.navita.mobile.console.exception.InvalidLicenseKeyException;
import br.com.navita.mobile.console.exception.InvalidResultBeanException;
import br.com.navita.mobile.console.exception.OperationNotFoundException;
import br.com.navita.mobile.console.exception.UnresolvedReturnTypeException;
import br.com.navita.mobile.console.operator.ConnectorOperator;
import br.com.navita.mobile.console.operator.Operator;
import br.com.navita.mobile.console.operator.sap.SapAuthContainer;
import br.com.navita.mobile.console.service.BaseConnectorService;
import br.com.navita.mobile.console.service.BaseOperationService;
import br.com.navita.mobile.console.util.LicenseHelper;
import br.com.navita.mobile.console.util.NavitaMobileParamsUtil;
import br.com.navita.mobile.console.view.RawActionSupport;
import br.com.navita.mobile.console.view.rawdata.ProcessorRaw;
import br.com.navita.mobile.domain.MobileBean;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ProcessorAction extends RawActionSupport implements ParameterAware, ProcessorRaw{

	private static final Logger LOG = Logger.getLogger(ProcessorAction.class.getName());

	private String retType;
	private String connectorTag;
	private String operationTag;
	private String raw;
	private String pin;
	private String email;
	private String carrier;
	private String device;
	private String brand;

	private String user;
	private String login;
	private String password;
	private String passwd;

	private String operation; //compatibilidade com o antigo
	private String app;//compatibilidade com o antigo


	private InputStream inStream;	
	private Map<?,?> params;


	private BaseConnectorService<Connector> baseConnectorService;
	private BaseOperationService<Operation> baseOperationService;


	private LicenseHelper licenseHelper;

	private ConnectorOperator connectorOperator;
	private Operator operator;





	public void setLicenseHelper(LicenseHelper licenseHelper) {
		this.licenseHelper = licenseHelper;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public void setConnectorOperator(ConnectorOperator connectorOperator) {
		this.connectorOperator = connectorOperator;
	}


	public void setBaseConnectorService(
			BaseConnectorService<Connector> baseConnectorService) {
		this.baseConnectorService = baseConnectorService;
	}

	public void setBaseOperationService(
			BaseOperationService<Operation> baseOperationService) {
		this.baseOperationService = baseOperationService;
	}



	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		operationTag = operation;
		this.operation = operation;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
		this.connectorTag = app;
	}

	@Override
	public String getPin() {		
		return pin;
	}

	@Override
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	@Override
	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	@Override
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Map<?, ?> getParams() {
		return params;
	}

	public void setParams(Map<?, ?> params) {
		this.params = params;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	@Override
	public String getConnectorTag() {		
		return connectorTag;
	}

	public void setConnectorTag(String connectorTag) {
		this.connectorTag = connectorTag;
	}

	@Override
	public String getOperationTag() {		
		return operationTag;
	}

	public void setOperationTag(String operationTag) {
		this.operationTag = operationTag;
	}

	@Override
	public String getRaw() {		
		return raw;
	}

	public void setRaw(String raw) {
		this.raw = raw;
		decodeRaw(raw);
	}	



	public InputStream getInStream() {
		return inStream;
	}

	public void setInStream(InputStream inStream) {
		this.inStream = inStream;
	}

	public String getRetType() {
		return retType;
	}

	public void setRetType(String retType) {
		this.retType = retType;
	}



	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setParameters(Map params) {
		this.params = params;

	}


	@SuppressWarnings("unchecked")
	@Override
	public String execute() {		
		long start = System.currentTimeMillis();



		if(retType == null || retType.isEmpty() || (! "xml".equals(retType) && ! "json".equals(retType))){
			serializeBean(failBean(new UnresolvedReturnTypeException("retType must be 'json' or 'xml'")), start);
			return "json";
		}


		try {
			MobileBean obj = new MobileBean();			
			Connector connector = baseConnectorService.findByTag(connectorTag);
			prepareAndCheckParameters(connector);

			boolean isExternalOperation = connector.getOperationType() == null;
			boolean isConnectorLicenseInUse = licenseHelper.isUsingConnectorLicense(connector);
			String licenseBundleId = "";

			if("login".equals(operationTag)){//Login eh operacao especial
				if(!isConnectorLicenseInUse){
					throw new InvalidLicenseKeyException("Connector license bundle not found");
				}
				licenseBundleId = connector.getLicenseBundle().getId();

				if(connector.getAuthContainer() != null){//login no AD
					obj = doActiveDirectoryLogin(connector);
				}else{//login do conector
					obj = doConnectorLogin(connector);
				}


			} else {
				if(! isExternalOperation){//Operacao do conector 
					Operation operation = null;
					operation = baseOperationService.findByTagAndConnectorId(connector.getId(),operationTag);
					if(operation == null){
						throw new OperationNotFoundException(operationTag);
					}
					if(!isConnectorLicenseInUse){
						licenseHelper.checkOperationLicense(operation);
						licenseBundleId = operation.getLicenseBundle().getId();
					}else{
						licenseBundleId = connector.getLicenseBundle().getId();
					}

					obj = operator.doOperation(operation, (Map<String, Object>) params);

				}else{//Operacao externa
					if(!isConnectorLicenseInUse){
						throw new InvalidLicenseKeyException("Connector license bundle not found");
					}
					licenseBundleId = connector.getLicenseBundle().getId();

					obj = connectorOperator.doConnectorOperation(connector, (Map<String, Object>) params);
				}

			}

			licenseHelper.registerLicense(licenseBundleId,this); 	//license use
			registerAction(); 	//statistics

			if(obj == null){
				throw new InvalidResultBeanException("Não foi possível resolver a operação "+operationTag+" no conector "+connectorTag);
			}


			serializeBean(obj,start);	

		} catch (Throwable t) {
			LOG.log(Level.SEVERE,"Erro geral",t);
			serializeBean(failBean(t),start);			

		}

		return retType;
	}


	private MobileBean doConnectorLogin(Connector connector) {
		if(connector instanceof SapConnector){
			SapAuthContainer sapAuthContainer = new SapAuthContainer((SapConnector) connector);
			return processLoginContainer(sapAuthContainer);
		}
		return null;
	}

	private MobileBean processLoginContainer(AuthContainer authContainer){
		MobileBean bean = new MobileBean();
		String loginToUse = login;
		if(null == loginToUse){//tenta usar 'user'			
			loginToUse = user;
		}
		String passwdToUse = passwd;
		if(null == passwdToUse){//tenta usar 'password'			
			passwdToUse = password;
		}

		LoginResult result = authContainer.login(loginToUse, passwdToUse);

		bean.setMessage(result.getMessage());
		bean.setResultCode(result.isLogged()?0:1);
		bean.setList(result.getGroups());		
		bean.setToken(result.getToken());		
		return bean;
	}

	private MobileBean doActiveDirectoryLogin(Connector connector) {
		MobileBean bean = processLoginContainer(connector.getAuthContainer());
		String token = "";
		if(connector.getTokenConnector() != null){
			//TODO: resolver a questao do token remoto
			bean.setToken(token);	
		}

		return bean;
	}

	private void serializeBean(MobileBean bean,long start) {
		byte[] buff = null;
		long total = System.currentTimeMillis() - start;
		bean.setProcessingTime(total);
		if("json".equals(retType)){
			buff = JSONSerializer.toJSON(bean).toString().getBytes();
		}
		if("xml".equals(retType)){
			XStream xs =  new XStream(new DomDriver("utf-8"));
			xs.alias("mobile-bean", MobileBean.class);
			buff = xs.toXML(bean).getBytes();
		}

		setInStream(new ByteArrayInputStream(buff));		
	}



	private void registerAction() {


	}



	private MobileBean failBean(Throwable t1) {


		MobileBean bean = new MobileBean();
		String message = t1.getMessage();
		if(message == null|| message.isEmpty()){
			message = t1.getClass().getName();
		}
		bean.setMessage(message);
		bean.setResultCode(1);
		return bean;
	}

	private void decodeRaw(String raw2) {
		if(raw2 == null || raw2.isEmpty()){
			return;
		}
		Map<String, Object> processedParams = NavitaMobileParamsUtil.decodeParams(raw2);
		try {
			BeanUtils.populate(this, processedParams);
		} catch (IllegalAccessException e) {

		} catch (InvocationTargetException e) {

		}

	}


	private void prepareAndCheckParameters(Connector connector) throws InvalidDeviceDataException {
		boolean usingAnalytics = connector.getApplication().isUsingAnalytics();
		if(pin == null || pin.isEmpty()){
			if(usingAnalytics){
				throw new InvalidDeviceDataException("PIN parameter not found");
			}else{
				pin = "unknow";
			}
		}
		if(email == null || email.isEmpty() ){
			if(usingAnalytics){
				throw new InvalidDeviceDataException("EMAIL parameter not found");
			}else{
				email = "unknow";
			}
		}
		if( device == null || device.isEmpty()){
			if(usingAnalytics){
				throw new InvalidDeviceDataException("DEVICE parameter not found");
			}else{
				device = "unknow";
			}
		}

		if(brand == null || brand.isEmpty() ){
			if(usingAnalytics){
				throw new InvalidDeviceDataException("BRAND parameter not found");
			}else{
				brand = "unknow";
			}
		}

		if(carrier == null || carrier.isEmpty()){
			if(usingAnalytics){
				throw new InvalidDeviceDataException("CARRIER parameter not found");
			}else{
				carrier = "unknow";
			}
		}




	}


}
