package br.com.navita.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
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
		BufferedReader r = new BufferedReader(new FileReader("c:\\temp\\insert.c3.sql"));
		String linha = "";
		long i = 0;
		while((linha = r.readLine()) != null){
			i++;
			if(i > -1){
				System.out.println(i + ": " + linha);
				st.executeUpdate(linha);
			}
		}
		cn.close();
		r.close();

	}

}
