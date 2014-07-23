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
package br.com.navita.mobile.console.listener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SetupListener implements ServletContextListener {
	private static final Logger LOG = Logger.getLogger(SetupListener.class.getName());

	private JdbcTemplate jdbcTemplate;

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
		jdbcTemplate = new JdbcTemplate((DataSource) context.getBean("dataSource"));
		try {
			if(!isEmbedded()){
				LOG.warning("Tabelas do Navita Mobile localizadas em banco de dados externo");
				return;
			}
		} catch (SQLException e) {
			LOG.log(Level.SEVERE,"Error seting up database",e);
			return;
		}
		if(!isDbCreated()){
			LOG.warning("Criando tabelas do Navita Mobile...");
			String[] sql = loadFromDDL();
			jdbcTemplate.batchUpdate(sql);
			LOG.warning("Navita Mobile criado com sucesso");
		}else{
			LOG.warning("Tabelas do Navita Mobile criadas anteriormente");
		}

	}

	private boolean isEmbedded() throws SQLException {
		DatabaseMetaData data = jdbcTemplate.getDataSource().getConnection().getMetaData();
		return data.getDatabaseProductName().contains("Derby");
	}

	private String[] loadFromDDL() {
		InputStream is = null;
		BufferedReader bf = null;
		List<String> sql = new ArrayList<String>();
		StringBuffer tmpBuffer = new StringBuffer();
		try{
			is = SetupListener.class.getClassLoader().getResourceAsStream("embedded-db.ddl");
			bf = new BufferedReader(new InputStreamReader(is));
			String line = "";
			while((line = bf.readLine()) != null){
				tmpBuffer.append(line).append('\n');
				if(line.endsWith(";")){
					sql.add(tmpBuffer.toString().replace(";", ""));
					tmpBuffer = new StringBuffer();
				}
			}

		} catch (IOException e) {
			LOG.log(Level.SEVERE,"Error reading embedded-db.ddl",e);
		}finally{
			if(bf != null){
				try {
					bf.close();
				} catch (IOException e) {

				}
			}
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {

				}
			}

		}


		return sql.toArray(new String[sql.size()]);
	}

	private boolean isDbCreated() {
		Integer tbctrl  = null;
		try{
			tbctrl = jdbcTemplate.queryForInt("select f from CONTROLTB");
		}catch (Throwable e) {
			if (e.getCause() instanceof SQLSyntaxErrorException){
				return false;
			}
		}
		return tbctrl != null &&  tbctrl.equals(1);

	}

}
