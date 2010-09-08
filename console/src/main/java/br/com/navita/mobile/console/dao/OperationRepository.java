package br.com.navita.mobile.console.dao;

import java.util.List;

import br.com.navita.mobile.console.domain.Operation;

public interface OperationRepository<T extends Operation> extends GenericRepository<Operation> {
	List<T> listConnectorOperations(String connectorId);	
	T findByTagAndConnectorId(String tag, String connectorId);
}
