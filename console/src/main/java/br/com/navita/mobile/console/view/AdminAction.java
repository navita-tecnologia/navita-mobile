package br.com.navita.mobile.console.view;

import org.apache.struts2.dispatcher.DefaultActionSupport;

import br.com.navita.mobile.console.service.SecurityService;


public class AdminAction extends DefaultActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String password;
	
	private String currentPassword;
	
	private String retypePassword;
	
	private SecurityService securityService;
	
	public void setSecurityService(SecurityService securityService) {
		this.securityService = securityService;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	
	
	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getRetypePassword() {
		return retypePassword;
	}

	public void setRetypePassword(String retypePassword) {
		this.retypePassword = retypePassword;
	}

	@Override
	public String execute() throws Exception {				
		return SUCCESS;
	}
	
	
	
	public String changeAdminPassword() throws Exception {
		if(null == password || ! password.equals(retypePassword) || ! securityService.passwordMatch(currentPassword,password)){			
			addActionMessage("Senhas nao coincidem");
			return SUCCESS;
		}
		
		securityService.updatePassword("admin", password);
		addActionMessage("Senha alterada com sucesso");
		return SUCCESS;
	}
	

}
