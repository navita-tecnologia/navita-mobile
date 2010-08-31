package br.com.navita.mobile.console.service.impl;

import org.springframework.transaction.annotation.Transactional;

import br.com.navita.mobile.console.dao.jpa.GenericRepository;
import br.com.navita.mobile.console.domain.WebServiceConnector;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.service.ConnectorService;
import br.com.navita.mobile.console.view.rawdata.WebServiceConnectorRaw;

@Transactional
public class WebServiceConnectorService extends BaseConnectorService implements ConnectorService<WebServiceConnector, WebServiceConnectorRaw> {

	private GenericRepository<WebServiceConnector> webServiceConnectorRepository;
	
	public void setWebServiceConnectorRepository(
			GenericRepository<WebServiceConnector> webServiceConnectorRepository) {
		this.webServiceConnectorRepository = webServiceConnectorRepository;
	}
	
	@Override
	public WebServiceConnector create(WebServiceConnectorRaw connectorRaw)
			throws EntityNotFoundException {
		WebServiceConnector conn = new WebServiceConnector();
		conn.setWsdl(connectorRaw.getWsdl());
		populateConnectorFromRaw(conn, connectorRaw);
		webServiceConnectorRepository.persist(conn);
		return conn;
	}

	@Override
	public void update(WebServiceConnectorRaw connectorRaw)	throws EntityNotFoundException {
		WebServiceConnector conn = (WebServiceConnector) findById(connectorRaw.getId());
		conn.setWsdl(connectorRaw.getWsdl());
		populateConnectorFromRaw(conn, connectorRaw);				
	}

}
