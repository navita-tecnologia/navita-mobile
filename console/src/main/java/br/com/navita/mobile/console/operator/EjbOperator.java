package br.com.navita.mobile.console.operator;

import java.security.Permission;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.navita.mobile.console.domain.Connector;
import br.com.navita.mobile.console.domain.EjbConnector;
import br.com.navita.mobile.console.util.NavitaMobileParamsUtil;
import br.com.navita.mobile.domain.MobileBean;
import br.com.navita.mobile.exception.ServiceNotFoundException;
import br.com.navita.mobile.remote.EjbServiceFactory;
import br.com.navita.mobile.remote.MobileService;

public class EjbOperator implements ConnectorOperator{
private static final Logger LOGGER = Logger.getLogger(EjbOperator.class.getName());
	
	@Override
	public MobileBean doConnectorOperation(Connector connector,	Map<String, Object> paramsFromServlet) throws NamingException {
		EjbConnector ejbConnector = (EjbConnector) connector;
		SecurityManager oldSecurityManager = System.getSecurityManager();


		MobileBean bean = new MobileBean();		
		try{
			System.setSecurityManager(new SecurityManager(){			
				public void checkPermission(Permission perm) {}
				public void checkPermission(Permission perm, Object context) {} 
			});


			EjbServiceFactory factory = null;

			InitialContext ctx = null;
			//if(urlProperties != null &&  urlProperties.size() == 0){
			ctx = new InitialContext();
			//			}else{
			//				Properties p = new Properties();
			//				p.putAll(urlProperties);
			//				ctx = new InitialContext(p);
			//				
			//			}
			factory = (EjbServiceFactory) ctx.lookup(ejbConnector.getEjbName());
			if(factory == null){
				bean.setResultCode(1);
				bean.setMessage(ejbConnector.getEjbName() + " nao encontrado");
				return bean;
			}
			MobileService service = null;
			Map<String,Object> params = NavitaMobileParamsUtil.extractFromArray(paramsFromServlet);
			String operation = (String) params.get("operationTag");
			if(operation == null){
				operation = (String) params.get("operation");
			}
			if(operation == null){
				LOGGER.log(Level.SEVERE,"ServiceNotFoundException");
				bean.setResultCode(1);
				bean.setMessage("Operacao nao encontrada");
				return bean;
			}
			try{
				service = factory.getServiceByName(operation);
			}catch (ServiceNotFoundException e) {
				LOGGER.log(Level.SEVERE,"ServiceNotFoundException",e);
				bean.setResultCode(1);
				bean.setMessage(operation + ": operacao nao encontrada");
				return bean;
			}catch (Exception e) {
				LOGGER.log(Level.SEVERE,"Exception",e);
				bean.setResultCode(1);
				bean.setMessage(e.getMessage());
				return bean;
			}

			if(service == null){
				bean.setResultCode(1);
				bean.setMessage("Servico falhou ao resolver " + ejbConnector.getEjbName() + ":" + operation);
				return bean;
			}

			bean = service.execute(params);


		}finally{
			System.setSecurityManager(oldSecurityManager);
		}

		return bean;
	}



}
