package br.com.navita.mobile.console.service.impl;

import org.springframework.transaction.annotation.Transactional;

import br.com.navita.mobile.console.dao.jpa.GenericRepository;
import br.com.navita.mobile.console.domain.entity.EjbConnector;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.service.ConnectorService;
import br.com.navita.mobile.console.view.rawdata.EjbConnectorRaw;

@Transactional
public class EjbConnectorService extends BaseConnectorService implements ConnectorService<EjbConnector, EjbConnectorRaw> {

	private GenericRepository<EjbConnector>ejbConnectorRepository;
	
	public void setEjbConnectorRepository(
			GenericRepository<EjbConnector> ejbConnectorRepository) {
		this.ejbConnectorRepository = ejbConnectorRepository;
	}
	
	@Override
	public EjbConnector create(EjbConnectorRaw connectorRaw)
			throws EntityNotFoundException {
		EjbConnector conn = new EjbConnector();
		conn.setEjbName(connectorRaw.getEjbName());
		populateConnectorFromRaw(conn, connectorRaw);
		ejbConnectorRepository.persist(conn);
		return conn;
	}

	@Override
	public void update(EjbConnectorRaw connectorRaw)	throws EntityNotFoundException {
		EjbConnector conn = (EjbConnector) findById(connectorRaw.getId());
		conn.setEjbName(connectorRaw.getEjbName());
		populateConnectorFromRaw(conn, connectorRaw);				
	}

}
