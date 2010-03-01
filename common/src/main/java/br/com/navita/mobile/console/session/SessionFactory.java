package br.com.navita.mobile.console.session;

import br.com.navita.mobile.erp.people.PeopleSoftException;
import br.com.navita.mobile.erp.people.PeopleSoftUtil;
import psft.pt8.joa.API;
import psft.pt8.joa.ISession;

//TODO: trazer as conexoes SAP para esta factory
public abstract class SessionFactory {

	public static MobileSession createSession( String login, String passwd, MobileSession.Type type, String serverPath) throws Exception{
		if(type.equals(MobileSession.Type.PEOPLE_SOFT_SESSION)){			
			return createPeopleSession(login, passwd,serverPath);
		}
		
		return null;
	
	}

	private static MobileSession createPeopleSession(String login, String passwd, String serverPath) throws PeopleSoftException{
		ISession oSession;
		oSession = API.createSession();

		boolean result = oSession.connect(1, serverPath, login, passwd, null); 

		if (! result ) {			
			PeopleSoftUtil.errorHandler("Falha ao conectar",oSession);			
		}
		
		return null;
		
	}
}
