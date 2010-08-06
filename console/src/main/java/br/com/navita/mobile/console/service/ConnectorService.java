package br.com.navita.mobile.console.service;

import br.com.navita.mobile.console.domain.entity.Connector;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.view.rawdata.ConnectorRaw;


public interface ConnectorService<T extends Connector, W extends ConnectorRaw> extends BaseConnectorService<Connector> {
	T create(W connectorRaw) throws EntityNotFoundException;
	void update(W connectorRaw) throws EntityNotFoundException;	

}
