package br.com.navita.mobile.console.service.impl;

import org.springframework.transaction.annotation.Transactional;

import br.com.navita.mobile.console.dao.jpa.GenericRepository;
import br.com.navita.mobile.console.domain.SapConnector;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.service.ConnectorService;
import br.com.navita.mobile.console.view.rawdata.SapConnectorRaw;

@Transactional
public class SapConnectorService extends BaseConnectorService implements ConnectorService<SapConnector, SapConnectorRaw> {

	private GenericRepository<SapConnector> sapConnectorRepository;
	
	public void setSapConnectorRepository(
			GenericRepository<SapConnector> sapConnectorRepository) {
		this.sapConnectorRepository = sapConnectorRepository;
	}
	
	@Override
	public SapConnector create(SapConnectorRaw connectorRaw)
			throws EntityNotFoundException {
		SapConnector conn = new SapConnector();
		conn.setClient(connectorRaw.getClient());
		conn.setAsHost(connectorRaw.getAsHost());
		conn.setLang(connectorRaw.getLang());
		conn.setSysnr(connectorRaw.getSysnr());
		conn.setRouter(connectorRaw.getRouter());		
		populateConnectorFromRaw(conn, connectorRaw);
		sapConnectorRepository.persist(conn);
		return conn;
	}

	@Override
	public void update(SapConnectorRaw connectorRaw)	throws EntityNotFoundException {
		SapConnector conn = (SapConnector) findById(connectorRaw.getId());
		conn.setClient(connectorRaw.getClient());
		conn.setAsHost(connectorRaw.getAsHost());
		conn.setLang(connectorRaw.getLang());
		conn.setSysnr(connectorRaw.getSysnr());
		conn.setRouter(connectorRaw.getRouter());
		populateConnectorFromRaw(conn, connectorRaw);				
	}

}
