package br.com.navita.mobile.console.session;
import java.io.Serializable;


public interface MobileSession extends Serializable {
	long UM_SEGUNDO = 1000L;
	long UM_MINUTO = 60L * UM_SEGUNDO;
	long QUINZE_MINUTOS = 15L * UM_MINUTO;
	
	/**
	 * Timestamp da criacao ou reativacao da sessao
	 * @return
	 */	
	long getTimestamp();
	
	/**
	 * id da sessao
	 * @return
	 */
	String getToken();
	
	/**
	 * encerra a sessao liberando os recursos
	 */
	void release();
	
	/**
	 * Inatividade maxima permitida para esta sessao
	 * @return
	 */
	long getTimeout();
	
	
}
