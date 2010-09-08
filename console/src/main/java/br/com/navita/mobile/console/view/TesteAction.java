package br.com.navita.mobile.console.view;

import org.apache.struts2.dispatcher.DefaultActionSupport;

import br.com.navita.mobile.console.dao.GenericRepository;
import br.com.navita.mobile.console.domain.Connector;
import br.com.navita.mobile.console.domain.LicenseBundle;
import br.com.navita.mobile.console.domain.LicenseBundleType;
import br.com.navita.mobile.console.domain.StaticConnector;

public class TesteAction extends DefaultActionSupport{

	private GenericRepository<StaticConnector> staticConnectorRepository;
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setStaticConnectorRepository(
			GenericRepository<StaticConnector> staticConnectorRepository) {
		this.staticConnectorRepository = staticConnectorRepository;
	}
	
	public Connector getConnectors(){
		return (Connector) staticConnectorRepository.findAll();
	}
	
	public String foo(){
		
		StaticConnector conn = new StaticConnector();
		conn.setEnabled(true);
		LicenseBundle b = new LicenseBundle();
		b.setName("bundle1");
		b.setPeriod(10);
		LicenseBundleType bt= new LicenseBundleType();
		bt.setName("bt1");
		 
		b.setLicenseBundleType(bt);
		conn.setLicenseBundle(b);
		conn.setLicenseKey("lala");
		conn.setName(name);
		conn.setTag("tag1");
		conn.setName("foo");
		staticConnectorRepository.persist(conn);
		
		
		return SUCCESS;
	}
	
}
