package br.com.navita.mobile.console.push;

import java.io.Serializable;

public class PushResult implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer resultCode;
	private String message;
	public Integer getResultCode() {
		return resultCode;
	}
	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
