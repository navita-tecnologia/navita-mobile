package br.com.navita.mobile.console.service;

import java.util.List;

import br.com.navita.mobile.console.domain.Operation;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.view.rawdata.OperationRaw;

public interface OperationService<T extends Operation,W extends OperationRaw> {
	
	List<T> getConnectorOperations(String connectorId);
	
	T create(W operationRaw) throws EntityNotFoundException;
	void update(W operationRaw) throws EntityNotFoundException;
	void remove(String id) throws EntityNotFoundException;

}
