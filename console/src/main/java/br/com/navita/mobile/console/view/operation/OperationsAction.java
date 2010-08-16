package br.com.navita.mobile.console.view.operation;

import br.com.navita.mobile.console.domain.entity.Operation;

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
		operation = (Operation) Class.forName( "br.com.navita.mobile.console.domain.entity." + operationType).newInstance();
		operation.setConnector(baseConnectorService.findById(connectorId));
		return operationType; 
	}
	
	

}
