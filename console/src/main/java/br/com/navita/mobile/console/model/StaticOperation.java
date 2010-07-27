package br.com.navita.mobile.console.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class StaticOperation extends Operation {

	@Column(nullable = true)
	private String list;
	
	@Column(nullable = true)
	private int resultCode;
	
	@Column(nullable = true)
	private String object;
	
	@Column(nullable = true)
	private String message;
	
	@Column(nullable = true)
	private String token;
	
	@OneToOne
	private StaticConnector staticConnector;
	
	

	

	public StaticConnector getStaticConnector() {
		return staticConnector;
	}

	public void setStaticConnector(StaticConnector staticConnector) {
		this.staticConnector = staticConnector;
	}

	public String getList() {
		return list;
	}

	public void setList(String list) {
		this.list = list;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
