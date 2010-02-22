package br.com.navita.mobile.console.bizz;


import br.com.navita.mobile.console.dao.SetupDAO;

public class SetupBusinessImpl implements SetupBusiness {

	private SetupDAO setupDAO;

	public void setSetupDAO(SetupDAO setupDAO) {
		this.setupDAO = setupDAO;
	}

	@Override
	public boolean authExists() {		
		return setupDAO.countAuthTable() > 0;
	}

	@Override
	public void createAuth() {
		setupDAO.createAuthTable();
	}


	@Override
	public void createUsers() {
		setupDAO.createUsersTable();

	}

	@Override
	public boolean usersExists() {		
		return setupDAO.countUsersTable() > 0;
	}

	@Override
	public void insertAdmin() {		
			setupDAO.insertAdmin();		

	}

	@Override
	public boolean adminExists() {
		
		return setupDAO.countAdmin() > 0;
	}

	@Override
	public boolean appsExists() {
		
		return setupDAO.countAppsTable() > 0;
	}

	@Override
	public boolean configExists() {
		return setupDAO.countConfigTable() > 0;
	}

	@Override
	public void createApps() {
		setupDAO.createAppsTable();
		
	}

	@Override
	public void createConfig() {
		setupDAO.createConfigTable();
		
	}

	@Override
	public boolean appsExecExists() {
		
		return setupDAO.countAppsExecTable() > 0;
	}

	@Override
	public void createAppsExec() {
		setupDAO.createAppsExecTable();
		
	}

	




}
