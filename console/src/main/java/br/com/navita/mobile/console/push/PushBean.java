package br.com.navita.mobile.console.push;

import java.io.Serializable;

public class PushBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pin;
	private String applicationId;
	private String attributeCode;
	private String rawData;
	

	
	
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	public String getAttributeCode() {
		return attributeCode;
	}
	public void setAttributeCode(String attributeCode) {
		this.attributeCode = attributeCode;
	}
	public String getRawData() {
		return rawData;
	}
	public void setRawData(String rawData) {
		this.rawData = rawData;
	}
}
