package br.com.navita.mobile.ps;

import java.util.Map;
import java.util.ResourceBundle;

import br.com.navita.mobile.console.deployable.DynamicExecutor;
import br.com.navita.mobile.console.domain.MobileBean;


public class LoginPeopleSoft  implements DynamicExecutor{

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
