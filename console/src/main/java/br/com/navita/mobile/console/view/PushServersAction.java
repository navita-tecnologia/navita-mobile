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

import java.util.List;

import br.com.navita.mobile.console.domain.Application;
import br.com.navita.mobile.console.domain.PushServer;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.service.ApplicationService;
import br.com.navita.mobile.console.service.PushServerService;
import br.com.navita.mobile.console.view.rawdata.PushServerRaw;

public class PushServersAction extends RawActionSupport implements PushServerRaw {
	
	protected PushServerService pushServerService;
	protected ApplicationService applicationService;
	private PushServer pushServer;
	
	private String url;
	private String applicationId;
	private String port;
	private String tag;
	
	
	public void setApplicationService(ApplicationService applicationService) {
		this.applicationService = applicationService;
	}
	
	public void setPushServerService(PushServerService pushServerService) {
		this.pushServerService = pushServerService;
	}
	
	public void setPushServer(PushServer pushServer) {
		this.pushServer = pushServer;
	}
	
	public PushServer getPushServer() {
		return pushServer;
	}
	
	
	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
	
	@Override
	public String getTag() {		
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public List<PushServer> getPushServers(){
		return pushServerService.listbyApplicationId(applicationId);
	}
	
	public Application getApplication() throws EntityNotFoundException{
		return applicationService.findbyId(applicationId);
	}

	public String prepareCreate() {
		pushServer = new PushServer();
		id = pushServer.getId();
		return INPUT;
	}
	
	public String create() throws Exception{
		pushServer = pushServerService.create(this);
		id = pushServer.getId();
		addActionMessage("Criado com sucesso");
		return edit();
	}
	
	public String edit() throws Exception {
		pushServer = pushServerService.findById(id);
		return INPUT;
	}

	public String save() throws Exception{
		pushServer = pushServerService.save(this);
		addActionMessage("Salvo com sucesso");
		return INPUT;
	}
	
	public String delete() throws Exception{
		pushServerService.remove(id);		
		addActionMessage("Removido com sucesso");
		return SUCCESS;
	}
	
}
