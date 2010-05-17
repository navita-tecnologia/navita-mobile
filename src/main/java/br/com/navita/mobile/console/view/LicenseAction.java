package br.com.navita.mobile.console.view;

import java.util.List;

import org.apache.struts2.dispatcher.DefaultActionSupport;

import br.com.navita.mobile.console.bizz.LicenseService;
import br.com.navita.mobile.console.domain.LicenceUse;
import br.com.navita.mobile.console.domain.LicenseBundle;

public class LicenseAction extends DefaultActionSupport {
	
	private LicenseBundle bundle;
	private LicenceUse licenceUse;
	private List<LicenseBundle> bundles;	
	private LicenseService licenseService;
	public void setLicenseService(LicenseService licenseService) {
		this.licenseService = licenseService;
	}
	
	
	public LicenseBundle getBundle() {
		return bundle;
	}


	public void setBundle(LicenseBundle bundle) {
		this.bundle = bundle;
	}


	public LicenceUse getLicenceUse() {
		return licenceUse;
	}


	public void setLicenceUse(LicenceUse licenceUse) {
		this.licenceUse = licenceUse;
	}

	public void setBundles(List<LicenseBundle> bundles) {
		this.bundles = bundles;
	}
	public List<LicenseBundle> getBundles() {
		return bundles;
	}

	@Override
	public String execute() throws Exception {
		bundles = licenseService.listBundle(bundle);
		return SUCCESS;
	}

}
