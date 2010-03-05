package br.com.navita.mobile.ps;

import java.util.Map;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import psft.pt8.joa.API;
import psft.pt8.joa.ISession;

import br.com.navita.mobile.domain.MobileBean;

public class LoginPeopleSoft extends AbstractPeoplesoftService {

	private static final long serialVersionUID = 1L;
	
	
	private static final Logger log = Logger.getLogger(LoginPeopleSoft.class.getName());
	
	
	@Override
	public MobileBean execute(Map<String, Object> paramMap) {
		MobileBean bean = new MobileBean();
		String user = (String) paramMap.get("login");
		String passwd = (String) paramMap.get("passwd");
		log.log(Level.INFO,"Conectando user: " + user);
		try {
				ISession session = API.createSession();
				if(!session.connect(1, getServerPath(), user, passwd, null)){
					errorHandler(session);
				}
				String token = UUID.randomUUID().toString();
				log.log(Level.INFO,"Salvando sessao com id " + token);
				SESSION_POOL.put(token, session);			
				bean.setToken(token);
				log.log(Level.INFO,"Bean com token " + token + " retornado com sucesso");
		} catch (Exception e) {
			log.log(Level.SEVERE,"Erro ao executar login peoplesoft",e);
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
