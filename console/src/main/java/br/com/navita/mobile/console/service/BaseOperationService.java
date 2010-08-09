package br.com.navita.mobile.console.service;

import br.com.navita.mobile.console.domain.entity.Operation;
import br.com.navita.mobile.console.exception.EntityNotFoundException;

public interface BaseOperationService<T extends Operation> {
	T findById(String id) throws EntityNotFoundException;
	
}
