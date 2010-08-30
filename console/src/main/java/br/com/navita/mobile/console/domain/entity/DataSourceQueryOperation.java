package br.com.navita.mobile.console.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class DataSourceQueryOperation extends Operation {

	@Column
	private String query;
	
	@Column
	private boolean returnResultSet;
	
	
	
	
	
	public boolean isReturnResultSet() {
		return returnResultSet;
	}

	public void setReturnResultSet(boolean returnResultSet) {
		this.returnResultSet = returnResultSet;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	

	
}
