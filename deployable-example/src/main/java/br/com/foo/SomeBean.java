package br.com.foo;

import java.io.Serializable;

public class SomeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String campo1;
	private String campo2;
	
	public SomeBean(String c1, String c2) {
		this.campo1 = c1;
		this.campo2 = c2;
	}
	
	public String getCampo1() {
		return campo1;
	}
	public void setCampo1(String campo1) {
		this.campo1 = campo1;
	}
	public String getCampo2() {
		return campo2;
	}
	public void setCampo2(String campo2) {
		this.campo2 = campo2;
	}

	

}
