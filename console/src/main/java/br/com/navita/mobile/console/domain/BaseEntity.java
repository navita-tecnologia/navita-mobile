package br.com.navita.mobile.console.domain;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;


/**
 * Entidade base herdada por todas as demais entidades do sistema.
 *
 * @author Guilherme Birckan
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Transient
	protected transient final Logger logger = Logger.getLogger(BaseEntity.class.getName());

	/* Atributos ******************************************************************************* */

	/** Identificador UUID, 32 caracteres hexadecimais sem separadores */
	@Id @Column(length = 32)
	private String id;

	
	/** Nome da entidade */
	@Column(nullable = false)
	private String name;

	/* Construtores **************************************************************************** */

	/**
	 * Construtor padrão, seta UUID fresquinho para novas entidades.
	 */
	public BaseEntity() {
		super();		
		generateNewId();
	}

	/* Contratos ******************************************************************************* */

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
	@Override
    public boolean equals(Object someObject) {
        if (this == someObject) {
        	return true;
        }
        if ((someObject == null) || !(someObject instanceof BaseEntity)) {
            return false;
        }
        if (getId() == null) {
        	return false;
        }
        return getId().equals(((BaseEntity) someObject).getId());
    }

    /**
     * @see java.lang.Object#hashCode()
     */
	@Override
    public int hashCode() {
    	return (getId() != null) ? getId().hashCode() : super.hashCode();
    }

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Classe: " + this.getClass().getSimpleName() + " | Id: " + this.id + " | Nome: " + this.name;
	}

	

	/**
	 * Gera um novo identificador para esta entidade.
	 */
	private void generateNewId() {
		this.id = UUID.randomUUID().toString().replaceAll("-", "");;
	}

	/**
	 * Cria uma cópia disconexa do objeto, copiando diretamente todas suas propriedades.
	 *
	 * @param attachedObj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T extends BaseEntity> T createDetachedCopy() {
		BaseEntity attachedObj = this;
		T detachedObj = null;
		try {
			detachedObj = (T) attachedObj.getClass().newInstance();
			Method[] methods = attachedObj.getClass().getMethods();
			for (Method method : methods) {
				if (method.getName().startsWith("get") && !"getClass".equals(method.getName())) {
					Method getter = method;
					String setterName = getter.getName().replaceFirst("get", "set");
					Class argumentType = getter.getReturnType();
					try {
						Object returnVal = getter.invoke(attachedObj, new Object[] {});
						if (returnVal != null) {
							if (returnVal instanceof List) {
								List list = new ArrayList();
								for (Object item : ((Collection) returnVal).toArray()) {
									list.add(item);
								}
								returnVal = list;
							} else if (returnVal instanceof Set) {
								Set set = new HashSet();
								for (Object item : ((Collection) returnVal).toArray()) {
									set.add(item);
								}
								returnVal = set;
							}
							Method setter = detachedObj.getClass().getMethod(setterName, argumentType);
							setter.invoke(detachedObj, returnVal);
						}
					} catch (NoSuchMethodException e) {
						logger.fine(e.getMessage());
					}
				}
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return detachedObj;
	}

	/* Getters/Setters ************************************************************************* */

	/**
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}


}
