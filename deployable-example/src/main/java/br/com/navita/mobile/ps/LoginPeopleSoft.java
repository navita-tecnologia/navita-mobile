package br.com.navita.mobile.ps;

import java.util.Map;

import br.com.navita.mobile.console.deployable.DynamicExecutor;
import br.com.navita.mobile.console.domain.MobileBean;
import br.com.navita.mobile.console.session.SessionPool;

public class LoginPeopleSoft extends AbstractPeopleSoftExecutor implements DynamicExecutor{

	@Override
	public MobileBean execute(Map<String, Object> paramMap) {
		MobileBean bean = new MobileBean();
		String user = (String) paramMap.get("login");
		String passwd = (String) paramMap.get("passwd");
		try {
			if(connectSession(getServerPath(), user, passwd)){
				PeopleSoftSession psSession = new PeopleSoftSession(oSession);
				SessionPool.put(psSession.getToken(), psSession);				
				bean.setToken(psSession.getToken());
			}
		} catch (PeopleSoftException e) {
			bean.setMessage(e.getMessage());
			bean.setResultCode(1);
			return bean;
		}
		
		return bean;
	}

}
