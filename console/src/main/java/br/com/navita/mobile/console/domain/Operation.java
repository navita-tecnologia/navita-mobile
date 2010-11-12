package br.com.navita.mobile.console.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"id","tag"}))
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Operation extends BaseEntity {

	@ManyToOne
	protected LicenseBundle licenseBundle;
	
	@Column
	protected String licenseKey;
	
	protected String tag;
	
	@ManyToOne
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
	
	public String getTag() {
		return tag;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}

	
	
}
