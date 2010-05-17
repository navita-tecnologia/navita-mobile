package br.com.navita.mobile.console.bizz;

import java.sql.SQLException;

import org.springframework.security.providers.encoding.Md5PasswordEncoder;

import br.com.navita.mobile.console.dao.SecurityDAO;
import br.com.navita.mobile.console.exception.MobileConsoleException;

public class SecurityServiceImpl implements SecurityService {
	
	private SecurityDAO securityDAO;
	private Md5PasswordEncoder md5PasswordEncoder;
	
	public void setSecurityDAO(SecurityDAO securityDAO) {
		this.securityDAO = securityDAO;
	}
	
	public void setMd5PasswordEncoder(Md5PasswordEncoder md5PasswordEncoder) {
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

}