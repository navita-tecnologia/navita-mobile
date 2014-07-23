package br.com.navita.mobile.console.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;


import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import br.com.navita.mobile.console.domain.User;



public class SecurityDAO implements br.com.navita.mobile.console.dao.SecurityDAO{
	
	private JdbcTemplate jdbcTemplate;	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override	
	public void updatePassword(String login, String password) throws SQLException {
		
		jdbcTemplate.update("update users set password = ? where username = ?", new Object[]{password,login});
		
	}

	@Override
	public User findUserById(String userName) {
		
		return jdbcTemplate.queryForObject("select username, password from users where username = ?", new String[]{userName},new RowMapper<User>(){
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setPassword(rs.getString("password"));
				user.setUsername(rs.getString("username"));
				return user;
			}
		});
	}

}
