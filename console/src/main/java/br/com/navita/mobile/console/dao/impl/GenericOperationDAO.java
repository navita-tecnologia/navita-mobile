/*
 * Copyright 2014 Navita Tecnologia.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.navita.mobile.console.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.navita.mobile.console.dao.OperationRepository;
import br.com.navita.mobile.console.domain.Operation;

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
