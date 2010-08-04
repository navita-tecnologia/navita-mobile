package br.jpa.test;

import javax.naming.NamingException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestJpaApp {

	/**
	 * @param args
	 * @throws NamingException 
	 */
	@SuppressWarnings("unchecked")	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		
		
		System.exit(0);
	}

}
