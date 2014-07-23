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
public class LicenseBundle extends BaseEntity {
	
	@Column(nullable = false)
	private int period;
	
	@Column(nullable = false)
	private boolean enabled;
	
	
	@ManyToOne
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
