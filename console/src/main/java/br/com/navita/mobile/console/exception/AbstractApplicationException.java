package br.com.navita.mobile.console.exception;

import java.io.Serializable;

/**
 * Exceções de lógica de negócios devem estender esta classe abstrata.
 *
 * @author Guilherme Birckan
 */
public abstract class AbstractApplicationException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	protected AbstractApplicationException() {
		super();
	}

	/**
	 * @param msg
	 */
	protected AbstractApplicationException(String msg) {
		super(msg);
	}
}
