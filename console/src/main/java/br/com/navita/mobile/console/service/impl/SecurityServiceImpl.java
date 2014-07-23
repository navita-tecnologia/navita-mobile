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
