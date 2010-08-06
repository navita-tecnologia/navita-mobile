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
		
		if("a".equals("a"))
		staticConnectorService.create(new ConnectorRaw() {
			
			@Override
			public String getName() {
				
				return "Seccond Connector";
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
				
				return "app2";
			}
			
			@Override
			public String getLicenseKey() {
				
				return "8g1O4NRsAYwYBTg12BfDnkZYDXobCtJqtroy4oZblT3a8_iFjaAxG3icETf66llo";
			}
			
			@Override
			public String getLicenseBundleId() {				
				return "b4abc8c3e8b8482db7edd07cfc6e9cfe";
			}
			
			@Override
			public String getAuthContainerId() {
				
				return null;
			}
		});

		
		BaseConnectorService<Connector> baseConnectorService = (BaseConnectorService<Connector>) ctx.getBean("baseConnectorService");
		
		
		final StaticConnector conn = (StaticConnector) baseConnectorService.listAll().get(baseConnectorService.listAll().size()-1);
		
		System.out.println(conn);
		
		OperationService<StaticOperation, StaticOperationRaw> staticOperationService = (OperationService<StaticOperation, StaticOperationRaw>) ctx.getBean("staticOperationService");
		if("a".equals("a"))
		staticOperationService.create(new StaticOperationRaw() {
			
			@Override
			public String getName() {
				
				return "Teste JSON Operation";
			}
			
			@Override
			public String getTag() {
				
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
