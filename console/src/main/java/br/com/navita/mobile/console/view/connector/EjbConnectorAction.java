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

import br.com.navita.mobile.console.domain.EjbConnector;
import br.com.navita.mobile.console.service.ConnectorService;
import br.com.navita.mobile.console.view.rawdata.EjbConnectorRaw;

public class EjbConnectorAction extends ConnectorsAction implements EjbConnectorRaw {

	private ConnectorService<EjbConnector,EjbConnectorRaw> ejbConnectorService;
	
	private String ejbName;
	
	public void setEjbConnectorService(
			ConnectorService<EjbConnector, EjbConnectorRaw> ejbConnectorService) {
		this.ejbConnectorService = ejbConnectorService;
	}

	public String save() throws Exception{	
		if(! baseConnectorService.isTagUniqueForId(tag, id)){
			addActionError("Tag " + tag + " duplicada");
			return edit();
		}
		ejbConnectorService.update(this);
		addActionMessage("Salvo com sucesso");
		return edit();
	}

	public String create() throws Exception{
		if(! baseConnectorService.isTagUnique(tag)){
			addActionError("Tag " + tag + " duplicada");
			return preCreate();
		}
		connector =	ejbConnectorService.create(this);
		addActionMessage("Criado com sucesso");
		id = connector.getId();
		return edit();
	}

	public String getEjbName() {
		return ejbName;
	}
	
	public void setEjbName(String ejbName) {
		this.ejbName = ejbName;
	}
}
