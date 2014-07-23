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
package br.com.navita.mobile.console.view;

import java.util.List;

import br.com.navita.mobile.console.domain.LicenseBundle;
import br.com.navita.mobile.console.service.LicenseService;
import br.com.navita.mobile.console.view.rawdata.LicenseWare;

/**
 * 
 * @author mpguedes
 *
 */
public abstract class LicenseWareActionSupport extends RawActionSupport	implements LicenseWare {
	
	protected LicenseService licenseService;
	protected String licenseBundleId;
	protected String licenseKey;
	
	@Override
	public final String getLicenseBundleId() {
		return licenseBundleId;
	}

	public final void setLicenseBundleId(String licenseBundleId) {
		this.licenseBundleId = licenseBundleId;
	}

	@Override
	public final String getLicenseKey() {
		return licenseKey;
	}

	public final void setLicenseKey(String licenseKey) {
		this.licenseKey = licenseKey;
	}

	public final void setLicenseService(LicenseService licenseService) {
		this.licenseService = licenseService;
	}
	
	public final List<LicenseBundle> getLicenseBundles(){
		return licenseService.listBundle();
	}
	

}
