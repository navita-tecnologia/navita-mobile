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
