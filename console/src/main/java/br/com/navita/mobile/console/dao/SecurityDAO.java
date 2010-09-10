package br.com.navita.mobile.console.dao;

import java.sql.SQLException;

import br.com.navita.mobile.console.domain.User;

public interface SecurityDAO {

	void updatePassword(String login, String password) throws SQLException;

	User findUserById(String userName);
}
