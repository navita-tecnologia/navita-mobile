package br.com.navita.mobile.console.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class LicenseBundle extends BaseEntity {
	
	@Column(nullable = false)
	private int period;
	
	@Column(nullable = false)
	private boolean enabled;
	
	
	@OneToOne
	private LicenseBundleType licenseBundleType;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="licenseBundle")
	private Set<LicenseActivation> licenseActivations;
	
	public Set<LicenseActivation> getLicenseActivations() {
		return licenseActivations;
	}
	
	public void setLicenseActivations(Set<LicenseActivation> licenseActivations) {
		this.licenseActivations = licenseActivations;
	}


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
