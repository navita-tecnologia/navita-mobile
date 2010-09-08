package br.com.navita.mobile.console.dao;

import br.com.navita.mobile.console.domain.Connector;

public interface ConnectorRepository<T extends Connector> extends GenericRepository<T> {

	Connector findByTag(String tag);

}
