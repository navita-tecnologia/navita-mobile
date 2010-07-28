package br.jpa.test;

import javax.naming.NamingException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.navita.mobile.console.bizz.LicenseService;
import br.com.navita.mobile.console.model.LicenseBundleType;


public class TestJpaApp {

	/**
	 * @param args
	 * @throws NamingException 
	 */
	@SuppressWarnings("unchecked")	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		LicenseService service = (LicenseService) ctx.getBean("licenseService");
		LicenseBundleType tp = new LicenseBundleType();
		tp.setName("tipo 2");
		service.persistBundleType(tp);
		
		System.exit(0);
	}

}
