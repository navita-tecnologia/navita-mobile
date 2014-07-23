package br.com.navita.mobile.console.exception;

import br.com.navita.mobile.exception.NavitaMobileError;



public class UnresolvedReturnTypeException extends NavitaMobileError {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnresolvedReturnTypeException() {
		super();
		
	}

	public UnresolvedReturnTypeException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public UnresolvedReturnTypeException(String message) {
		super(message);
		
	}

	public UnresolvedReturnTypeException(Throwable cause) {
		super(cause);
		
	}

}
