package br.com.navita.mobile.console.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class SapConnector extends Connector {

	@Column
	private String router;
	
	@Column(nullable = false)
	private String asHost;
	
	@Column(nullable = false)
	private String sysnr;
	
	@Column(nullable = false)
	private String client;
	
	@Column
	private String lang;
	
	public String getLang() {
		return lang;
	}
	
	public void setLang(String lang) {
		this.lang = lang;
	}
	
	public String getRouter() {
		return router;
	}

	public void setRouter(String router) {
		this.router = router;
	}

	public String getAsHost() {
		return asHost;
	}
	
	public void setAsHost(String asHost) {
		this.asHost = asHost;
	}

	public String getSysnr() {
		return sysnr;
	}

	public void setSysnr(String sysnr) {
		this.sysnr = sysnr;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	
	@Override
	public Class<? extends Operation> getOperationType() {
		
		return SapFunctionOperation.class;
	}

	
	
	
}
