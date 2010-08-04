package br.com.navita.mobile.console.dao.jpa.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.navita.mobile.console.dao.jpa.OperationRepository;
import br.com.navita.mobile.console.domain.entity.Operation;
import br.com.navita.mobile.console.domain.entity.StaticOperation;

public class StaticOperationDAO extends GenericJpaDAO<Operation> implements OperationRepository<StaticOperation>{

	@Override
	public List<StaticOperation> listConnectorOperations(String connectorId) {
		String ql = "FROM StaticOperation where connector.id = :connectorId";
		TypedQuery<StaticOperation> query = entityManager.createQuery(ql,StaticOperation.class);
		query.setParameter("connectorId", connectorId);		
		return query.getResultList();
	}
	
}
