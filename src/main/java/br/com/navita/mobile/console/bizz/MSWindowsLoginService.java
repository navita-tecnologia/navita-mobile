package br.com.navita.mobile.console.bizz;

import java.net.UnknownHostException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.NamingException;

import jcifs.UniAddress;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbException;
import jcifs.smb.SmbSession;
import br.com.navita.mobile.console.domain.DomainControler;
import br.com.navita.mobile.console.domain.LdapConfig;
import br.com.navita.mobile.console.domain.LoginResult;


public class MSWindowsLoginService implements LoginService {
	private static final Logger LOG = Logger.getLogger(MSWindowsLoginService.class.getName());

	private LdapService ldapService;
	private LdapConfig config;

	public MSWindowsLoginService() {

	}

	public void setConfig(LdapConfig config) {
		this.config = config;
	}

	public void setLdapService(LdapService ldapService) {
		this.ldapService = ldapService;
	}

	@Override
	public LoginResult login(String user, String passwd) {		

		LoginResult result = new LoginResult();
		UniAddress dcUniAddress = null;
		String hostName = null;
		if(config.isAutoIp()){
			try {
				DomainControler dc = DcResolver.resolveDomainControler(config.getDomainName());
				if(dc == null){
					throw new NullPointerException("Invalid domain controller");
				}
				hostName = dc.getHostName();
			} catch (Exception e) {
				LOG.log(Level.SEVERE,"Error getting auto uniaddress using "+config.getDomainName(),e);
				result.setMessage(e.getMessage());
				return result;
			}
		}else{
			hostName = config.getIp();
		}
		try {
			dcUniAddress = UniAddress.getByName(hostName);
		} catch (UnknownHostException e) {
			LOG.log(Level.SEVERE,"Error getting uniaddress using "+hostName,e);
			result.setMessage(e.getMessage());
			return result;
		}
		NtlmPasswordAuthentication mycreds = new NtlmPasswordAuthentication( config.getDomainName(), user, passwd );
		try {
			LOG.info("Loging in "+config.getDomainName()+"\\"+user+" against "+hostName);
			SmbSession.logon( dcUniAddress, mycreds );
			LOG.info(config.getDomainName()+"\\"+user+" successfully logged in against "+hostName);
		} catch (SmbException e) {
			LOG.log(Level.SEVERE,"Error  loging in "+config.getDomainName()+"\\"+user,e);
			result.setMessage(e.getMessage());
			return result;
		}
		if(null != config.getUser() && !config.getUser().isEmpty()){//FIXME: incluir flag para buscar grupos ou nao!
			try {
				LOG.info("Getting groups from user "+config.getDomainName()+"\\"+user+" against "+hostName);
				result.setGroups(ldapService.getUserGroups(user, config));
				LOG.info("Groups successfully retrieved for user "+config.getDomainName()+"\\"+user+" against "+hostName);
			} catch (NamingException e) {
				LOG.log(Level.SEVERE,"Error getting groups for "+config.getDomainName()+"\\"+user,e);
				result.setMessage(e.getMessage());
				return result;
			}
		}

		result.setLogged(true);
		result.setToken(UUID.randomUUID().toString());

		return result;
	}



}
