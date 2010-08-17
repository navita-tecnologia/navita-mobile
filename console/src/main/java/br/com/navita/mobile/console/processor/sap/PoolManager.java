package br.com.navita.mobile.console.processor.sap;

import java.util.Properties;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.navita.mobile.console.exception.InvalidTokenSapGatewayException;
import br.com.navita.mobile.console.exception.SapGatewayException;
import br.com.navita.mobile.console.session.SessionPool;

import com.sap.mw.jco.JCO;
import com.sap.mw.jco.JCO.Function;

public class PoolManager {
	
	private static final Logger LOG = Logger.getLogger(PoolManager.class.getName());

	
		
	public static SapSession createSession(String login, String passwd,String url) throws SapGatewayException {
		String token = login+"-"+UUID.randomUUID();
		Properties p = new Properties();
		SapUrl sapUrl = SapUrl.parse(url);
		p.setProperty("jco.client.user", login);
		p.setProperty("jco.client.passwd", passwd);
		p.setProperty("jco.client.client", sapUrl.getClient());
		p.setProperty("jco.client.sysnr", sapUrl.getSysNr());
		p.setProperty("jco.client.ashost", sapUrl.getAsHost());
		p.setProperty("jco.client.lang", sapUrl.getLang());
		//sap:///H/200.32.97.5/H/172.16.1.57?client=800&sysnr=IDE
		
		JCO.addClientPool(token,10,p);
		JCO.Repository repo = new JCO.Repository(sapUrl.getClient(),token);		
		JCO.Client client = JCO.getClient(token);
		JCO.Function f = repo.getFunctionTemplate("STFC_CONNECTION").getFunction();
		f.getImportParameterList().setValue( token ,"REQUTEXT");
		client.execute(f);
		JCO.releaseClient(client);
		SapSession session = new SapSession(repo,token);
		session.setTimeStamp(System.currentTimeMillis());
		SessionPool.put(token, session);
		LOG.log(Level.WARNING,"Session criada para "+login+" em "+url);
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
