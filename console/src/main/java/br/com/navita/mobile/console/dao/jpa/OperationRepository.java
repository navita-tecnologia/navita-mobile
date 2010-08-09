package br.com.navita.mobile.console.dao.jpa;

import java.util.List;

import br.com.navita.mobile.console.domain.entity.Operation;

public interface OperationRepository<T extends Operation> extends GenericRepository<Operation> {
	List<T> listConnectorOperations(String connectorId);	
}
