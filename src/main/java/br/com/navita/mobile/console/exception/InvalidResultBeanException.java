package br.com.navita.mobile.console.exception;

import br.com.navita.mobile.exception.NavitaMobileError;

public class InvalidResultBeanException extends NavitaMobileError{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidResultBeanException() {
		super();
		
	}

	public InvalidResultBeanException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public InvalidResultBeanException(String message) {
		super(message);
		
	}

	public InvalidResultBeanException(Throwable cause) {
		super(cause);
		
	}
	
	

}
