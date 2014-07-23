package br.com.navita.mobile.console.dao;

import java.util.List;

import br.com.navita.mobile.console.domain.Connector;

public interface ConnectorRepository<T extends Connector> extends GenericRepository<T> {

	Connector findByTag(String tag);

	List<Connector> findByAppId(String appId);

}
