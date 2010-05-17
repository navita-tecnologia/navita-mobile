package br.com.navita.mobile.console.bizz;

import br.com.navita.mobile.console.exception.MobileConsoleException;

public interface SecurityService {

	void updatePassword(String login, String password) throws MobileConsoleException;
}
