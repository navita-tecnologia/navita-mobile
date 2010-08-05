package br.com.navita.mobile.console.service.impl;

import org.springframework.transaction.annotation.Transactional;

import br.com.navita.mobile.console.dao.jpa.GenericRepository;
import br.com.navita.mobile.console.domain.entity.StaticConnector;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.service.ConnectorService;
import br.com.navita.mobile.console.view.rawdata.ConnectorRaw;

@Transactional
public class StaticConnectorService extends BaseConnectorService implements ConnectorService<StaticConnector, ConnectorRaw> {

	private GenericRepository<StaticConnector> staticConnectorRepository;
	
	public void setStaticConnectorRepository(
			GenericRepository<StaticConnector> staticConnectorRepository) {
		this.staticConnectorRepository = staticConnectorRepository;
	}

	@Override
	public void create(ConnectorRaw connectorRaw) throws EntityNotFoundException {
		saveFromRaw(new StaticConnector(),connectorRaw);
	}
	
	private void saveFromRaw(StaticConnector connector,ConnectorRaw connectorRaw) throws EntityNotFoundException{
		ConnectorHelper.populateConnectorFromRaw(connector, connectorRaw, licenseService, authContainerService,this);		
		staticConnectorRepository.persist(connector);
	}

	@Override
	public StaticConnector findById(String id) throws EntityNotFoundException {
		return staticConnectorRepository.findById(id);
	}

	@Override
	public void update(ConnectorRaw connectorRaw) throws EntityNotFoundException {
		StaticConnector connector = findById(connectorRaw.getId());
		saveFromRaw(connector, connectorRaw);
	}

	@Override
	public void remove(String id) throws EntityNotFoundException {
		StaticConnector entity = findById(id);
		staticConnectorRepository.remove(entity);
		
	}

}
