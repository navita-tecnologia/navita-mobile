package br.com.navita.mobile.console.dao;

import javax.sql.DataSource;

import org.apache.commons.configuration.DatabaseConfiguration;

public class NavitaMobileConfiguration extends DatabaseConfiguration {

	public NavitaMobileConfiguration(DataSource datasource, String table,
			String keyColumn, String valueColumn) {
		super(datasource, table, keyColumn, valueColumn);
		
	}
	public void setDelimiterParsingDisabled(){
		setDelimiterParsingDisabled(true);
	}

}
