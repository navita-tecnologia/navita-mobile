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

import br.com.navita.mobile.console.domain.Operation;

public class OperationsAction extends OperationRawActionSupport {

	
	protected Operation operation;
	protected String operationType;
	
	public Operation getOperation() {
		return operation;
	}
	
	public void setOperation(Operation operation) {
		this.operation = operation;
	}
	
	public String getOperationType() {
		return operationType;
	}
	
	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public String edit() throws Exception{
		operation = baseOperationService.findById(id);
		if(operation != null){
			return operation.getClass().getSimpleName();	
		}

		return null;
	}
	
	public String prepareCreate() throws Exception{
		operation = (Operation) Class.forName( "br.com.navita.mobile.console.domain." + operationType).newInstance();
		operation.setConnector(baseConnectorService.findById(connectorId));
		return operationType; 
	}
	
	

}
