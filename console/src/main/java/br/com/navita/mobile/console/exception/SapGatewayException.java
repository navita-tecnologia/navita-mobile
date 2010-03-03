package br.com.navita.mobile.console.exception;

import java.io.IOException;

public class SapGatewayException extends IOException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SapGatewayException() {
		super();
		
	}

	public SapGatewayException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public SapGatewayException(String message) {
		super(message);
		
	}

	public SapGatewayException(Throwable cause) {
		super(cause);
		
	}

	

}
