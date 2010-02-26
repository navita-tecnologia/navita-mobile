package br.com.navita.mobile.console.view;

import java.util.List;

import org.apache.struts2.dispatcher.DefaultActionSupport;

import br.com.navita.mobile.console.bizz.LdapService;
import br.com.navita.mobile.console.bizz.LoginService;
import br.com.navita.mobile.console.bizz.MSWindowsLoginService;
import br.com.navita.mobile.console.dao.LdapConfigDAO;
import br.com.navita.mobile.console.domain.LdapConfig;
import br.com.navita.mobile.console.domain.LoginResult;
import br.com.navita.mobile.console.domain.UserGroup;
import br.com.navita.mobile.exception.NavitaMobileError;


public class DomainsAction extends DefaultActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<LdapConfig> dominios;
	public LdapConfig ldapConfig;
	private LdapConfigDAO ldapConfigDAO;
	private String serviceId;
	private String testUser;
	private String testPasswd;

	private LoginService msLoginService;
	public void setMsLoginService(LoginService msLoginService) {
		this.msLoginService = msLoginService;
	}

	private LdapService ldapService;
	public void setLdapService(LdapService ldapService) {
		this.ldapService = ldapService;
	}
	

	public String getTestUser() {
		return testUser;
	}


	public void setTestUser(String testUser) {
		this.testUser = testUser;
	}


	public String getTestPasswd() {
		return testPasswd;
	}


	public void setTestPasswd(String testPasswd) {
		this.testPasswd = testPasswd;
	}


	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public List<LdapConfig> getDominios() {
		return dominios;
	}

	public LdapConfig getLdapConfig() {
		return ldapConfig;
	}
	public void setLdapConfig(LdapConfig ldapConfig) {
		this.ldapConfig = ldapConfig;
	}


	public void setLdapConfigDAO(LdapConfigDAO ldapConfigDAO) {
		this.ldapConfigDAO = ldapConfigDAO;
	}

	@Override
	public String execute() throws Exception {
		dominios = ldapConfigDAO.listServices();
		return super.execute();
	}

	public String edit() {		
		ldapConfig  = ldapConfigDAO.getServiceProperties(serviceId);
		return INPUT;

	}

	public String save() throws NavitaMobileError {		
		ldapConfigDAO.saveService(ldapConfig, ldapConfig.getId());
		if(ldapConfig.getPassword()!=null && ! ldapConfig.getPassword().isEmpty()){
			addActionMessage("Senha alterada com sucesso");
		}
		addActionMessage("Salvo com sucesso");

		ldapConfig  = ldapConfigDAO.getServiceProperties(ldapConfig.getId());
		return INPUT;
	}

	public String remove() throws Exception{
		ldapConfigDAO.removeService(serviceId);	
		addActionMessage("Removido com sucesso");
		return execute();
	}

	public String createPrepare() {
		return "createPrepare";
	}
	public String create() throws NavitaMobileError {
		ldapConfigDAO.saveService(ldapConfig, null);
		dominios = ldapConfigDAO.listServices();
		addActionMessage("Criado com sucesso");
		return SUCCESS;
	}

	public String test(){
		ldapConfig  = ldapConfigDAO.getServiceProperties(ldapConfig.getId());
		((MSWindowsLoginService)msLoginService).setConfig(ldapConfig);
		LoginResult result = null;
		try {
			result =  msLoginService.login(testUser,testPasswd);
			if(result!=null && ! result.isLogged()){
				addActionError(result.getMessage());
			}
			if(result!=null && result.isLogged()){
				addActionMessage("Login realizado com sucesso");
				
			}
			if(result==null){
				addActionError("login failed");
			}
			List<UserGroup> groups = ldapService.getUserGroups(testUser, ldapConfig);
			addActionMessage(groups.toString());
			
		} catch (Exception e) {
			addActionError(e.getMessage());
		}



		return 	INPUT;
	}
}
