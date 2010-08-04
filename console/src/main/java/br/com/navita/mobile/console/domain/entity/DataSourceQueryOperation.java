package br.com.navita.mobile.console.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class DataSourceQueryOperation extends Operation {

	@Column
	private String query;
	
	@OneToOne
	private DataSourceConnector connector;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public DataSourceConnector getConnector() {
		return connector;
	}

	public void setConnector(DataSourceConnector connector) {
		this.connector = connector;
	}
	
	
}
