package br.com.navita.mobile.console.domain;

import java.io.Serializable;

public class UserGroup implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dn;
	private String name;
	public String getDn() {
		return dn;
	}
	public void setDn(String dn) {
		this.dn = dn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {		
		return name;
	}
}
