package br.com.navita.mobile.console.service;

import java.util.List;

import br.com.navita.mobile.console.domain.entity.Connector;
import br.com.navita.mobile.console.exception.EntityNotFoundException;


public interface BaseConnectorService<T extends Connector> {
	List<T> listAll();
	T findById(String id) throws EntityNotFoundException;

}
