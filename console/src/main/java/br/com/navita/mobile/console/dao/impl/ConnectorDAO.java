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
import javax.persistence.TypedQuery;

import br.com.navita.mobile.console.dao.ConnectorRepository;
import br.com.navita.mobile.console.domain.Connector;

public class ConnectorDAO extends GenericJpaDAO<Connector> implements ConnectorRepository<Connector> {

	@Override
	public Connector findByTag(String tag) {
		String ql = "from Connector where upper(tag) = upper(:tag)";
		TypedQuery<Connector> q = getEntityManager().createQuery(ql, Connector.class);		
		q.setParameter("tag", tag);
		Connector connector =  null;
		try{
			connector = q.getSingleResult();
		}catch (NoResultException e) {
			
		}
		
		return connector;
	}

	@Override
	public List<Connector> findByAppId(String appId) {
		String ql = "from Connector where upper(application.id) = upper(:appId)";
		TypedQuery<Connector> q = getEntityManager().createQuery(ql, Connector.class);		
		q.setParameter("appId", appId);
		return q.getResultList();
	}

}
