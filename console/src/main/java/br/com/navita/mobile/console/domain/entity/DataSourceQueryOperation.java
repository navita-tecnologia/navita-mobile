package br.com.navita.mobile.console.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class DataSourceQueryOperation extends Operation {

	@Column
	private String query;
	
	
	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	
}
