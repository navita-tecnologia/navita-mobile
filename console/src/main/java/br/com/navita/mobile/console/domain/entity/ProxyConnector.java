package br.com.navita.mobile.console.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ProxyConnector extends Connector {

	
	@Column
	private String url;
	
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public Class<? extends Operation> getOperationType() {
		// nenhuma opracao admitida
		return null;
	}

	@Override
	public Operation createDynamicOperation(String operationTag) {
		// TODO Auto-generated method stub
		return null;
	}
}
