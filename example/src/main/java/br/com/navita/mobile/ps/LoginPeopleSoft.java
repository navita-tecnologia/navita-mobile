package br.com.navita.mobile.ps;

import java.util.Map;
import java.util.ResourceBundle;
import java.util.UUID;

import psft.pt8.joa.API;
import psft.pt8.joa.ISession;

import br.com.navita.mobile.domain.MobileBean;
import br.com.navita.mobile.remote.MobileService;


public class LoginPeopleSoft extends AbstractPeoplesoftService  implements MobileService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public MobileBean execute(Map<String, Object> paramMap) {
		MobileBean bean = new MobileBean();
		String user = (String) paramMap.get("login");
		String passwd = (String) paramMap.get("passwd");
		try {
				ISession session = API.createSession();
				if(!session.connect(1, getServerPath(), user, passwd, null)){
					errorHandler(session);
				}
				String token = UUID.randomUUID().toString();
				SESSION_POOL.put(token, session);			
				bean.setToken(token);
				
		} catch (Exception e) {
			bean.setMessage(e.getMessage());
			bean.setResultCode(1);
			return bean;
		}
		
		return bean;
	}
	private final String getServerPath(){
		ResourceBundle bundle = ResourceBundle.getBundle("plugin");
		return bundle.getString("jolt.url");
	}

}
