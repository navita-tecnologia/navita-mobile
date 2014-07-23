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

import br.com.navita.mobile.console.domain.DataSourceQueryOperation;
import br.com.navita.mobile.console.service.OperationService;
import br.com.navita.mobile.console.view.rawdata.DataSourceQueryOperationRaw;

public class DataSourceQueryOperationAction extends OperationsAction implements DataSourceQueryOperationRaw {
	
	private OperationService<DataSourceQueryOperation, DataSourceQueryOperationRaw> dataSourceQueryOperationService;
	
	public void setDataSourceQueryOperationService(
			OperationService<DataSourceQueryOperation, DataSourceQueryOperationRaw> dataSourceQueryOperationService) {
		this.dataSourceQueryOperationService = dataSourceQueryOperationService;
	}

	private String query;
	private boolean returnResultSet;
	
	public void setReturnResultSet(boolean returnResultSet) {
		this.returnResultSet = returnResultSet;
	}
	
	
	
	public String getQuery() {
		return query;
	}
	
	public void setQuery(String query) {
		this.query = query;
	}
	
	public String save() throws Exception {
		if(! baseOperationService.isTagUniqueForIdAndConnector(tag, id, connectorId)){
			addActionError("Tag " + tag + " existe em outra operação deste mesmo conector");
			return edit();
		}
		dataSourceQueryOperationService.update(this);
		addActionMessage("Salvo com sucesso");
		return edit();
	}
	public String create() throws Exception {
		if(! baseOperationService.isTagUniqueForConnector(tag, connectorId)){
			addActionError("Tag " + tag + " existe em outra operação deste mesmo conector");
			return prepareCreate();
		}
		operation = dataSourceQueryOperationService.create(this);
		id = operation.getId();
		addActionMessage("Criado com sucesso");
		return edit();
	}

	@Override
	public boolean isReturnResultSet() {
		
		return returnResultSet;
	}
	
	
}
