package br.com.navita.mobile.console.service;

import br.com.navita.mobile.console.domain.Operation;
import br.com.navita.mobile.console.exception.EntityNotFoundException;

public interface BaseOperationService<T extends Operation> {
	T findById(String id) throws EntityNotFoundException;
	void remove(String id) throws EntityNotFoundException;
	boolean isTagUniqueForConnector(String tag,String connectorId)throws EntityNotFoundException;
	boolean isTagUniqueForIdAndConnector(String tag,String operationId, String connectorId)throws EntityNotFoundException;
	T findByTagAndConnectorId(String connectorId, String operationTag);
}
