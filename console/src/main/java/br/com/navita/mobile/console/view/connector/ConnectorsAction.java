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

import java.util.List;

import br.com.navita.mobile.console.domain.Application;
import br.com.navita.mobile.console.domain.AuthContainer;
import br.com.navita.mobile.console.domain.Connector;

public class ConnectorsAction extends ConnectorRawActionSupport {
	
	private String type;
	private String operationId;
	private Application app;
	
	public Application getApp() {
		return app;
	}
	
	public void setApp(Application app) {
		this.app = app;
	}
	
	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}
	
	public String getOperationId() {
		return operationId;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public List<Connector> getAllConnectors(){
		return baseConnectorService.listByApp(applicationId);
	}
	
	public List<AuthContainer> getAuthContainers(){
		return authContainerService.listAll();
	}
	
	public String remove() throws Exception{
		baseConnectorService.remove(id);
		addActionMessage("Removido com sucesso");		
		return execute();
	}
	
	public String removeOperation() throws Exception{
		baseOperationService.remove(operationId);
		addActionMessage("Removido com sucesso");		
		return edit();
	}
	
	public String edit() throws Exception{
		connector = baseConnectorService.findById(id);
		return connector.getClass().getSimpleName();		
	}
	
	public String prepareCreate(){		
		return INPUT;
	}
	
	public String preCreate() throws Exception{
		app = applicationService.findbyId(applicationId);
		connector = (Connector) Class.forName("br.com.navita.mobile.console.domain."+type).newInstance();
		return type;
	}


	@Override
	public String execute() throws Exception {		
		app = applicationService.findbyId(applicationId);		
		return SUCCESS;
	}
	
	
	
}
