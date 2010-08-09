package br.com.navita.mobile.console.service.impl;

import br.com.navita.mobile.console.dao.jpa.OperationRepository;
import br.com.navita.mobile.console.domain.entity.Operation;
import br.com.navita.mobile.console.exception.EntityNotFoundException;

public class BaseOperationService implements br.com.navita.mobile.console.service.BaseOperationService<Operation>{

	private OperationRepository<Operation> operationRepository;
	public void setOperationRepository(
			OperationRepository<Operation> operationRepository) {
		this.operationRepository = operationRepository;
	}
	
	
	@Override
	public Operation findById(String id) throws EntityNotFoundException {		
		return operationRepository.findById(id);
	}

}
