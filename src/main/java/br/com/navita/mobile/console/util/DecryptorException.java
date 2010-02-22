package br.com.navita.mobile.console.util;

import java.io.IOException;

public class DecryptorException extends IOException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DecryptorException() {
		
	}

	public DecryptorException(String message) {
		super(message);		
	}

	public DecryptorException(Throwable cause) {
		super(cause);		
	}

	public DecryptorException(String message, Throwable cause) {
		super(message, cause);
	}

}
