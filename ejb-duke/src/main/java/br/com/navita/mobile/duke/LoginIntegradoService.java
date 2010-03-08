package br.com.navita.mobile.duke;

import java.util.Map;

import br.com.navita.mobile.AppResources;
import br.com.navita.mobile.domain.MobileBean;
import br.com.navita.mobile.duke.automidia.TokenGeneratorAutomidia;
import br.com.navita.mobile.duke.ps.LoginPeopleSoft;
import br.com.navita.mobile.remote.MobileService;

public class LoginIntegradoService implements MobileService, AppResources {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Recebe login e passwd e gera um token
	 * O automidia ja gera um token, este token sera utilizado 
	 * como id para os dois sistemas: Peoplesoft e Automida
	 * Depois de gerado o token no Automia, conecta-se no People e salva o ISession
	 */
	@Override
	public MobileBean execute(Map<String, Object> params) {
		String login = (String) params.get("login");
		String passwd = (String) params.get("passwd");
		String token = null;
		MobileBean bean = new MobileBean();
		try {			
			token = new TokenGeneratorAutomidia().geToken(login, passwd);
		} catch (Exception e) {
			bean.setResultCode(1);
			bean.setMessage(e.getMessage());
			bean.setObject(e);
			return bean;
		}
		
		params.put("token", token);		
		bean = new LoginPeopleSoft().execute(params);		
		return bean;
	}

	
}
