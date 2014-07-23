package br.com.navita.mobile.console.session;
import java.io.Serializable;


public abstract class MobileSession implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected long UM_SEGUNDO = 1000L;
	protected long UM_MINUTO = 60L * UM_SEGUNDO;
	protected long QUINZE_MINUTOS = 15L * UM_MINUTO;
	
	protected String token;
	protected long timeStamp;
	protected Object innerSession;
	
	protected enum Type{
		SAP_SESSION,
		PEOPLE_SOFT_SESSION
	}
	
	public Object getInnerSession() {
		return innerSession;
	}

	public void setInnerSession(Object innerSession) {
		this.innerSession = innerSession;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	/**
	 * encerra a sessao liberando os recursos
	 */
	public abstract void release();
	
	/**
	 * Inatividade maxima permitida para esta sessao
	 * @return
	 */
	public abstract long getTimeout();
	
	
}
