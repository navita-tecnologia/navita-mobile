package br.com.navita.mobile.console.view;

import br.com.navita.mobile.console.domain.entity.Operation;
import br.com.navita.mobile.console.service.BaseOperationService;

public class OperationsAction extends OperationRawActionSupport {

	protected BaseOperationService<Operation> basOperationService;
	protected Operation operation;

	public void setBasOperationService(
			BaseOperationService<Operation> basOperationService) {
		this.basOperationService = basOperationService;
	}

	public String edit() throws Exception{
		operation = basOperationService.findById(id);
		if(operation != null){
			return operation.getClass().getSimpleName();	
		}

		return null;
	}

}
