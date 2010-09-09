package br.com.navita.mobile.console.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Application extends BaseEntity {

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Connector> connectors;	
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<PushServer> besPushServers;
	
	@ManyToOne
	private LicenseBundle licenseBundle;
	
	@Column
	private boolean enabled;
	
	@Column
	private String licenseKey;

	public Set<Connector> getConnectors() {
		return connectors;
	}

	public void setConnectors(Set<Connector> connectors) {
		this.connectors = connectors;
	}

	
	public LicenseBundle getLicenseBundle() {
		return licenseBundle;
	}

	public void setLicenseBundle(LicenseBundle licenseBundle) {
		this.licenseBundle = licenseBundle;
	}
	
	
	public Set<PushServer> getBesPushServers() {
		return besPushServers;
	}
	
	public void setBesPushServers(Set<PushServer> besPushServers) {
		this.besPushServers = besPushServers;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	

	public String getLicenseKey() {
		return licenseKey;
	}
	
	public void setLicenseKey(String licenseKey) {
		this.licenseKey = licenseKey;
	}
	
}
