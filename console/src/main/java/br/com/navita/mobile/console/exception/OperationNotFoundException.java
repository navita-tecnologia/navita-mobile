package br.com.navita.mobile.console.exception;

public class OperationNotFoundException extends SapGatewayException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OperationNotFoundException(String operation) {
		super("Operacao '"+operation+"' nao encontrada");
	}

	public OperationNotFoundException(Exception e) {
		super(e);
	}

}
