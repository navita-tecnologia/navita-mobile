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
package br.com.navita.mobile.console.view.operation;

import br.com.navita.mobile.console.domain.StaticOperation;
import br.com.navita.mobile.console.service.OperationService;
import br.com.navita.mobile.console.view.rawdata.StaticOperationRaw;

public class StaticOperationAction extends OperationsAction implements StaticOperationRaw {
	protected OperationService<StaticOperation, StaticOperationRaw> staticOperationService;

	private String list;
	private String message;
	private String object;
	private int resultCode;
	private String token;
	
	public void setStaticOperationService(
			OperationService<StaticOperation, StaticOperationRaw> staticOperationService) {
		this.staticOperationService = staticOperationService;
	}
	
	@Override
	public String getList() {
		return list;
	}
	public void setList(String list) {
		this.list = list;
	}
	@Override
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	@Override
	public int getResultCode() {
		return resultCode;
	}
	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}
	@Override
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	public String save() throws Exception {
		if(! baseOperationService.isTagUniqueForIdAndConnector(tag, id, connectorId)){
			addActionError("Tag " + tag + " existe em outra operação deste mesmo conector");
			return edit();
		}
		staticOperationService.update(this);
		addActionMessage("Salvo com sucesso");
		return edit();
	}
	
	public String create() throws Exception {
		if(! baseOperationService.isTagUniqueForConnector(tag, connectorId)){
			addActionError("Tag " + tag + " existe em outra operação deste mesmo conector");
			return prepareCreate();
		}

		operation = staticOperationService.create(this);
		id = operation.getId();
		addActionMessage("Criado com sucesso");
		return edit();
	}
	
	
}
