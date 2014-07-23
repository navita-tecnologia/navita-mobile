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
		if(null == password || ! password.equals(retypePassword) || ! securityService.passwordMatch("admin",currentPassword)){			
			addActionMessage("Senhas nao coincidem");
			return SUCCESS;
		}
		
		securityService.updatePassword("admin", password);
		addActionMessage("Senha alterada com sucesso");
		return SUCCESS;
	}
	

}
