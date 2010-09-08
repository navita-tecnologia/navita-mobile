package br.com.navita.mobile.console.service.impl;

import org.springframework.transaction.annotation.Transactional;

import br.com.navita.mobile.console.dao.GenericRepository;
import br.com.navita.mobile.console.domain.ProxyConnector;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.service.ConnectorService;
import br.com.navita.mobile.console.view.rawdata.ProxyConnectorRaw;

@Transactional
public class ProxyConnectorService extends BaseConnectorService implements ConnectorService<ProxyConnector, ProxyConnectorRaw> {

	private GenericRepository<ProxyConnector> dataSourceConnectorRepository;
	
	public void setDataSourceConnectorRepository(
			GenericRepository<ProxyConnector> dataSourceConnectorRepository) {
		this.dataSourceConnectorRepository = dataSourceConnectorRepository;
	}
	
	@Override
	public ProxyConnector create(ProxyConnectorRaw connectorRaw)
			throws EntityNotFoundException {
		ProxyConnector conn = new ProxyConnector();
		conn.setUrl(connectorRaw.getUrl());
		populateConnectorFromRaw(conn, connectorRaw);
		dataSourceConnectorRepository.persist(conn);
		return conn;
	}

	@Override
	public void update(ProxyConnectorRaw connectorRaw)	throws EntityNotFoundException {
		ProxyConnector conn = (ProxyConnector) findById(connectorRaw.getId());
		conn.setUrl(connectorRaw.getUrl());
		populateConnectorFromRaw(conn, connectorRaw);				
	}

}
