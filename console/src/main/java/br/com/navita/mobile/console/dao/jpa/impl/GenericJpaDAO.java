package br.com.navita.mobile.console.dao.jpa.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.navita.mobile.console.dao.jpa.GenericRepository;
import br.com.navita.mobile.console.exception.EntityNotFoundException;

/**
 * @author Guilherme Birckan
 */
public class GenericJpaDAO<T> implements GenericRepository<T> {

	/** Entidade associada a este DAO */
	protected Class<T> persistentClass;

	@PersistenceContext(unitName = "mobilePersistenceUnit")
	protected EntityManager entityManager;

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
		return entityManager.find(persistentClass, id);
	}

	/**
	 * @see com.navita.portal.master.dao.GenericRepository#findAll()
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		String ql = "FROM " + persistentClass.getSimpleName();
		Query query = entityManager.createQuery(ql);
		return query.getResultList();
	}

	/**
	 * @see com.navita.portal.master.dao.GenericRepository#persist(java.lang.Object)
	 */
	public void persist(T entity) {
		entityManager.persist(entity);
	}

	/**
	 * @see com.navita.portal.master.dao.GenericRepository#merge(java.lang.Object)
	 */
	public <X> X merge(X entity) {
		return entityManager.merge(entity);
	}

	/**
	 * @see com.navita.portal.master.dao.GenericRepository#remove(java.lang.Object)
	 */
	public void remove(T entity) {
		entityManager.remove(entity);
	}
}
