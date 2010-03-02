package br.com.navita.mobile.ps;


public class PeopleSoftException extends Exception {

	public PeopleSoftException(String message) {
		super(message);
	}

	
	public PeopleSoftException(Exception e) {
		super(e);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
