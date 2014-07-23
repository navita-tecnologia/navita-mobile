package br.com.navita.mobile.console.domain;

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
		// nenhuma operacao admitida
		return null;
	}

	
}
