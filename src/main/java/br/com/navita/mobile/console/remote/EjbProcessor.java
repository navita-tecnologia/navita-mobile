package br.com.navita.mobile.console.remote;

import java.security.Permission;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.naming.InitialContext;

import br.com.navita.mobile.console.BaseMobileAppProcessor;
import br.com.navita.mobile.console.domain.MobileApplication;
import br.com.navita.mobile.domain.MobileBean;
import br.com.navita.mobile.exception.ServiceNotFoundException;
import br.com.navita.mobile.remote.EjbServiceFactory;
import br.com.navita.mobile.remote.MobileService;

public class EjbProcessor extends BaseMobileAppProcessor{

	@Override
	public MobileBean processApplication(MobileApplication mobApp,
			String operation, Map<String, Object> processedParams)
			throws Exception {
		SecurityManager oldSecurityManager = System.getSecurityManager();

		
		MobileBean bean = new MobileBean();		
		try{
			System.setSecurityManager(new SecurityManager(){			
				public void checkPermission(Permission perm) {}
				public void checkPermission(Permission perm, Object context) {} 
			});
			
			//ejb://name
			
			String mappedName = mobApp.getUrl().substring("ejb://".length());
			int queryStringStart = mappedName.indexOf('?');
			Map<String, String> props = new HashMap<String, String>();
			if(queryStringStart> -1 ){
				String[] pairs = mappedName.substring(queryStringStart + 1).split("&");
				for(String pair:pairs){
					String[] values = pair.split("=");
					props.put(values[0], values[1]);
				}
				mappedName = mappedName.substring(0,queryStringStart);				 
			}
			
			EjbServiceFactory factory = null;
			
			InitialContext ctx = null;
			if(props.size() == 0){
				ctx = new InitialContext();
			}else{
				Properties p = new Properties();
				p.putAll(props);
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
				bean.setResultCode(1);
				bean.setMessage(operation + ": operacao nao encontrada");
				return bean;
			}catch (Exception e) {
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

}
