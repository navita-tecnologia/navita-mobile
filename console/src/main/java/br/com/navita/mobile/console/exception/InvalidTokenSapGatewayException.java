package br.com.navita.mobile.console.exception;



public class InvalidTokenSapGatewayException extends SapGatewayException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidTokenSapGatewayException() {
		super();
		
	}

	public InvalidTokenSapGatewayException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public InvalidTokenSapGatewayException(String message) {
		super(message);
		
	}

	public InvalidTokenSapGatewayException(Throwable cause) {
		super(cause);
		
	}

}
