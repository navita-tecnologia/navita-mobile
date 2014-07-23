package br.com.navita.mobile.console.domain;

import java.io.Serializable;

public class DomainControler implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DomainControler() {
		
	}
	
	public DomainControler(String hostName, int port){
		this.hostName = hostName;
		this.url = "ldap://"+hostName+":"+port;
	}
	
	private String url;
	private String hostName;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

}
