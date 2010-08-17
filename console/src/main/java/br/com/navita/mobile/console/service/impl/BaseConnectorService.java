package br.com.navita.mobile.console.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import br.com.navita.mobile.console.dao.jpa.ConnectorRepository;
import br.com.navita.mobile.console.domain.entity.AuthContainer;
import br.com.navita.mobile.console.domain.entity.Connector;
import br.com.navita.mobile.console.domain.entity.LicenseBundle;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.service.AuthContainerService;
import br.com.navita.mobile.console.service.LicenseService;
import br.com.navita.mobile.console.view.rawdata.ConnectorRaw;

@Transactional
public class BaseConnectorService  implements br.com.navita.mobile.console.service.BaseConnectorService<Connector>{
	
	private ConnectorRepository<Connector> connectorRepository;
		
	protected LicenseService licenseService;	
	protected AuthContainerService authContainerService;
	
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
	public List<Connector> listAll() {		
		return connectorRepository.findAll();
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
		connector.setEnabled(raw.isEnabled());
		LicenseBundle bundle = licenseService.getBundle(raw.getLicenseBundleId());
		connector.setLicenseBundle(bundle);		
		connector.setLicenseKey(raw.getLicenseKey());
		if(raw.getAuthContainerId() != null){
			AuthContainer authContainer = authContainerService.findbyId(raw.getAuthContainerId());
			connector.setAuthContainer(authContainer);
		}
		connector.setName(raw.getName());
		connector.setTag(raw.getTag());
		if(raw.getTokenConnectorId() != null){
			Connector tokenConnector = findById(raw.getTokenConnectorId());
			connector.setTokenConnector(tokenConnector);
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
