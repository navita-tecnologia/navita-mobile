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