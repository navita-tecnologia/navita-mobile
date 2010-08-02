package br.com.navita.mobile.console.dao.jpa.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.navita.mobile.console.dao.jpa.BaseEntityRepository;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.model.BaseEntity;

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
		Query query = entityManager.createQuery(ql);
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
		Query query = entityManager.createQuery(ql);
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
		Query query = entityManager.createQuery(ql);
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
		Query query = entityManager.createQuery(ql);
		//query.setParameter("removed", false);
		return query.getResultList();
	}

	/**
	 * @see com.navita.portal.master.dao.impl.GenericJpaDAO#remove(java.lang.Object)
	 */
	public void remove(T entity) {
		//entity.remove();
		entityManager.remove(entity);
	}
}