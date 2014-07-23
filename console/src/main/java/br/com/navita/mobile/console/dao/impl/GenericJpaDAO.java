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

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.orm.jpa.EntityManagerFactoryUtils;

import br.com.navita.mobile.console.dao.GenericRepository;
import br.com.navita.mobile.console.exception.EntityNotFoundException;

/**
 * @author Guilherme Birckan
 */
public class GenericJpaDAO<T> implements GenericRepository<T> {

	/** Entidade associada a este DAO */
	protected Class<T> persistentClass;
	
	private EntityManagerFactory entityManagerFactory;
	
	public void setEntityManagerFactory(
			EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	
	protected EntityManager getEntityManager() {		
		return EntityManagerFactoryUtils.getTransactionalEntityManager(entityManagerFactory);
	}
	
	
	/**
	 *
	 */
	@SuppressWarnings("unchecked")
	public GenericJpaDAO() {
		// Pega o primeiro tipo parametrizado
		// Ex. GenericRepository<Pessoa>, este metodo vai retornar o Class Pessoa
		persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		
	}

	/**
	 * Usado apenas pelo Spring.
	 * @param persistentClass
	 */
	public GenericJpaDAO(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	/**
	 * @see com.navita.portal.master.dao.GenericRepository#findById(java.lang.String)
	 */
	public T findById(String id) throws EntityNotFoundException {
		return getEntityManager().find(persistentClass, id);
	}

	/**
	 * @see com.navita.portal.master.dao.GenericRepository#findAll()
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		String ql = "FROM " + persistentClass.getSimpleName();
		Query query =  getEntityManager().createQuery(ql);
		return query.getResultList();
	}


	/**
	 * @see com.navita.portal.master.dao.GenericRepository#persist(java.lang.Object)
	 */
	public void persist(T entity) {
		getEntityManager().persist(entity);
	}

	/**
	 * @see com.navita.portal.master.dao.GenericRepository#merge(java.lang.Object)
	 */
	public <X> X merge(X entity) {
		return getEntityManager().merge(entity);
	}

	/**
	 * @see com.navita.portal.master.dao.GenericRepository#remove(java.lang.Object)
	 */
	public void remove(T entity) {
		getEntityManager().remove(entity);
	}
}
