/*
 * Copyright 2014 Navita Tecnologia.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
