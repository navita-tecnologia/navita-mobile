package br.jpa.test;

import javax.naming.NamingException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.navita.mobile.console.domain.entity.Connector;
import br.com.navita.mobile.console.domain.entity.StaticConnector;
import br.com.navita.mobile.console.domain.entity.StaticOperation;
import br.com.navita.mobile.console.service.BaseConnectorService;
import br.com.navita.mobile.console.service.ConnectorService;
import br.com.navita.mobile.console.service.OperationService;
import br.com.navita.mobile.console.view.rawdata.ConnectorRaw;
import br.com.navita.mobile.console.view.rawdata.StaticOperationRaw;


public class TestJpaApp {

	/**
	 * @param args
	 * @throws Throwable 
	 * @throws NamingException 
	 */
	@SuppressWarnings("unchecked")	
	public static void main(String[] args) throws Throwable {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ConnectorService<StaticConnector, ConnectorRaw> staticConnectorService = (ConnectorService<StaticConnector, ConnectorRaw>) ctx.getBean("staticConnectorService");
		
		if("a".equals(""))
		staticConnectorService.create(new ConnectorRaw() {
			
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
				return "def5f8a8fffa4e0eac3da276de1031c3";
			}
			
			@Override
			public String getAuthContainerId() {
				
				return null;
			}
		});

		
		BaseConnectorService<Connector> baseConnectorService = (BaseConnectorService<Connector>) ctx.getBean("baseConnectorService");
		
		
		final StaticConnector conn = (StaticConnector) baseConnectorService.findById("e6200bd8d65149afb8a0153f3c540dcf");
		
		System.out.println(conn);
		
		OperationService<StaticOperation, StaticOperationRaw> staticOperationService = (OperationService<StaticOperation, StaticOperationRaw>) ctx.getBean("staticOperationService");
		if("".equals(""))
		staticOperationService.create(new StaticOperationRaw() {
			
			@Override
			public String getName() {
				
				return "st1";
			}
			
			@Override
			public String getId() {
				
				return null;
			}
			
			@Override
			public String getLicenseKey() {
				
				return null;
			}
			
			@Override
			public String getLicenseBundleId() {
				
				return null;
			}
			
			@Override
			public String getToken() {
				
				return null;
			}
			
			@Override
			public int getResultCode() {
				
				return 0;
			}
			
			@Override
			public String getObject() {
				
				return null;
			}
			
			@Override
			public String getMessage() {
				
				return "message 123";
			}
			
			@Override
			public String getList() {
				
				return null;
			}

			@Override
			public String getConnectorId() {
				
				return conn.getId();
			}
		});
		
		
		
		System.out.println(staticOperationService.getConnectorOperations(conn.getId()));
		
		System.exit(0);
	}

}
