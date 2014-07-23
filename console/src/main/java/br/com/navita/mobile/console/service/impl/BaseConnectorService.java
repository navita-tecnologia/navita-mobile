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

import br.com.navita.mobile.console.dao.ConnectorRepository;
import br.com.navita.mobile.console.domain.AuthContainer;
import br.com.navita.mobile.console.domain.Connector;
import br.com.navita.mobile.console.domain.LicenseBundle;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.service.ApplicationService;
import br.com.navita.mobile.console.service.AuthContainerService;
import br.com.navita.mobile.console.service.LicenseService;
import br.com.navita.mobile.console.view.rawdata.ConnectorRaw;

@Transactional
public class BaseConnectorService  implements br.com.navita.mobile.console.service.BaseConnectorService<Connector>{

	private ConnectorRepository<Connector> connectorRepository;
	private ApplicationService applicationService;

	protected LicenseService licenseService;	
	protected AuthContainerService authContainerService;

	public void setApplicationService(ApplicationService applicationService) {
		this.applicationService = applicationService;
	}	

	public void setAuthContainerService(
			AuthContainerService authContainerService) {
		this.authContainerService = authContainerService;
	}

	public void setLicenseService(LicenseService licenseService) {
		this.licenseService = licenseService;
	}

	public void setConnectorRepository(
			ConnectorRepository<Connector> connectorRepository) {
		this.connectorRepository = connectorRepository;
	}


	@Override
	public List<Connector> listByApp(String appId) {		
		return connectorRepository.findByAppId(appId);
	}


	@Override
	public Connector findById(String id) throws EntityNotFoundException {
		return connectorRepository.findById(id);
	}

	@Override
	public void remove(String id) throws EntityNotFoundException {
		Connector entity = connectorRepository.findById(id);
		connectorRepository.remove(entity);		
	}

	protected void populateConnectorFromRaw(Connector connector, ConnectorRaw raw) throws EntityNotFoundException{

		connector.setApplication(applicationService.findbyId(raw.getApplicationId()));
		
		connector.setEnabled(raw.isEnabled());
		if(raw.getLicenseBundleId() != null && ! raw.getLicenseBundleId().isEmpty()){
			LicenseBundle bundle = licenseService.getBundle(raw.getLicenseBundleId());
			connector.setLicenseBundle(bundle);
		}else{
			connector.setLicenseBundle(null);
		}
		connector.setLicenseKey(raw.getLicenseKey());
		if(raw.getAuthContainerId() != null && ! raw.getAuthContainerId().isEmpty()){
			AuthContainer authContainer = authContainerService.findbyId(raw.getAuthContainerId());
			connector.setAuthContainer(authContainer);
		}else{
			connector.setAuthContainer(null);
		}
		connector.setName(raw.getName());
		connector.setTag(raw.getTag());
		if(raw.getTokenConnectorId() != null && ! raw.getTokenConnectorId().isEmpty()){
			Connector tokenConnector = findById(raw.getTokenConnectorId());
			connector.setTokenConnector(tokenConnector);
		}else{
			connector.setTokenConnector(null);
		}
	}

	@Override
	public boolean isTagUnique(String tag)	throws EntityNotFoundException {		
		return connectorRepository.findByTag(tag) == null ;
	}

	@Override
	public boolean isTagUniqueForId(String tag, String id)	throws EntityNotFoundException {		
		Connector connector =  connectorRepository.findByTag(tag);		
		return connector == null || id.equals( connector.getId());
	}

	@Override
	public Connector findByTag(String connectorTag) {		
		return connectorRepository.findByTag(connectorTag);
	}

}
