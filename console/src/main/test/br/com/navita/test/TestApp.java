package br.com.navita.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class TestApp {

	/**
	 * @param args
	 * @throws Throwable 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws Throwable  {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataSource ds = (DataSource) ctx.getBean("dataSource");
		Connection cn = ds.getConnection();
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
