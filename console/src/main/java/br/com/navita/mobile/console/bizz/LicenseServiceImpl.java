package br.com.navita.mobile.console.bizz;

import java.util.List;

import br.com.navita.mobile.console.dao.LicenseDAO;
import br.com.navita.mobile.console.domain.LicenseBundle;
import br.com.navita.mobile.console.domain.LicenseBundleType;

public class LicenseServiceImpl implements LicenseService {
	
	private LicenseDAO licenseDAO;
	
	public void setLicenseDAO(LicenseDAO licenseDAO) {
		this.licenseDAO = licenseDAO;
	}

	@Override
	public void deleteBundle(LicenseBundle bundle) {
		licenseDAO.deleteBundle(bundle);

	}

	@Override
	public LicenseBundle getBundle(LicenseBundle bundle) {
		
		return licenseDAO.getBundle(bundle);
	}

	@Override
	public LicenseBundle insertBundle(LicenseBundle bundle) {
		
		return licenseDAO.insertBundle(bundle);
	}

	@Override
	public List<LicenseBundle> listBundle(LicenseBundle bundle) {		
		return licenseDAO.listBundle(bundle);
	}

	@Override
	public void updateBundle(LicenseBundle bundle) {
		licenseDAO.updateBundle(bundle);

	}

	@Override
	public List<LicenseBundleType> listBundleTypes() {		
		return licenseDAO.listBundleTypes();
	}

}
