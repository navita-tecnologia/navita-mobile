package br.com.navita.mobile.console.remote;

import java.security.Permission;
import java.util.Map;

import br.com.navita.mobile.console.BaseMobileAppProcessor;
import br.com.navita.mobile.console.domain.MobileApplication;
import br.com.navita.mobile.domain.MobileBean;
import br.com.navita.mobile.remote.EjbServiceFactory;

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
			EjbServiceFactory factory = null;
			
			
			
			
		}finally{
			System.setSecurityManager(oldSecurityManager);
		}
		
		return bean;
	}

}
