package br.com.navita.mobile.console.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import br.com.navita.mobile.console.dao.jpa.GenericRepository;
import br.com.navita.mobile.console.domain.entity.Connector;
import br.com.navita.mobile.console.domain.entity.StaticConnector;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.service.ConnectorService;
import br.com.navita.mobile.console.service.LicenseService;
import br.com.navita.mobile.console.view.rawdata.StaticConnectorRaw;

@Transactional
public class StaticConnectorService implements ConnectorService<StaticConnector, StaticConnectorRaw> {

	private GenericRepository<StaticConnector> staticConnectorRepository;
	private LicenseService licenseService;	
	private AuthContainerService authContainerService;
	
	public void setAuthContainerService(
			AuthContainerService authContainerService) {
		this.authContainerService = authContainerService;
	}
	
	public void setLicenseService(LicenseService licenseService) {
		this.licenseService = licenseService;
	}


	public void setStaticConnectorRepository(
			GenericRepository<StaticConnector> staticConnectorRepository) {
		this.staticConnectorRepository = staticConnectorRepository;
	}

	@Override
	public void create(StaticConnectorRaw connectorRaw) throws EntityNotFoundException {
		StaticConnector connector = new StaticConnector();
		ConnectorHelper.populateConnectorFromRaw(connector, connectorRaw, licenseService, authContainerService,this);		
		staticConnectorRepository.persist(connector);

	}

	@Override
	public StaticConnector findById(String id) throws EntityNotFoundException {

		return staticConnectorRepository.findById(id);
	}

	@Override
	public void update(StaticConnectorRaw connectorRaw) {


	}

	@Override
	public List<Connector> listAll() {
		return null;
	}

}
