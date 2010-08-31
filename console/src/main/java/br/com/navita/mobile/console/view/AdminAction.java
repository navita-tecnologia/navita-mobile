package br.com.navita.mobile.console.view;

import org.apache.struts2.dispatcher.DefaultActionSupport;

import br.com.navita.mobile.console.service.SecurityService;


public class AdminAction extends DefaultActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String password;
	
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
	
	@Override
	public String execute() throws Exception {				
		return SUCCESS;
	}
	
	
	
	public String changeAdminPassword() throws Exception {
		securityService.updatePassword("admin", password);
		addActionMessage("Senha alterada com sucesso");
		return SUCCESS;
	}
	

}
