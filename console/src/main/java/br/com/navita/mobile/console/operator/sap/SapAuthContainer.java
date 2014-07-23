/*
 * Copyright 2014 Navita Tecnologia.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.navita.mobile.console.operator.sap;

import java.util.List;
import java.util.logging.Logger;

import javax.naming.NamingException;

import br.com.navita.mobile.console.domain.AuthContainer;
import br.com.navita.mobile.console.domain.LoginResult;
import br.com.navita.mobile.console.domain.SapConnector;
import br.com.navita.mobile.console.domain.UserGroup;
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
		loginResult.setLogged(true);

		return loginResult;
	}

}
