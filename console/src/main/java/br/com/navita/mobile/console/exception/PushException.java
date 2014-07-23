package br.com.navita.mobile.console.exception;

import br.com.navita.mobile.exception.NavitaMobileError;




public class PushException extends NavitaMobileError {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PushException() {
		super();
		
	}

	public PushException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public PushException(String message) {
		super(message);
		
	}

	public PushException(Throwable cause) {
		super(cause);
		
	}

}
