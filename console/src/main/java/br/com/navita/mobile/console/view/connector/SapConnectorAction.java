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

import br.com.navita.mobile.console.domain.SapConnector;
import br.com.navita.mobile.console.service.ConnectorService;
import br.com.navita.mobile.console.view.rawdata.SapConnectorRaw;

public class SapConnectorAction extends ConnectorsAction implements SapConnectorRaw{
	private ConnectorService<SapConnector,SapConnectorRaw> sapConnectorService;
	
	private String asHost;
	private String sysnr;
	private String client;
	private String router;
	private String lang;
	
	public void setSapConnectorService(
			ConnectorService<SapConnector, SapConnectorRaw> sapConnectorService) {
		this.sapConnectorService = sapConnectorService;
	}
	
	@Override
	public String getLang() {
		
		return lang;
	}
	
	public void setLang(String lang) {
		this.lang = lang;
	}
	
	@Override
	public String getAsHost() {
		return asHost;
	}
	public void setAsHost(String asHost) {
		this.asHost = asHost;
	}
	
	@Override
	public String getSysnr() {
		return sysnr;
	}
	public void setSysnr(String sysnr) {
		this.sysnr = sysnr;
	}
	
	@Override
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	
	@Override
	public String getRouter() {
		return router;
	}
	public void setRouter(String router) {
		this.router = router;
	}
	
	public String save() throws Exception{	
		if(! baseConnectorService.isTagUniqueForId(tag, id)){
			addActionError("Tag " + tag + " duplicada");
			return edit();
		}
		sapConnectorService.update(this);
		addActionMessage("Salvo com sucesso");
		return edit();
	}

	public String create() throws Exception{		
		if(! baseConnectorService.isTagUnique(tag)){
			addActionError("Tag " + tag + " duplicada");
			return preCreate();
		}
		connector =	sapConnectorService.create(this);
		addActionMessage("Criado com sucesso");
		id = connector.getId();
		return edit();
	}
	
	
}
