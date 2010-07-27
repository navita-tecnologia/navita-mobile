package br.com.navita.mobile.console.dao.jpa;

import java.util.List;

import br.com.navita.mobile.console.exception.EntityNotFoundException;

/**
 * DAO genérico, utilizado para todas as entidades que não possuem um DAO especializado
 * identificado pela anotação <code>DAOClass</code>.
 *
 * @author Guilherme Birckan
 * @see com.navita.portal.master.dao.util.DAOClass
 */
public interface GenericRepository<T> {

	/**
	 * @param id
	 * @return
	 */
	T findById(String id) throws EntityNotFoundException;

	/**
	 * @return
	 */
	List<T> findAll();

	/**
	 * @param entity
	 */
	void persist(T entity);

	/**
	 * @param <X>
	 * @param entity
	 * @return
	 */
	<X> X merge(X entity);

	/**
	 * @param entity
	 */
	void remove(T entity);
}