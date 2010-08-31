package br.com.navita.mobile.console.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import br.com.navita.mobile.console.dao.jpa.GenericRepository;
import br.com.navita.mobile.console.dao.jpa.LicenseActivationRepository;
import br.com.navita.mobile.console.domain.LicenseActivation;
import br.com.navita.mobile.console.domain.LicenseBundle;
import br.com.navita.mobile.console.domain.LicenseBundleType;
import br.com.navita.mobile.console.domain.util.SearchCriteria;
import br.com.navita.mobile.console.domain.util.SearchResultPage;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.service.LicenseService;
import br.com.navita.mobile.console.view.rawdata.LicenseActivationRaw;
import br.com.navita.mobile.console.view.rawdata.LicenseBundleRaw;


@Transactional
public class LicenseServiceImpl implements LicenseService {
	
	private GenericRepository<LicenseBundleType> licenseBundleTypeRepository;
	private GenericRepository<LicenseBundle> licenseBundleRepository;
	private LicenseActivationRepository<LicenseActivation> licenseActivationRepository;
	
	public void setLicenseBundleTypeRepository(
			GenericRepository<br.com.navita.mobile.console.domain.LicenseBundleType> licenseBundleTypeRepository) {
		this.licenseBundleTypeRepository = licenseBundleTypeRepository;
	}
	
	public void setLicenseBundleRepository(
			GenericRepository<LicenseBundle> licenseBundleRepository) {
		this.licenseBundleRepository = licenseBundleRepository;
	}
	
	public void setLicenseActivationRepository(
			LicenseActivationRepository<LicenseActivation> licenseActivationRepository) {
		this.licenseActivationRepository = licenseActivationRepository;
	}

	@Override
	public void deleteBundle(LicenseBundleRaw bundleRaw) throws EntityNotFoundException {
		LicenseBundle bundle = licenseBundleRepository.findById(bundleRaw.getId());
		licenseBundleRepository.remove(bundle);
		
	}

	
	@Override
	public LicenseBundle insertBundle(LicenseBundleRaw bundleRaw) throws EntityNotFoundException {
		LicenseBundle bundle = new LicenseBundle();
		persistBundle(bundleRaw, bundle);
		return bundle;
	}

	@Override
	public void doLicenseActivation(LicenseActivationRaw raw) throws EntityNotFoundException {
		LicenseBundle bundle = licenseBundleRepository.findById(raw.getBundleId());
		
		
		LicenseActivation savedActivation = licenseActivationRepository.findPinOnBundle(raw.getPin(),raw.getBundleId());
		if(savedActivation != null){
			savedActivation.setCarrier(raw.getCarrier());
			savedActivation.setEmail(raw.getEmail());
			licenseActivationRepository.persist(savedActivation);
		}else{
			LicenseActivation la = new LicenseActivation();
			la.setLicenseBundle(bundle);
			la.setActivationDate(raw.getActivationDate());
			la.setBrand(raw.getBrand());
			la.setCarrier(raw.getCarrier());
			la.setEmail(raw.getEmail());
			la.setModel(raw.getModel());
			la.setPin(raw.getPin());
			la.setName("");
			licenseActivationRepository.persist(la);
		}
		
		
		
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
	public void updateBundle(LicenseBundleRaw bundleRaw) throws EntityNotFoundException {
		LicenseBundle bundle = licenseBundleRepository.findById(bundleRaw.getId());
		persistBundle(bundleRaw, bundle);
		
	}

	private void persistBundle(LicenseBundleRaw bundleRaw, LicenseBundle bundle)
			throws EntityNotFoundException {
		bundle.setName(bundleRaw.getName());
		bundle.setPeriod(bundleRaw.getPeriod());	
		bundle.setEnabled(bundleRaw.isEnabled());
		LicenseBundleType type = licenseBundleTypeRepository.findById(bundleRaw.getLicenseBundleTypeId());
		bundle.setLicenseBundleType(type);
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

	@Override
	public Long countLicenseBundleActivations(SearchCriteria criteria) {		
		return licenseActivationRepository.countLicenceBundleActivations(criteria.getText());
	}

	@Override
	public SearchResultPage<LicenseActivation> listPaginatedLicenseActivation(SearchCriteria criteria) {		
		Long totalElements = countLicenseBundleActivations(criteria);
		List<LicenseActivation> elementsThisPage = licenseActivationRepository.paginateActivationsByBundle(criteria);
		SearchResultPage<LicenseActivation> page = new SearchResultPage<LicenseActivation>(criteria, totalElements, elementsThisPage);
		return page;
	}
	
	

}
