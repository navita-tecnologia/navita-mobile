package br.com.navita.mobile.console.view;

import br.com.navita.mobile.console.domain.entity.Operation;
import br.com.navita.mobile.console.service.BaseOperationService;

public class OperationsAction extends OperationRawActionSupport {

	protected BaseOperationService<Operation> baseOperationService;
	protected Operation operation;
	protected String operationType;
	
	public String getOperationType() {
		return operationType;
	}
	
	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public void setBaseOperationService(
			BaseOperationService<Operation> baseOperationService) {
		this.baseOperationService = baseOperationService;
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
		return operationType; 
	}

}
