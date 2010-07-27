package br.jpa.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.navita.mobile.console.dao.jpa.GenericRepository;
import br.com.navita.mobile.console.model.StaticConnector;

public class TestJpaApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationJpaContext.xml");
		GenericRepository<StaticConnector> repo = (GenericRepository<StaticConnector>) ctx.getBean("staticConnectorRepository");
		System.out.println(repo.findAll());
	}

}
