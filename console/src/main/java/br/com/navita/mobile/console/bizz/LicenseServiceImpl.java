package br.com.navita.mobile.console.bizz;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import br.com.navita.mobile.console.dao.jpa.GenericRepository;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.model.LicenseBundle;
import br.com.navita.mobile.console.model.LicenseBundleType;
import br.com.navita.mobile.console.model.LicenseActivation;


@Transactional
public class LicenseServiceImpl implements LicenseService {
	
	private GenericRepository<LicenseBundleType> licenseBundleTypeRepository;
	private GenericRepository<LicenseBundle> licenseBundleRepository;
	private GenericRepository<LicenseActivation> licenseActivationRepository;
	
	public void setLicenseBundleTypeRepository(
			GenericRepository<br.com.navita.mobile.console.model.LicenseBundleType> licenseBundleTypeRepository) {
		this.licenseBundleTypeRepository = licenseBundleTypeRepository;
	}
	
	public void setLicenseBundleRepository(
			GenericRepository<LicenseBundle> licenseBundleRepository) {
		this.licenseBundleRepository = licenseBundleRepository;
	}
	
	public void setLicenseActivationRepository(
			GenericRepository<LicenseActivation> licenseActivationRepository) {
		this.licenseActivationRepository = licenseActivationRepository;
	}

	@Override
	public void deleteBundle(LicenseBundle bundle) {
		licenseBundleRepository.remove(bundle);
		
	}

	
	@Override
	public LicenseBundle insertBundle(LicenseBundle bundle) {
		licenseBundleRepository.persist(bundle);
		return bundle;
	}

	@Override
	public void insertLicenseUse(LicenseActivation licenseActivation, String bundleId) throws EntityNotFoundException {
		LicenseBundle bundle = licenseBundleRepository.findById(bundleId);
		licenseActivation.setLicenseBundle(bundle);
		licenseActivationRepository.persist(licenseActivation);
		
	}

	@Override
	public List<LicenseBundle> listBundle() {		
		return licenseBundleRepository.findAll();
	}

	@Override
	public List<LicenseBundleType> listBundleTypes() {		
		return licenseBundleTypeRepository.findAll();
	}

	
	@Override
	public void persistBundleType(LicenseBundleType type) {
		licenseBundleTypeRepository.persist(type);
		
	}

	@Override
	public void updateBundle(LicenseBundle bundle) {
		licenseBundleRepository.persist(bundle);
		
	}

	@Override
	public void deleteBundleType(LicenseBundleType type) {
		licenseBundleTypeRepository.remove(type);		
	}

	@Override
	public LicenseBundle getBundle(String id) throws EntityNotFoundException {		
		return licenseBundleRepository.findById(id);
	}
	
	

}
