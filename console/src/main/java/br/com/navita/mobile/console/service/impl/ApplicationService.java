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
