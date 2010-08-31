package br.com.navita.mobile.console.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Connector extends BaseEntity {
	
	@Column(nullable = false, unique = true)	
	private String tag;
	
	@Column(nullable = false)
	private boolean enabled;
	
	
	@ManyToOne
	private Connector tokenConnector;
	
	
	@OneToOne
	private AuthContainer authContainer;
	
	
	@ManyToOne
	private LicenseBundle licenseBundle;
	
	@Column(nullable = false)
	private String licenseKey;
	
	@OrderBy("name")
	@OneToMany(cascade = CascadeType.ALL, mappedBy="connector")
	private Set<Operation> operations;

	
	public abstract Class<? extends Operation> getOperationType();
	
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

	

	public void setAuthContainer(AuthContainer authContainer) {
		this.authContainer = authContainer;
	}
	
	public AuthContainer getAuthContainer() {
		return authContainer;
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
