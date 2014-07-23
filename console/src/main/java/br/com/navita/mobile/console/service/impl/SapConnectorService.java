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
import br.com.navita.mobile.console.domain.SapConnector;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.service.ConnectorService;
import br.com.navita.mobile.console.view.rawdata.SapConnectorRaw;

@Transactional
public class SapConnectorService extends BaseConnectorService implements ConnectorService<SapConnector, SapConnectorRaw> {

	private GenericRepository<SapConnector> sapConnectorRepository;
	
	public void setSapConnectorRepository(
			GenericRepository<SapConnector> sapConnectorRepository) {
		this.sapConnectorRepository = sapConnectorRepository;
	}
	
	@Override
	public SapConnector create(SapConnectorRaw connectorRaw)
			throws EntityNotFoundException {
		SapConnector conn = new SapConnector();
		conn.setClient(connectorRaw.getClient());
		conn.setAsHost(connectorRaw.getAsHost());
		conn.setLang(connectorRaw.getLang());
		conn.setSysnr(connectorRaw.getSysnr());
		conn.setRouter(connectorRaw.getRouter());		
		populateConnectorFromRaw(conn, connectorRaw);
		sapConnectorRepository.persist(conn);
		return conn;
	}

	@Override
	public void update(SapConnectorRaw connectorRaw)	throws EntityNotFoundException {
		SapConnector conn = (SapConnector) findById(connectorRaw.getId());
		conn.setClient(connectorRaw.getClient());
		conn.setAsHost(connectorRaw.getAsHost());
		conn.setLang(connectorRaw.getLang());
		conn.setSysnr(connectorRaw.getSysnr());
		conn.setRouter(connectorRaw.getRouter());
		populateConnectorFromRaw(conn, connectorRaw);				
	}

}
