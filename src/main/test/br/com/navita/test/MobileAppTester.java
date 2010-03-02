package br.com.navita.test;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import br.com.navita.mobile.console.deployable.DynamicExecutorLookupService;
import br.com.navita.mobile.remote.MobileService;

public class MobileAppTester {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws InstantiationException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		DynamicExecutorLookupService service = (DynamicExecutorLookupService) ctx.getBean("dynamicExecutorLookupService");
		MobileService ex =  service.findInstance("c:/temp/dina.jar", "br.com.foo.TesteMobileExecutor");
		System.out.println(ex.execute(null).getMessage());
		System.exit(0);
	}

}
