package br.com.navita.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeviceDataLoader {

	/**
	 * @param args
	 * @throws Throwable 
	 */
	public static void main(String[] args) throws Throwable {
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		Connection cn = DriverManager.getConnection("jdbc:jtds:sqlserver://nvtweb01.navita.com.br:1433","nvt-mobile","banana01");
		Statement st = cn.createStatement();
		BufferedReader r = new BufferedReader(new FileReader("C:\\temp\\insert.register.translator.sql"));
		String linha = "";
		while((linha = r.readLine()) != null){
			System.out.println(linha);
			st.executeUpdate(linha);
		}
		cn.close();
		r.close();

	}

}
