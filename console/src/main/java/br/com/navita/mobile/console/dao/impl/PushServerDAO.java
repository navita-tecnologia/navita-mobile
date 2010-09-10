package br.com.navita.mobile.console.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.navita.mobile.console.dao.PushServerRepository;
import br.com.navita.mobile.console.domain.PushServer;

public class PushServerDAO extends GenericJpaDAO<PushServer> implements PushServerRepository<PushServer>{

	@Override
	public List<PushServer> listPushServerByAppId(String appId) {
		
		String ql = "from PushServer where upper(application.id) = upper(:appId)";
		TypedQuery<PushServer> q = getEntityManager().createQuery(ql, PushServer.class);		
		q.setParameter("appId", appId);
		return q.getResultList();
	}

	@Override
	public PushServer findByTag(String tag) {
		String ql = "from PushServer where tag = :tag";
		TypedQuery<PushServer> q = getEntityManager().createQuery(ql, PushServer.class);		
		q.setParameter("tag", tag);
		return q.getSingleResult();
	}

	
	


}
