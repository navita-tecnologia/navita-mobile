package br.com.navita.mobile.console.domain;

import java.io.Serializable;

public class DeviceData implements Serializable{
	private String pin;
	private String model;
	private String brand;
	private String lastEmail;
	private String lastCarrier;
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getLastEmail() {
		return lastEmail;
	}
	public void setLastEmail(String lastEmail) {
		this.lastEmail = lastEmail;
	}
	public String getLastCarrier() {
		return lastCarrier;
	}
	public void setLastCarrier(String lastCarrier) {
		this.lastCarrier = lastCarrier;
	} 

}
