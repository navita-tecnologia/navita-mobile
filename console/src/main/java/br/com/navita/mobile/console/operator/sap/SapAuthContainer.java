package br.com.navita.mobile.console.operator.sap;

import java.util.List;
import java.util.logging.Logger;

import javax.naming.NamingException;

import br.com.navita.mobile.console.domain.LoginResult;
import br.com.navita.mobile.console.domain.UserGroup;
import br.com.navita.mobile.console.domain.entity.AuthContainer;
import br.com.navita.mobile.console.domain.entity.SapConnector;
import br.com.navita.mobile.console.exception.SapGatewayException;

public class SapAuthContainer extends AuthContainer{
	private static final Logger LOG = Logger.getLogger(SapAuthContainer.class.getName());
	private SapConnector connector;

	public SapAuthContainer(SapConnector connector) {
		this.connector = connector;
	}

	@Override
	public List<String> getGroupLogins(String group) throws NamingException {

		return null;
	}

	@Override
	public List<UserGroup> getUserGroups(String login) throws NamingException {

		return null;
	}

	@Override
	public LoginResult login(String user, String passwd) {

		String sessionToken = "";
		String message = "";		
		LoginResult loginResult = new LoginResult();

		LOG.info("logon de "+user);
		SapSession session;
		try {
			session = PoolManager.createSession(user,passwd,connector);
		} catch (SapGatewayException e) {
			loginResult.setLogged(false);
			loginResult.setMessage(e.getMessage());
			loginResult.setToken("");
			return loginResult;
		}
		sessionToken = session.getToken();
		LOG.info("logon de " + user + " retornando token " + sessionToken);



		loginResult.setMessage(message);
		loginResult.setToken(sessionToken);

		return loginResult;
	}

}
