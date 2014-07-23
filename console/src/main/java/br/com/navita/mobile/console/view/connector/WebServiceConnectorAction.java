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
package br.com.navita.mobile.console.view.connector;

import br.com.navita.mobile.console.domain.WebServiceConnector;
import br.com.navita.mobile.console.service.ConnectorService;
import br.com.navita.mobile.console.view.rawdata.WebServiceConnectorRaw;

public class WebServiceConnectorAction extends ConnectorsAction implements WebServiceConnectorRaw {
	
	private ConnectorService<WebServiceConnector,WebServiceConnectorRaw> webServiceConnectorService;
	private String wsdl;
	
	public void setWebServiceConnectorService(
			ConnectorService<WebServiceConnector, WebServiceConnectorRaw> webServiceConnectorService) {
		this.webServiceConnectorService = webServiceConnectorService;
	}
	
	@Override
	public String getWsdl() {		
		return wsdl;
	}
	public void setWsdl(String wsdl) {
		this.wsdl = wsdl;
	}
	
	public String save() throws Exception{
		if(! baseConnectorService.isTagUniqueForId(tag, id)){
			addActionError("Tag " + tag + " duplicada");
			return edit();
		}
		webServiceConnectorService.update(this);
		addActionMessage("Salvo com sucesso");
		return edit();
	}

	public String create() throws Exception{	
		if(! baseConnectorService.isTagUnique(tag)){
			addActionError("Tag " + tag + " duplicada");
			return preCreate();
		}
		connector =	webServiceConnectorService.create(this);
		addActionMessage("Criado com sucesso");
		id = connector.getId();
		return edit();
	}
}
