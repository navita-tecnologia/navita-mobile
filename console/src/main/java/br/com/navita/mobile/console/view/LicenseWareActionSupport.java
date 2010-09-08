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
