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
package br.com.navita.mobile.console.service.impl;

import java.sql.SQLException;

import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;

import br.com.navita.mobile.console.dao.SecurityDAO;
import br.com.navita.mobile.console.exception.MobileConsoleException;
import br.com.navita.mobile.console.service.SecurityService;

public class SecurityServiceImpl implements SecurityService {
	
	private SecurityDAO securityDAO;
	private MessageDigestPasswordEncoder md5PasswordEncoder;
	
	public void setSecurityDAO(SecurityDAO securityDAO) {
		this.securityDAO = securityDAO;
	}
	
	public void setMd5PasswordEncoder(MessageDigestPasswordEncoder md5PasswordEncoder) {
		this.md5PasswordEncoder = md5PasswordEncoder;
	}

	@Override
	public void updatePassword(String login, String password) throws MobileConsoleException {
	
		try {
			securityDAO.updatePassword(login, md5PasswordEncoder.encodePassword(password, null));
		} catch (SQLException e) {
			throw new MobileConsoleException(e);
		}
		

	}

	@Override
	public boolean passwordMatch(String userName, String typedPassword) {
		String currentPassword = securityDAO.findUserById(userName).getPassword();
		String md5TypedPassword = md5PasswordEncoder.encodePassword(typedPassword, null);		
		return currentPassword != null && currentPassword.equalsIgnoreCase(md5TypedPassword);
	}

}
