package br.com.navita.mobile.console.processor;

import java.security.Permission;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.InitialContext;

import br.com.navita.mobile.console.BaseMobileAppProcessor;
import br.com.navita.mobile.console.domain.MobileApplication;
import br.com.navita.mobile.domain.MobileBean;
import br.com.navita.mobile.exception.ServiceNotFoundException;
import br.com.navita.mobile.remote.EjbServiceFactory;
import br.com.navita.mobile.remote.MobileService;

public class EjbProcessor extends BaseMobileAppProcessor{

	private static final Logger LOGGER = Logger.getLogger(EjbProcessor.class.getName());
	
	@Override
	public MobileBean processApplication(MobileApplication mobApp,
			String operation, Map<String, Object> processedParams) throws Exception {
		
		super.resolveProperties(mobApp);
		
		SecurityManager oldSecurityManager = System.getSecurityManager();

		
		MobileBean bean = new MobileBean();		
		try{
			System.setSecurityManager(new SecurityManager(){			
				public void checkPermission(Permission perm) {}
				public void checkPermission(Permission perm, Object context) {} 
			});
			
			
			EjbServiceFactory factory = null;
			
			InitialContext ctx = null;
			if(urlProperties != null &&  urlProperties.size() == 0){
				ctx = new InitialContext();
			}else{
				Properties p = new Properties();
				p.putAll(urlProperties);
				ctx = new InitialContext(p);
				
			}
			factory = (EjbServiceFactory) ctx.lookup(mappedName);
			if(factory == null){
				bean.setResultCode(1);
				bean.setMessage(mobApp.getUrl() + " nao encontrado");
				return bean;
			}
			MobileService service = null;
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
				bean.setMessage("Servico falhou ao resolver " + mobApp.getUrl() + ":" + operation);
				return bean;
			}

			bean = service.execute(processedParams);
			
			
		}finally{
			System.setSecurityManager(oldSecurityManager);
		}
		
		return bean;
	}

	@Override
	protected String getProcessorUrlPrefix() {
		
		return "ejb";
	}

}
