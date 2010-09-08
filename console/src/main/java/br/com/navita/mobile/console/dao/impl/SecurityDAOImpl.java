package br.com.navita.mobile.console.dao.impl;

import java.sql.SQLException;


import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import br.com.navita.mobile.console.dao.SecurityDAO;

public class SecurityDAOImpl implements SecurityDAO{
	
	private JdbcTemplate jdbcTemplate;	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override	
	public void updatePassword(String login, String password) throws SQLException {
		
		jdbcTemplate.update("update users set password = ? where username = ?", new Object[]{password,login});
		
	}

}
