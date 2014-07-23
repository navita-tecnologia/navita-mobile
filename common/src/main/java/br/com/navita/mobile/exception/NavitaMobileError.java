package br.com.navita.mobile.exception;

/**
 * 
 * @author mpguedes
 *
 */
public class NavitaMobileError extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NavitaMobileError() {
		super();
		
	}

	public NavitaMobileError(String message, Throwable cause) {
		super(message, cause);
		
	}

	public NavitaMobileError(String message) {
		super(message);
		
	}

	public NavitaMobileError(Throwable cause) {
		super(cause);
		
	}

}
