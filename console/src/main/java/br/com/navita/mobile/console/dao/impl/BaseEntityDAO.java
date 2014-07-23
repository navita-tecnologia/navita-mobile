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

import br.com.navita.mobile.console.dao.BaseEntityRepository;
import br.com.navita.mobile.console.domain.BaseEntity;
import br.com.navita.mobile.console.exception.EntityNotFoundException;

/**
 * @author Guilherme Birckan
 */
public class BaseEntityDAO<T extends BaseEntity> extends GenericJpaDAO<T> implements BaseEntityRepository<T> {

	/**
	 *
	 */
	public BaseEntityDAO() {
		super();
	}

	/**
	 * Usado apenas pelo Spring.
	 * @param persistentClass
	 */
	public BaseEntityDAO(Class<T> persistentClass) {
		super(persistentClass);
	}

	/**
	 * @throws EntityNotFoundException
	 * @see com.navita.portal.master.dao.impl.GenericJpaDAO#findById(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public T findById(String id) throws EntityNotFoundException {
		String ql = "SELECT e FROM " + persistentClass.getSimpleName() + " e WHERE (e.id = :id)";
		Query query = getEntityManager().createQuery(ql);
		query.setParameter("id", id);
		//query.setParameter("removed", false);
		try {
			return (T) query.getSingleResult();
		} catch(NoResultException e) {
			throw new EntityNotFoundException(persistentClass, id);
		}

	}

	/**
	 * @see com.navita.portal.master.dao.BaseEntityRepository#findByUniqueName(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public T findByUniqueName(String name) {
		String ql = "SELECT e FROM " + persistentClass.getSimpleName() + " e WHERE (upper(e.name) = upper(:name))";
		Query query = getEntityManager().createQuery(ql);
		query.setParameter("name", name);
		query.setParameter("removed", false);
		try {
			return (T) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	/**
	 * @see com.navita.portal.master.dao.BaseEntityRepository#findByNonUniqueName(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByNonUniqueName(String name) {
		String ql = "SELECT e FROM " + persistentClass.getSimpleName() + " e WHERE  (upper(e.name) LIKE upper(:name))";
		Query query = getEntityManager().createQuery(ql);
		query.setParameter("name", "%" + name + "%");
		query.setParameter("removed", false);
		return query.getResultList();
	}

	
	/**
	 * @see com.navita.portal.master.dao.impl.GenericJpaDAO#findAll()
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		String ql = "SELECT e FROM " + persistentClass.getSimpleName() + " e  ORDER BY upper(e.name)";
		Query query = getEntityManager().createQuery(ql);
		//query.setParameter("removed", false);
		return query.getResultList();
	}

	/**
	 * @see com.navita.portal.master.dao.impl.GenericJpaDAO#remove(java.lang.Object)
	 */
	public void remove(T entity) {
		//entity.remove();
		getEntityManager().remove(entity);
	}
}