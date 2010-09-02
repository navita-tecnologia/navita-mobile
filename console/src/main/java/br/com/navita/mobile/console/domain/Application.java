package br.com.navita.mobile.console.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Application extends BaseEntity {

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Connector> connectors;	
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<BesServer> pushServers;
	
	@ManyToOne
	private LicenseBundle licenseBundle;

	public Set<Connector> getConnectors() {
		return connectors;
	}

	public void setConnectors(Set<Connector> connectors) {
		this.connectors = connectors;
	}

	public Set<BesServer> getPushServers() {
		return pushServers;
	}

	public void setPushServers(Set<BesServer> pushServers) {
		this.pushServers = pushServers;
	}

	public LicenseBundle getLicenseBundle() {
		return licenseBundle;
	}

	public void setLicenseBundle(LicenseBundle licenseBundle) {
		this.licenseBundle = licenseBundle;
	}
	
	
	
}
