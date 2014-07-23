package br.com.navita.mobile.console.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import br.com.navita.mobile.console.dao.GenericRepository;
import br.com.navita.mobile.console.domain.Application;
import br.com.navita.mobile.console.domain.LicenseBundle;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.service.LicenseService;
import br.com.navita.mobile.console.view.rawdata.ApplicationRaw;

@Transactional
public class ApplicationService implements br.com.navita.mobile.console.service.ApplicationService{

	private GenericRepository<Application> applicationRepository;
	protected LicenseService licenseService;
	
	public void setLicenseService(LicenseService licenseService) {
		this.licenseService = licenseService;
	}
	
	public void setApplicationRepository(
			GenericRepository<Application> applicationRepository) {
		this.applicationRepository = applicationRepository;
	}
	
	@Override
	public Application create(ApplicationRaw raw) throws EntityNotFoundException {
		Application app = new Application();
		fillAppFromRaw(app,raw);
		applicationRepository.persist(app);
		return app;
	}

	private void fillAppFromRaw(Application app, ApplicationRaw raw) throws EntityNotFoundException {
		if(raw.getLicenseBundleId() != null && ! raw.getLicenseBundleId().isEmpty()){
			LicenseBundle bd = licenseService.getBundle(raw.getLicenseBundleId());
			app.setLicenseBundle(bd);			
		}else{
			app.setLicenseBundle(null);
		}
		app.setEnabled(raw.isEnabled());
		app.setName(raw.getName());
		app.setLicenseKey(raw.getLicenseKey());
		app.setUsingAnalytics(raw.isUsingAnalytics());
		
	}

	@Override
	public Application findbyId(String id) throws EntityNotFoundException {		
		return applicationRepository.findById(id);
	}

	@Override
	public List<Application> findAll() {		
		return applicationRepository.findAll();
	}

	@Override
	public void remove(String id) throws EntityNotFoundException {
		Application app = findbyId(id);
		applicationRepository.remove(app);
		
	}

	@Override
	public Application save(ApplicationRaw raw) throws EntityNotFoundException {
		Application saved = findbyId(raw.getId());
		fillAppFromRaw(saved, raw);
		return saved;
	}

}
