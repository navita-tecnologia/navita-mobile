package br.com.navita.mobile.console.bizz;

import java.util.List;

import javax.naming.NamingException;

import br.com.navita.mobile.console.domain.LoginResult;
import br.com.navita.mobile.console.domain.UserGroup;

public interface LoginAwareService {

	LoginResult login(String user, String passwd);
	List<UserGroup> getUserGroups(String login) throws NamingException;
	List<String> getGroupLogins(String group) throws NamingException;

}
