package br.com.navita.mobile.console.dao;

import javax.sql.DataSource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class SetupDAOImpl implements SetupDAO {
	
	private JdbcTemplate jdbcTemplate;
	private String sqlUserExists;
	private String sqlAuthExists;
	private String sqlAdminExists;
	private String sqlCreateUsers;
	private String sqlCreateAuth;
	private String sqlAlterUserAndAuth;
	private String sqlAppExists;
	private String sqlAppExecExists;
	private String sqlConfigExists;
	private String sqlCreateApp;
	private String sqlCreateAppExec;
	private String sqlCreateConfig;
	
	public void setSqlAppExecExists(String sqlAppExecExists) {
		this.sqlAppExecExists = sqlAppExecExists;
	}
	
	public void setSqlCreateAppExec(String sqlCreateAppExec) {
		this.sqlCreateAppExec = sqlCreateAppExec;
	}

	
	public void setSqlAppExists(String sqlAppExists) {
		this.sqlAppExists = sqlAppExists;
	}


	public void setSqlConfigExists(String sqlConfigExists) {
		this.sqlConfigExists = sqlConfigExists;
	}


	public void setSqlCreateApp(String sqlCreateApp) {
		this.sqlCreateApp = sqlCreateApp;
	}


	public void setSqlCreateConfig(String sqlCreateConfig) {
		this.sqlCreateConfig = sqlCreateConfig;
	}


	public void setSqlAdminExists(String sqlAdminExists) {
		this.sqlAdminExists = sqlAdminExists;
	}
	
	
    public void setSqlUserExists(String sqlUserExists) {
		this.sqlUserExists = sqlUserExists;
	}


	public void setSqlAuthExists(String sqlAuthExists) {
		this.sqlAuthExists = sqlAuthExists;
	}


	public void setSqlCreateUsers(String sqlCreateUsers) {
		this.sqlCreateUsers = sqlCreateUsers;
	}


	public void setSqlCreateAuth(String sqlCreateAuth) {
		this.sqlCreateAuth = sqlCreateAuth;
	}


	public void setSqlAlterUserAndAuth(String sqlAlterUserAndAuth) {
		this.sqlAlterUserAndAuth = sqlAlterUserAndAuth;
	}


	public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

	@Override
	public int countAuthTable() {		
		return jdbcTemplate.queryForInt(sqlAuthExists);
	}


	@Override
	public int countUsersTable() {		
		return jdbcTemplate.queryForInt(sqlUserExists);
	}


	@Override
	public void createAuthTable() {
		jdbcTemplate.execute(sqlCreateAuth);
		
	}


	@Override
	public void createConstraint() {
		jdbcTemplate.execute(sqlAlterUserAndAuth);
		
	}


	@Override
	public void createUsersTable() {
		jdbcTemplate.execute(sqlCreateUsers);
		
	}


	@Override
	public void insertAdmin() {
		jdbcTemplate.execute("INSERT INTO USERS VALUES('admin','7c78301074032f9b67c20a19695502aa',1) ");
		jdbcTemplate.execute("INSERT INTO AUTHORITIES VALUES('admin','ROLE_USER')");
		jdbcTemplate.execute("INSERT INTO AUTHORITIES VALUES('admin','ROLE_ADMINISTRATOR')");		
		
	}
	
	@Override
	public void updateAdminPasswd(String passwd) {
		String md5Hash = DigestUtils.md5Hex(passwd);
		md5Hash = md5Hash.toLowerCase();
		jdbcTemplate.execute("UPDATE USERS SET password = '"+md5Hash+"' WHERE username = 'admin'");
		
	}


	@Override
	public int countAdmin() {		
		return jdbcTemplate.queryForInt(sqlAdminExists);
	}


	@Override
	public int countAppsTable() {
		return jdbcTemplate.queryForInt(sqlAppExists);
	}


	@Override
	public int countConfigTable() {
		return jdbcTemplate.queryForInt(sqlConfigExists);
	}


	@Override
	public void createAppsTable() {
		
		jdbcTemplate.execute(sqlCreateApp);
		
	}


	@Override
	public void createConfigTable() {
		
		jdbcTemplate.execute(sqlCreateConfig);
	}

	@Override
	public int countAppsExecTable() {
		return jdbcTemplate.queryForInt(sqlAppExecExists);
	}

	@Override
	public void createAppsExecTable() {
		jdbcTemplate.execute(sqlCreateAppExec);
		
	}

	

}
