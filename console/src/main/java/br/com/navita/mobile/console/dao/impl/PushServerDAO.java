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
