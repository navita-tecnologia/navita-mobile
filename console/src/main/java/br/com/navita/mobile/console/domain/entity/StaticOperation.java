package br.com.navita.mobile.console.domain.entity;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.navita.mobile.domain.MobileBean;

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
	
	@Override
	public MobileBean process(Map<?, ?> params) {		
		return new MobileBean();
	}
	
}
