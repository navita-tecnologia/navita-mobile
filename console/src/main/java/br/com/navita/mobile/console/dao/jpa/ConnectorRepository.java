package br.com.navita.mobile.console.dao.jpa;

import br.com.navita.mobile.console.domain.entity.Connector;

public interface ConnectorRepository<T extends Connector> extends GenericRepository<T> {

	Connector findByTag(String tag);

}
