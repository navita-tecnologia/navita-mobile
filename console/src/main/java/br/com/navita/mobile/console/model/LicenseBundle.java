package br.com.navita.mobile.console.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class LicenseBundle extends BaseEntity {
	
	@Column(nullable = false)
	private int period;
	
	@Column(nullable = false)
	private boolean enabled;
	
	
	@OneToOne
	private LicenseBundleType licenseBundleType;


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public int getPeriod() {
		return period;
	}


	public void setPeriod(int period) {
		this.period = period;
	}


	public LicenseBundleType getLicenseBundleType() {
		return licenseBundleType;
	}


	public void setLicenseBundleType(LicenseBundleType licenseBundleType) {
		this.licenseBundleType = licenseBundleType;
	}
	
	
	
}
