package br.com.navita.mobile.console.dao.jpa;

import javax.persistence.Column;

import br.com.navita.mobile.console.domain.BaseEntity;

public class BesServer extends BaseEntity {
	
	@Column(nullable=false)
	private String url;
	
	@Column(nullable=false)
	private String port;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	
}
