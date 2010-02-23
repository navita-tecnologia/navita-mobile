package br.com.lele;

import br.com.navita.mobile.console.session.MobileSession;
import br.com.navita.mobile.console.session.SessionPool;

public class PeopleSoftSession implements MobileSession {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String token ;	
	private long timestamp;
	

	@Override
	public long getTimeout() {		
		return QUINZE_MINUTOS;
	}

	@Override
	public long getTimestamp() {
		return timestamp;
	}

	@Override
	public String getToken() {		
		return token;
	}

	@Override
	public void release() {		
		SessionPool.remove(token);

	}

}
