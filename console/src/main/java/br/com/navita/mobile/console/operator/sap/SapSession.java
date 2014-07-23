package br.com.navita.mobile.console.operator.sap;

import br.com.navita.mobile.console.session.MobileSession;

import com.sap.mw.jco.JCO;

public class SapSession extends MobileSession {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JCO.Repository repository;




	public JCO.Repository getRepository() {
		return repository;
	}



	public void setRepository(JCO.Repository repository) {
		this.repository = repository;
	}



	public SapSession(JCO.Repository repository, String token) {
		this.repository = repository;
		this.token = token;
	}


	@Override
	public void release() {
		JCO.removeClientPool(token);				
	}



	@Override
	public long getTimeout() {		
		return QUINZE_MINUTOS;
	}


}
