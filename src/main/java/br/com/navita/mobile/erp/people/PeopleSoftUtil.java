package br.com.navita.mobile.erp.people;

import psft.pt8.joa.API;
import psft.pt8.joa.IPSMessage;
import psft.pt8.joa.IPSMessageCollection;
import psft.pt8.joa.ISession;
import psft.pt8.joa.JOAException;
import br.com.navita.mobile.console.session.MobileSession;
import br.com.navita.mobile.console.session.PeopleSoftSession;
import br.com.navita.mobile.console.session.SessionPool;


public abstract class PeopleSoftUtil {
	
	
	public static final PeopleSoftSession getConnectedSession(String serverPath, String user, String passwd) throws PeopleSoftException{
		ISession oSession = API.createSession();

		boolean result = oSession.connect(1, serverPath, user, passwd, null); 

		if (! result ) {			
			errorHandler("Falha ao conectar", oSession);
			return null;
		}
		
		PeopleSoftSession psSession = new PeopleSoftSession(oSession);
		SessionPool.put(psSession.getToken(), psSession);	
		
		return psSession;
	}
	
	
	public static final void errorHandler(String baseMessage, String token) throws PeopleSoftException{
		MobileSession ms = SessionPool.get(token);
		if(ms != null){
			errorHandler(baseMessage, (ISession) ms.getInnerSession());
		}
		
	}
	
	public static final void errorHandler(String baseMessage, ISession oSession) throws PeopleSoftException{
		if(oSession == null){
			return;
		}
		StringBuffer message = new StringBuffer(baseMessage);
		if (oSession.getErrorPending() || oSession.getWarningPending()) {
			IPSMessageCollection oPSMessageCollection;
			IPSMessage oPSMessage;

			oPSMessageCollection = oSession.getPSMessages();

			for (int i = 0; i < oPSMessageCollection.getCount(); i++) {
				oPSMessage = oPSMessageCollection.item(i);
				if (oPSMessage != null)
					message
					.append("\n")
					.append("(")
					.append(oPSMessage.getMessageSetNumber())					
					.append(") : ")
					.append(oPSMessage.getText());
			}
			//***** Done processing messages in the collection; OK to delete *****
			oPSMessageCollection.deleteAll();
			throw new PeopleSoftException(message.toString());
		}
	}
	
	
	public static Object getComponentInterface(String name, String token) throws PeopleSoftException, JOAException{
		MobileSession ms = SessionPool.get(token);
		if(ms == null){
			throw new PeopleSoftException(token + " is not a valid token");
		}
		ms.setTimeStamp(System.currentTimeMillis());
		ISession oSession = (ISession)ms.getInnerSession();

		if(oSession == null){
			throw new PeopleSoftException("Not conected");
		}
		
		return oSession.getCompIntfc(name);
	}
}
