package br.com.navita.mobile.duke.automidia;

import br.com.navita.mobile.AppResources;
import br.com.navita.mobile.domain.MobileBean;
import br.com.navita.mobile.remote.MobileService;
import br.com.navita.mobile.xparse.Node;
import br.com.navita.mobile.xparse.Xparse;

public abstract class BaseAutomidiaProcessor implements MobileService, AppResources {
	
	private static final long serialVersionUID = 1L;

	protected String assertNotOnError(String rawXML) {
		if(rawXML == null){
			return null;
		}
		Xparse xp = new Xparse();
		Node root = xp.parse(rawXML);
		Node errorNode=root.find("DataSet/diffgram/Error", new int[]{1,1,1});
		if(errorNode != null){
			String message = errorNode.find("Error/MESSAGE", new int[]{1,1}).getCharacters();	
			return message;
		}


		return null;
	}
	
	protected MobileBean getFailBean(int code, Throwable t){
		MobileBean bean = new MobileBean();
		bean.setResultCode(code);
		bean.setObject(t);
		bean.setMessage(t.getMessage()==null?t.toString():t.getMessage());		
		return bean;
	}
	
	protected MobileBean getFailBean(int code, String message) {		
		MobileBean bean = new MobileBean();
		bean.setResultCode(code);		
		bean.setMessage(message);		
		return bean;
	}
}
