package br.com.navita.mobile.console.bizz;

import br.com.navita.mobile.console.domain.LoginResult;

public interface LoginService {

	LoginResult login(String user, String passwd);
	
}
