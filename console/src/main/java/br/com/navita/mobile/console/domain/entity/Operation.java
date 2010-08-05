package br.com.navita.mobile.console.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Operation extends BaseEntity {

	@OneToOne
	protected LicenseBundle licenseBundle;
	
	@Column
	protected String licenseKey;
	
	@OneToOne
	protected Connector connector;	
	
	public Connector getConnector() {
		return connector;
	}
	
	public void setConnector(Connector connector) {
		this.connector = connector;
	}
	
	public LicenseBundle getLicenseBundle() {
		return licenseBundle;
	}
	public void setLicenseBundle(LicenseBundle licenseBundle) {
		this.licenseBundle = licenseBundle;
	}
	public String getLicenseKey() {
		return licenseKey;
	}
	public void setLicenseKey(String licenseKey) {
		this.licenseKey = licenseKey;
	}
	
	
}
