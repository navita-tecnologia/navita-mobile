package br.com.navita.mobile.console.dao;

import java.sql.SQLException;

public interface SecurityDAO {

	void updatePassword(String login, String password) throws SQLException;
}
