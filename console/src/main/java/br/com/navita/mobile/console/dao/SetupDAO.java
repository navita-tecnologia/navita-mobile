package br.com.navita.mobile.console.dao;

public interface SetupDAO {	

	int countAuthTable();

	void createAuthTable();

	void createConstraint();

	void createUsersTable();

	int countUsersTable();
	
	int countAdmin();
	
	void insertAdmin();

	int countAppsTable();
	
	int countAppsExecTable();

	int countConfigTable();

	void createAppsTable();
	
	void createAppsExecTable();

	void createConfigTable();
	
	void updateAdminPasswd(String passwd);
}
