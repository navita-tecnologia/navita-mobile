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

import java.util.Properties;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.navita.mobile.console.domain.SapConnector;
import br.com.navita.mobile.console.exception.InvalidTokenSapGatewayException;
import br.com.navita.mobile.console.exception.SapGatewayException;
import br.com.navita.mobile.console.operator.sap.SapSession;
import br.com.navita.mobile.console.session.SessionPool;

import com.sap.mw.jco.JCO;
import com.sap.mw.jco.JCO.Function;

public class PoolManager {

	private static final Logger LOG = Logger.getLogger(PoolManager.class.getName());



	public static SapSession createSession(String login, String passwd, SapConnector connector) throws SapGatewayException {
		String token = login+"-"+UUID.randomUUID();
		Properties p = new Properties();

		p.setProperty("jco.client.user", login);
		p.setProperty("jco.client.passwd", passwd);
		p.setProperty("jco.client.client", connector.getClient());
		p.setProperty("jco.client.sysnr", connector.getSysnr());
		p.setProperty("jco.client.ashost", connector.getAsHost());
		p.setProperty("jco.client.lang", connector.getLang());
		//sap:///H/200.32.97.5/H/172.16.1.57?client=800&sysnr=IDE

		JCO.addClientPool(token,10,p);
		JCO.Repository repo = new JCO.Repository(connector.getClient(),token);
		JCO.Client client = JCO.getClient(token);
		JCO.Function f = repo.getFunctionTemplate("STFC_CONNECTION").getFunction();
		f.getImportParameterList().setValue( token ,"REQUTEXT");
		client.execute(f);
		JCO.releaseClient(client);
		SapSession session = new SapSession(repo,token);
		session.setTimeStamp(System.currentTimeMillis());
		SessionPool.put(token, session);
		LOG.log(Level.WARNING,"Session criada para "+login+" em " + connector.getAsHost() + ":" + connector.getSysnr()+ ":" + connector.getClient());
		return session;
	}

	private static SapSession getSession(String token) throws SapGatewayException{
		SapSession session = (SapSession) SessionPool.get(token);
		if(session==null){
			throw new InvalidTokenSapGatewayException("Invalid token "+token);
		}
		session.setTimeStamp(System.currentTimeMillis());
		return session;
	}
	public static JCO.Function createFunction(String name,String token) throws SapGatewayException{
		SapSession session = getSession(token);
		JCO.Repository repo = session.getRepository();
		LOG.log(Level.WARNING,"Criando function "+name);
		return (Function) repo.getFunctionTemplate(name).getFunction();
	}
}
