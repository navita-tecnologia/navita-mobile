package br.com.navita.mobile.console.exception;

import br.com.navita.mobile.exception.NavitaMobileError;

public class InvalidMobileUrlException extends NavitaMobileError {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidMobileUrlException(String url) {
		super(url);
	}

	public InvalidMobileUrlException() {
		super();
		
	}

	public InvalidMobileUrlException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public InvalidMobileUrlException(Throwable cause) {
		super(cause);
		
	}

}
