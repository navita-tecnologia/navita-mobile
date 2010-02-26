package br.com.navita.mobile.ps;

import java.util.Map;
import java.util.ResourceBundle;

import br.com.navita.mobile.console.deployable.DynamicExecutor;
import br.com.navita.mobile.console.domain.MobileBean;
import br.com.navita.mobile.console.session.PeopleSoftSession;
import br.com.navita.mobile.erp.people.PeopleSoftException;
import br.com.navita.mobile.erp.people.PeopleSoftUtil;

public class LoginPeopleSoft  implements DynamicExecutor{

	@Override
	public MobileBean execute(Map<String, Object> paramMap) {
		MobileBean bean = new MobileBean();
		String user = (String) paramMap.get("login");
		String passwd = (String) paramMap.get("passwd");
		try {
			PeopleSoftSession psSession = PeopleSoftUtil.getConnectedSession(getServerPath(), user, passwd);
			bean.setToken(psSession.getToken());			
		} catch (PeopleSoftException e) {
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
