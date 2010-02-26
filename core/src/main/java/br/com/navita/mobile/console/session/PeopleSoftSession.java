package br.com.navita.mobile.console.session;

import java.util.UUID;

import psft.pt8.joa.ISession;


public class PeopleSoftSession extends MobileSession{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	private ISession psSession;

	public PeopleSoftSession(ISession psSession) {
		this.psSession = psSession;
		this.innerSession = psSession;
		this.token = UUID.randomUUID().toString();
	}

	public ISession getPsSession() {
		return psSession;
	}

	@Override
	public long getTimeout() {		
		return QUINZE_MINUTOS;
	}
	

	@Override
	public void release() {
		if(psSession !=null){
			psSession.disconnect();
			psSession = null;
		}
		

	}

}
