/*
 * Copyright 2014 Navita Tecnologia.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
