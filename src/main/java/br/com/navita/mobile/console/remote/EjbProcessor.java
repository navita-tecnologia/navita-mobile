package br.com.navita.mobile.console.remote;

import java.security.Permission;
import java.util.Map;

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

		System.setSecurityManager(new SecurityManager(){			
			public void checkPermission(Permission perm) {}
			public void checkPermission(Permission perm, Object context) {} 
		});
		MobileBean bean = new MobileBean();		
		try{
			
			//ejb://name
			String mappedName = mobApp.getUrl().substring("ejb://".length());
			
			EjbServiceFactory factory = null;
			InitialContext ctx = new InitialContext();
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
