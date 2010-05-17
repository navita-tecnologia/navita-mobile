package br.com.navita.mobile.console.domain;

import java.io.Serializable;
import java.util.Date;

public class LicenceUse implements Serializable{
	private int bundleId;
	private int id;
	private String licenseKey;
	private String pin;
	private Date activationDate;
	private int periodInDays;
	private String email;
	private String deviceModel;
	private String deviceMaker;
	private String carrier;
	private int displayWidth;
	public int getBundleId() {
		return bundleId;
	}
	public void setBundleId(int bundleId) {
		this.bundleId = bundleId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLicenseKey() {
		return licenseKey;
	}
	public void setLicenseKey(String licenseKey) {
		this.licenseKey = licenseKey;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public Date getActivationDate() {
		return activationDate;
	}
	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}
	public int getPeriodInDays() {
		return periodInDays;
	}
	public void setPeriodInDays(int periodInDays) {
		this.periodInDays = periodInDays;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDeviceModel() {
		return deviceModel;
	}
	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}
	public String getDeviceMaker() {
		return deviceMaker;
	}
	public void setDeviceMaker(String deviceMaker) {
		this.deviceMaker = deviceMaker;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public int getDisplayWidth() {
		return displayWidth;
	}
	public void setDisplayWidth(int displayWidth) {
		this.displayWidth = displayWidth;
	}
	
	

}
