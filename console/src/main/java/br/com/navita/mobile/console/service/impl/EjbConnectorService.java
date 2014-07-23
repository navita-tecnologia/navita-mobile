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
import br.com.navita.mobile.console.domain.EjbConnector;
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
