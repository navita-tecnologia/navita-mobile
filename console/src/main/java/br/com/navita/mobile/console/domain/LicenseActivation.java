package br.com.navita.mobile.console.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class LicenseActivation extends BaseEntity {
	
	@Column
	private Date activationDate;
	
	@Column
	private String pin;
	
	@Column
	private String model;
	
	@Column
	private String brand;
	
	@Column
	private String email;
	
	@Column
	private String carrier;
	
	@Column
	private String licenseKey;
	
	@ManyToOne
	private LicenseBundle licenseBundle;
	
	public void setLicenseKey(String licenseKey) {
		this.licenseKey = licenseKey;
	}
	
	public String getLicenseKey() {
		return licenseKey;
	}
	
	
	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}
	
	public Date getActivationDate() {
		return activationDate;
	}
	
	public LicenseBundle getLicenseBundle() {
		return licenseBundle;
	}
	public void setLicenseBundle(LicenseBundle licenseBundle) {
		this.licenseBundle = licenseBundle;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	
	
}
