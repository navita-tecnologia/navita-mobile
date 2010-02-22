package br.com.navita.mobile.console.bizz;

public interface SetupBusiness {

	boolean usersExists();
	boolean authExists();
	boolean adminExists();
	boolean appsExists();
	boolean appsExecExists();
	boolean configExists();
	void createUsers();
	void createAuth();
	void insertAdmin();
	void createApps();
	void createAppsExec();
	void createConfig();
	
}
