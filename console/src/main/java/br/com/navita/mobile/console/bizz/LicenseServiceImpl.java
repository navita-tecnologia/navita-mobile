package br.com.navita.mobile.console.bizz;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import br.com.navita.mobile.console.dao.LicenseDAO;
import br.com.navita.mobile.console.dao.Page;
import br.com.navita.mobile.console.dao.jpa.GenericRepository;
import br.com.navita.mobile.console.domain.DeviceData;
import br.com.navita.mobile.console.domain.LicenseBundle;
import br.com.navita.mobile.console.domain.LicenseBundleType;
import br.com.navita.mobile.console.domain.LicenseUse;


@Transactional
public class LicenseServiceImpl implements LicenseService {
	
	private GenericRepository<br.com.navita.mobile.console.model.LicenseBundleType> licenseBundleTypeRepository;
	
	public void setLicenseBundleTypeRepository(
			GenericRepository<br.com.navita.mobile.console.model.LicenseBundleType> licenseBundleTypeRepository) {
		this.licenseBundleTypeRepository = licenseBundleTypeRepository;
	}
	
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

	@Override
	public Page<LicenseUse> listLicenseUses(LicenseBundle bundle, int pageNumber) {		
		return licenseDAO.listLicenseUses(bundle,pageNumber);
	}

	@Override
	public void insertLicenseUse(LicenseUse use,DeviceData device) {
		licenseDAO.insertLicenseUse(use,device);
		
	}

	@Override
	public void persistBundleType(
			br.com.navita.mobile.console.model.LicenseBundleType type) {
		licenseBundleTypeRepository.persist(type);
		
	}

}
