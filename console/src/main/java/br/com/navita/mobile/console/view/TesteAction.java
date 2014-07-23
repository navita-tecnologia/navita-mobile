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
