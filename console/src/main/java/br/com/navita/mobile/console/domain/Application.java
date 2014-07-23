/*
 * Copyright 2014 Navita Tecnologia.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
	
	@Column
	private boolean usingAnalytics;

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

	public boolean isUsingAnalytics() {
		return usingAnalytics;
	}

	public void setUsingAnalytics(boolean usingAnalytics) {
		this.usingAnalytics = usingAnalytics;
	}

	
	
	
}
