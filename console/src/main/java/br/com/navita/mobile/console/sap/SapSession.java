package br.com.navita.mobile.console.sap;

import java.io.Serializable;

import com.sap.mw.jco.JCO;

public class SapSession implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String token ;	
	private long timestamp;
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



	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}


}
