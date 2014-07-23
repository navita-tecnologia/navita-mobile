package br.com.navita.mobile.console.domain;

import java.io.Serializable;
import java.util.List;

public class LoginResult implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean logged;
	private String message;
	private String token;
	private List<UserGroup> groups;
	
	public List<UserGroup> getGroups() {
		return groups;
	}
	public void setGroups(List<UserGroup> groups) {
		this.groups = groups;
	}
	public boolean isLogged() {
		return logged;
	}
	public void setLogged(boolean logged) {
		this.logged = logged;
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
