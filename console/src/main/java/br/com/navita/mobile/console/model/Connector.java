package br.com.navita.mobile.console.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Connector extends BaseEntity {
	
	@Column(nullable = false)
	private String tag;
	
	@Column(nullable = false)
	private boolean enabled;
	
	
	@OneToOne
	private Connector tokenConnector;
	
	
	@OneToOne
	private BaseLoginService loginService;
	
	
	@OneToOne
	private LicenseBundle licenseBundle;
	
	@Column(nullable = false)
	private String licenseKey;
	
	@OrderBy("name")
	@OneToMany
	private Set<Operation> operations;

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Connector getTokenConnector() {
		return tokenConnector;
	}

	public void setTokenConnector(Connector tokenConnector) {
		this.tokenConnector = tokenConnector;
	}

	

	public BaseLoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(BaseLoginService loginService) {
		this.loginService = loginService;
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

	public Set<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}
	
	
	
	
	
}
