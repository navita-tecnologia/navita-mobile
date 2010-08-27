package br.com.navita.mobile.console.dao.jpa.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.navita.mobile.console.dao.jpa.OperationRepository;
import br.com.navita.mobile.console.domain.entity.Operation;

public class GenericOperationDAO<T extends Operation> extends GenericJpaDAO<Operation> implements OperationRepository<T>{

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listConnectorOperations(String connectorId) {
		String ql = "FROM " + persistentClass.getSimpleName() + " where connector.id = :connectorId";
		Query query = getEntityManager().createQuery(ql);
		query.setParameter("connectorId", connectorId);		
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findByTagAndConnectorId(String tag, String connectorId) {		
		String ql = "FROM " + persistentClass.getSimpleName() + " where upper(tag) = upper(:tag) and connector.id = :connectorId ";
		Query query = getEntityManager().createQuery(ql);
		query.setParameter("connectorId", connectorId);
		query.setParameter("tag", tag);
		T operation = null;
		try{
			operation = (T) query.getSingleResult();
		}catch (NoResultException e) {
			
		}
		
		return operation;
	}
	
	
	
}
