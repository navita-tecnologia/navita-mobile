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
	public StaticConnector create(ConnectorRaw connectorRaw) throws EntityNotFoundException {
		StaticConnector conn = new StaticConnector();		
		populateConnectorFromRaw(conn, connectorRaw);		
		staticConnectorRepository.persist(conn);
		return conn;
	}
	
	

	@Override
	public void update(ConnectorRaw connectorRaw) throws EntityNotFoundException {
		StaticConnector conn = (StaticConnector) findById(connectorRaw.getId());
		populateConnectorFromRaw(conn, connectorRaw);
	}


}
