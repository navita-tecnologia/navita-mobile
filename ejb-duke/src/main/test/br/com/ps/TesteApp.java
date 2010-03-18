package br.com.ps;

import java.util.HashMap;
import java.util.Map;

import br.com.navita.mobile.domain.MobileBean;
import br.com.navita.mobile.duke.LoginIntegradoService;

public class TesteApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		LoginIntegradoService service = new LoginIntegradoService();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("login", "fabio");
		params.put("passwd", "lala");
		params.put("bypass.people", "true");
		MobileBean bean = service.execute(params);
		System.out.println(bean.getToken());
		System.out.println(bean.getResultCode());
		System.out.println(bean.getMessage());
		
	}

}
