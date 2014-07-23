/*
 * Copyright 2014 Navita Tecnologia.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.navita.mobile.console.service.impl;

import org.springframework.transaction.annotation.Transactional;

import br.com.navita.mobile.console.dao.GenericRepository;
import br.com.navita.mobile.console.domain.StaticConnector;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.service.ConnectorService;
import br.com.navita.mobile.console.view.rawdata.ConnectorRaw;

@Transactional
public class StaticConnectorService extends BaseConnectorService implements ConnectorService<StaticConnector, ConnectorRaw> {

	private GenericRepository<StaticConnector> staticConnectorRepository;
	
	public void setStaticConnectorRepository(
			GenericRepository<StaticConnector> staticConnectorRepository) {
		this.staticConnectorRepository = staticConnectorRepository;
	}

	@Override
	public StaticConnector create(ConnectorRaw connectorRaw) throws EntityNotFoundException {
		StaticConnector conn = new StaticConnector();		
		populateConnectorFromRaw(conn, connectorRaw);		
		staticConnectorRepository.persist(conn);
		return conn;
	}
	
	

	@Override
	public void update(ConnectorRaw connectorRaw) throws EntityNotFoundException {
		StaticConnector conn = (StaticConnector) findById(connectorRaw.getId());
		populateConnectorFromRaw(conn, connectorRaw);
	}


}
