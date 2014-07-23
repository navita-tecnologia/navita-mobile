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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Connector extends BaseEntity {
	
	@Column(nullable = false, unique = true)	
	private String tag;
	
	@Column(nullable = false)
	private boolean enabled;
	
	@ManyToOne
	private Application application;
	
	@ManyToOne
	private Connector tokenConnector;
	
	
	@ManyToOne
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

	public void setApplication(Application application) {
		this.application = application;
	}
	
	public Application getApplication() {
		return application;
	}
	
	
	
	
	
}
