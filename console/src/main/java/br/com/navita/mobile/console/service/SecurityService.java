package br.com.navita.mobile.console.service;

import br.com.navita.mobile.console.exception.MobileConsoleException;

public interface SecurityService {

	void updatePassword(String login, String password) throws MobileConsoleException;

	boolean passwordMatch(String userName, String typedPassword);
}
