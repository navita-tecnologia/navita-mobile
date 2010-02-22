package br.com.navita.mobile.ws.client;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;

import br.com.navita.mobile.console.domain.MobileBean;

@SuppressWarnings("unused")
public class DynamicClient {
	
	public static final String wsPart = "/ws?wsdl";	
	private JaxWsPortProxyFactoryBean delegate = new JaxWsPortProxyFactoryBean();

	public void setNamespaceUri(String namespaceUri) {
		delegate.setNamespaceUri(namespaceUri);
	}


	public DynamicClient(URL wsdlUrl) {				
			delegate.setWsdlDocumentUrl( wsdlUrl);				
		
	}
	
	
	public void setLookupServiceOnStartup(boolean lookupServiceOnStartup) {
		delegate.setLookupServiceOnStartup(lookupServiceOnStartup);
	}

	public void setPortName(String portName) {
		delegate.setPortName(portName);
	}


	public void setServiceName(String serviceName) {
		delegate.setServiceName(serviceName);
	}

//	private SinglePoint service;
//	
//	public void createService(){
//		service = delegate.createJaxWsService().getPort(SinglePoint.class);
//	}
//
	public MobileBean execute(MobileBean bean) {
		return null;//service.execute(bean);
	}
}
