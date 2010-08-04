package br.com.navita.mobile.console.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import br.com.navita.mobile.console.dao.jpa.GenericRepository;
import br.com.navita.mobile.console.domain.entity.Connector;
import br.com.navita.mobile.console.exception.EntityNotFoundException;

@Transactional
public class BaseConnectorService  implements br.com.navita.mobile.console.service.BaseConnectorService<Connector>{
	
	private GenericRepository<Connector> connectorRepository;
	
	public void setConnectorRepository(
			GenericRepository<Connector> connectorRepository) {
		this.connectorRepository = connectorRepository;
	}

	
	@Override
	public List<Connector> listAll() {		
		return connectorRepository.findAll();
	}


	@Override
	public Connector findById(String id) throws EntityNotFoundException {
		return connectorRepository.findById(id);
	}
	
	

}
