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
package br.com.navita.mobile.ws.client;

import java.net.URL;

import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;


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

	private SinglePoint service;
	
	public void createService(){
		service = delegate.createJaxWsService().getPort(SinglePoint.class);
	}

	public GenericBean execute(GenericBean bean) {
		return service.execute(bean);
	}
}
