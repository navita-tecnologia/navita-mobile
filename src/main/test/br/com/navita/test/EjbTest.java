package br.com.navita.test;



import java.security.Permission;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;

import br.com.navita.mobile.domain.MobileBean;
import br.com.navita.mobile.remote.EjbServiceFactory;
import br.com.navita.mobile.remote.MobileService;

public class EjbTest {
	public static void main(String[] args) throws Throwable {
		SecurityManager oldSecurityManager = System.getSecurityManager();

		System.setSecurityManager(new SecurityManager(){			
			public void checkPermission(Permission perm) {}
			public void checkPermission(Permission perm, Object context) {} 
		});
		MobileBean bean = new MobileBean();	
		EjbServiceFactory factory = null;
		InitialContext ctx = new InitialContext();
		factory = (EjbServiceFactory) ctx.lookup("ejb/MercadoLivre");
		MobileService service = null;
		service = factory.getServiceByName("search");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("as_word", "nikon d5000");
		params.put("as_desde", "5");
		bean = service.execute(params);
		System.out.println(bean.getObject().getClass().getName());
		
		System.setSecurityManager(oldSecurityManager);
		
	}
}
