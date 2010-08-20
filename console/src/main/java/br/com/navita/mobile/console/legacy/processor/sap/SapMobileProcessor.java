package br.com.navita.mobile.console.legacy.processor.sap;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.navita.mobile.console.MobileAppProcessor;
import br.com.navita.mobile.console.domain.MobileApplication;
import br.com.navita.mobile.console.domain.MobileApplicationExecutor;
import br.com.navita.mobile.domain.MobileBean;
import br.com.navita.mobile.console.exception.OperationNotFoundException;
import br.com.navita.mobile.console.exception.SapGatewayException;
import br.com.navita.mobile.console.legacy.processor.sap.wrap.SapParameter;
import br.com.navita.mobile.console.legacy.processor.sap.wrap.SapRow;
import br.com.navita.mobile.console.legacy.processor.sap.wrap.SapTable;
import br.com.navita.mobile.console.operator.sap.SapSession;

import com.thoughtworks.xstream.XStream;


public class SapMobileProcessor implements MobileAppProcessor{
	private static final Logger LOG = Logger.getLogger(SapMobileProcessor.class.getName());
	
	
	public MobileBean processApplication(MobileApplication mobApp,	String operation, Map<String, Object> processedParams) throws SapGatewayException {
		if("login".equals(operation)){
			return processLogin(mobApp,processedParams);
		}
		SapExecution execution = getExecution(mobApp,operation);
		
		return execution.execute(processedParams);
	}

	private SapExecution getExecution(MobileApplication mobApp,String operation) throws SapGatewayException {
		String className = null;
		String config = null;
		for(MobileApplicationExecutor exec:mobApp.getExecutors()){
			if(operation.equals(exec.getName())){
				className = exec.getClassName();
				config = exec.getConfiguration();
				break;
			}
		}
		if(className == null){
			throw new OperationNotFoundException(operation);	
		}
		
		try {
			LOG.log(Level.INFO,"Carregando instancia de "+className);
			SapExecution execution = (SapExecution) Class.forName(className).newInstance();
			execution.setConfig(loadConfig(config));
			return execution;
		} catch (Exception e) {
			LOG.log(Level.SEVERE,"",e);
			throw new OperationNotFoundException(e);
		}		
		
	}

	private SapExecutionConfig loadConfig(String config) {
		XStream xStream = new XStream();
		xStream.alias("sapExec", SapExecutionConfig.class);
		xStream.alias("sapParam", SapParameter.class);
		xStream.alias("table", SapTable.class);
		xStream.alias("row", SapRow.class);
		
		return (SapExecutionConfig) xStream.fromXML(config);
	}

	private MobileBean processLogin(MobileApplication mobApp, Map<String, Object> processedParams) {
		String sessionToken = "";
		String message = "";
		Integer retCode = 0;
		try{			
			String login =  processedParams.get("user").toString();
			String passwd = processedParams.get("password").toString();
			LOG.info("logon de "+login);
			SapSession session = PoolManager.createSession(login,passwd,mobApp.getUrl());
			sessionToken = session.getToken();
			LOG.info("logon de "+login+" retornando token " + sessionToken);
			
		}catch (Exception e) {
			sessionToken = "";
			message = e.getMessage();
			retCode = 1;
		}
		MobileBean baseMobileBean = new MobileBean();
		baseMobileBean.setResultCode(retCode);
		baseMobileBean.setMessage(message);
		baseMobileBean.setToken(sessionToken);
		
		return baseMobileBean;
	}
	
	

}
