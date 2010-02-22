package br.com.navita.mobile.console.bizz;

import java.util.List;

import javax.naming.NamingException;

import br.com.navita.mobile.console.domain.LdapConfig;
import br.com.navita.mobile.console.domain.UserGroup;


public interface LdapService {
	List<UserGroup> getUserGroups(String login, LdapConfig config) throws NamingException;
	List<String> getGroupLogins(String group, LdapConfig config) throws NamingException;
}
