package br.com.navita.mobile.ps;

import java.util.ResourceBundle;

import br.com.navita.mobile.console.session.MobileSession;
import br.com.navita.mobile.console.session.SessionPool;

import psft.pt8.joa.API;
import psft.pt8.joa.IPSMessage;
import psft.pt8.joa.IPSMessageCollection;
import psft.pt8.joa.ISession;

public class AbstractPeopleSoftExecutor {
	protected ISession oSession;
	
	public void errorHandler(String baseMessage) throws PeopleSoftException{
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

	/**
	 * 
	 * @param serverPath na forma server:port
	 * @param user
	 * @param passwd
	 * @throws PeopleSoftException 
	 */
	protected final boolean connectSession(String serverPath, String user, String passwd) throws PeopleSoftException{

		oSession = API.createSession();

		boolean result = oSession.connect(1, serverPath, user, passwd, null); 

		if (! result ) {			
			errorHandler("Falha ao conectar");
			return false;
		}

		return result;
	}
	
	
	protected final void retrieveConnection(String token) throws PeopleSoftException {
		MobileSession mSession = SessionPool.get(token);
		if(mSession == null){
			throw new PeopleSoftException("Falha ao recuperar session "+token);
		}
		oSession = (ISession) mSession.getInnerSession();
	}

	protected final String getServerPath(){
		ResourceBundle bundle = ResourceBundle.getBundle("plugin");
		return bundle.getString("jolt.url");
	}
}
