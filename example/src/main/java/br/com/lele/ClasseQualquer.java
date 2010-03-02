package br.com.lele;

import java.util.Map;

import psft.pt8.joa.IPSMessage;
import psft.pt8.joa.IPSMessageCollection;
import psft.pt8.joa.ISession;

import br.com.navita.mobile.domain.MobileBean;
import br.com.navita.mobile.remote.MobileService;


public class ClasseQualquer implements MobileService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public MobileBean execute(Map<String, Object> params) {
		MobileBean bean = new MobileBean();
		bean.setObject(new Object[]{"v1","v2",234});
		ErrorHandler();
		return bean;
	}
	
	public static ISession oSession;

	public static void ErrorHandler() {
		if(oSession == null){
			return;
		}
		//***** Display PeopleSoft Error Messages *****
		if (oSession.getErrorPending() || oSession.getWarningPending()) {
			IPSMessageCollection oPSMessageCollection;
			IPSMessage oPSMessage;

			oPSMessageCollection = oSession.getPSMessages();
			for (int i = 0; i < oPSMessageCollection.getCount(); i++) {
				oPSMessage = oPSMessageCollection.item(i);
				if (oPSMessage != null)
					System.out.println("(" + oPSMessage.getMessageSetNumber() + "," + oPSMessage.getMessageSetNumber() + ") : " + oPSMessage.getText());
			}
			//***** Done processing messages in the collection; OK to delete *****
			oPSMessageCollection.deleteAll();
		}
	}

}
