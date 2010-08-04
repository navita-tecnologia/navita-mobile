package br.jpa.test;

import javax.naming.NamingException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.navita.mobile.console.domain.entity.Connector;
import br.com.navita.mobile.console.domain.entity.StaticConnector;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.service.BaseConnectorService;
import br.com.navita.mobile.console.service.ConnectorService;
import br.com.navita.mobile.console.view.rawdata.StaticConnectorRaw;


public class TestJpaApp {

	/**
	 * @param args
	 * @throws Throwable 
	 * @throws NamingException 
	 */
	@SuppressWarnings("unchecked")	
	public static void main(String[] args) throws Throwable {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ConnectorService<StaticConnector, StaticConnectorRaw> staticConnectorService = (ConnectorService<StaticConnector, StaticConnectorRaw>) ctx.getBean("staticConnectorService");
		
		staticConnectorService.create(new StaticConnectorRaw() {
			
			@Override
			public String getName() {
				
				return "First Connector";
			}
			
			@Override
			public String getId() {
				
				return "";
			}
			
			@Override
			public boolean isEnabled() {
				
				return true;
			}
			
			@Override
			public String getTokenConnectorId() {
				
				return null;
			}
			
			@Override
			public String getTag() {
				
				return "app1";
			}
			
			@Override
			public String getLicenseKey() {
				
				return "8g1O4NRsAYwYBTg12BfDnkZYDXobCtJqtroy4oZblT3a8_iFjaAxG3icETf66llo";
			}
			
			@Override
			public String getLicenceBundleId() {				
				return "76bed64b887e41a3a408891fc1259ce8";
			}
			
			@Override
			public String getAuthContainerId() {
				
				return null;
			}
		});
		
		
		BaseConnectorService<Connector> baseConnectorService = (BaseConnectorService<Connector>) ctx.getBean("baseConnectorService");
		
		System.out.println(baseConnectorService.listAll());
		
		
		System.exit(0);
	}

}
