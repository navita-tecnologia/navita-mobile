package br.com.navita.mobile.ps;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import psft.pt8.joa.IPSMessage;
import psft.pt8.joa.IPSMessageCollection;
import psft.pt8.joa.ISession;
import psft.pt8.joa.JOAException;


public abstract class AbstractPeoplesoftService {

	private static final Logger log = Logger.getLogger(AbstractPeoplesoftService.class.getName());

	protected static final Map<String, Object> SESSION_POOL = Collections.synchronizedMap(new LinkedHashMap<String, Object>());

	protected void errorHandler(ISession session) throws Exception{
		if(session == null || ( !session.getErrorPending() && !session.getWarningPending())){
			return;
		}

		IPSMessageCollection oPSMessageCollection;
		IPSMessage oPSMessage;

		oPSMessageCollection = session.getPSMessages();
		long nMessages = oPSMessageCollection.getCount();
		if(nMessages == 0){
			return;
		}

		StringBuffer buf = new StringBuffer();

		for (int i = 0; i < nMessages; i++) {
			oPSMessage = oPSMessageCollection.item(i);				
			if (oPSMessage != null){
				buf.append("\n[" + oPSMessage.getMessageSetNumber() + "," + oPSMessage.getMessageSetNumber() + "] : " + oPSMessage.getText());

			}
		}


		oPSMessageCollection.deleteAll();
		log.log(Level.SEVERE,buf.toString());
		throw new PeopleSoftException(buf.toString());

	}

	protected Object getComponentInterface(String ciName, String token, boolean initialize) throws PeopleSoftException {
		log.log(Level.INFO,"Buscando CI: " + ciName + " para session " + token);
		ISession session = (ISession) SESSION_POOL.get(token);
		if(session == null){			
			throw new PeopleSoftException("Null Session");
		}
		Object component = null;
		try {
			component = session.getCompIntfc(ciName);			
		} catch (JOAException e) {			
			throw new PeopleSoftException(e);
		}

		if(component==null){
			throw new PeopleSoftException("Componente " + ciName + " nao foi inicializado com sucesso.");
		}

		setModes(session,component, initialize);
		if(component != null){
			log.log(Level.INFO,"CI: " + ciName + " para session " + token + " retornou " + component.getClass().getName());
		}

		return component;
	}

	/**
	 * 
	 * @param component
	 * @param initialize
	 * @throws Exception
	 */
	private void setModes(ISession session, Object component, boolean initialize) throws PeopleSoftException{
		try{
			Method m=null;
			m=component.getClass().getMethod("setInteractiveMode", boolean.class );
			m.invoke(component, new Object[]{true});
			m=component.getClass().getMethod("setGetHistoryItems", boolean.class );
			m.invoke(component, new Object[]{true});
			m=component.getClass().getMethod("setEditHistoryItems", boolean.class );
			m.invoke(component, new Object[]{false});
			if(initialize){
				m=component.getClass().getMethod("get");				
				if(!(Boolean) m.invoke(component)){
					errorHandler(session);
				}
			}
		}catch (Exception e) {
			throw new PeopleSoftException(e);
		}
	}

}
