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
package br.com.navita.mobile.console.exception;

/**
 * Exceção lançada quando é realizada um busca por id em uma entidade inexistente ou que
 * o usuário não possui permissões para visualizar.
 *
 * @author Guilherme Birckan
 */
public class EntityNotFoundException extends AbstractApplicationException {

	private static final long serialVersionUID = 1L;

	/* Atributos ******************************************************************************* */

	/** Classe da entidade solicitada */
	private Class<?> entityClass;

	/** Identificador solicitado */
	private String entityId;

	/** Versão da entidade (se versionável), senão permance <code>null</code> */
	private Integer entityVersion;

	/* Construtores **************************************************************************** */

	/**
	 * @param entityClass
	 * @param entityId
	 */
	public EntityNotFoundException(Class<?> entityClass, String entityId) {
		super();
		this.entityClass = entityClass;
		this.entityId = entityId;
	}

	/**
	 * @param entityClass
	 * @param entityId
	 * @param msg
	 */
	public EntityNotFoundException(Class<?> entityClass, String entityId, String msg) {
		super(msg);
		this.entityClass = entityClass;
		this.entityId = entityId;
	}

	/**
	 * @param entityClass
	 * @param entityId
	 * @param entityVersion
	 */
	public EntityNotFoundException(Class<?> entityClass, String entityId, Integer entityVersion) {
		super();
		this.entityClass = entityClass;
		this.entityId = entityId;
		this.entityVersion = entityVersion;
	}

	/**
	 * @param entityClass
	 * @param entityId
	 * @param entityVersion
	 * @param msg
	 */
	public EntityNotFoundException(Class<?> entityClass, String entityId, Integer entityVersion, String msg) {
		super(msg);
		this.entityClass = entityClass;
		this.entityId = entityId;
		this.entityVersion = entityVersion;
	}

	/* Getters/Setters ************************************************************************* */

	/**
	 * @return
	 */
	public Class<?> getEntityClass() {
		return entityClass;
	}

	/**
	 * @param entityClass
	 */
	public void setEntityClass(Class<?> entityClass) {
		this.entityClass = entityClass;
	}

	/**
	 * @return
	 */
	public String getEntityId() {
		return entityId;
	}

	/**
	 * @param entityId
	 */
	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	/**
	 * @return
	 */
	public Integer getEntityVersion() {
		return entityVersion;
	}

	/**
	 * @param entityVersion
	 */
	public void setEntityVersion(Integer entityVersion) {
		this.entityVersion = entityVersion;
	}

	/**
	 * @see java.lang.Throwable#toString()
	 */
	@Override
	public String toString() {
		return " Id: '" + entityId + "'";
	}
}