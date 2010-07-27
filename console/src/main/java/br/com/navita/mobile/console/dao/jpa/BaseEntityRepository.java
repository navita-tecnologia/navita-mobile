package br.com.navita.mobile.console.dao.jpa;

import java.util.List;

import br.com.navita.mobile.console.model.BaseEntity;

/**
 * DAO genérico, utilizado para todas as entidades que não possuem um DAO especializado
 * identificado pela anotação <code>DAOClass</code>.
 *
 * @author Guilherme Birckan
 * @see com.navita.portal.master.dao.util.DAOClass
 */
public interface BaseEntityRepository<T extends BaseEntity> extends GenericRepository<T> {

	/**
	 * @param name
	 * @return
	 */
	T findByUniqueName(String name);

	/**
	 * @param name
	 * @return
	 */
	List<T> findByNonUniqueName(String name);

	

}