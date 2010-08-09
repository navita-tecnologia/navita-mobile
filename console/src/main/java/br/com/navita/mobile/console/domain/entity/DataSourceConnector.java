package br.com.navita.mobile.console.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class DataSourceConnector extends Connector {

	@Column
	private String dataSource;

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public Class<? extends Operation> getOperationType() {		
		return DataSourceQueryOperation.class;
	}
	
	
	
}
