package br.com.navita.mobile.console.service;

import java.util.List;

import br.com.navita.mobile.console.domain.Connector;
import br.com.navita.mobile.console.exception.EntityNotFoundException;


public interface BaseConnectorService<T extends Connector> {
	List<T> listByApp(String appId);
	T findById(String id) throws EntityNotFoundException;
	void remove(String id)throws EntityNotFoundException;
	boolean isTagUnique(String tag)throws EntityNotFoundException;
	boolean isTagUniqueForId(String tag,String id)throws EntityNotFoundException;
	T findByTag(String connectorTag);
	

}
