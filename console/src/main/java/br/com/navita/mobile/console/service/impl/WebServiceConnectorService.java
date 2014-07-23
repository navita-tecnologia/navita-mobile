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
import br.com.navita.mobile.console.domain.WebServiceConnector;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.service.ConnectorService;
import br.com.navita.mobile.console.view.rawdata.WebServiceConnectorRaw;

@Transactional
public class WebServiceConnectorService extends BaseConnectorService implements ConnectorService<WebServiceConnector, WebServiceConnectorRaw> {

	private GenericRepository<WebServiceConnector> webServiceConnectorRepository;
	
	public void setWebServiceConnectorRepository(
			GenericRepository<WebServiceConnector> webServiceConnectorRepository) {
		this.webServiceConnectorRepository = webServiceConnectorRepository;
	}
	
	@Override
	public WebServiceConnector create(WebServiceConnectorRaw connectorRaw)
			throws EntityNotFoundException {
		WebServiceConnector conn = new WebServiceConnector();
		conn.setWsdl(connectorRaw.getWsdl());
		populateConnectorFromRaw(conn, connectorRaw);
		webServiceConnectorRepository.persist(conn);
		return conn;
	}

	@Override
	public void update(WebServiceConnectorRaw connectorRaw)	throws EntityNotFoundException {
		WebServiceConnector conn = (WebServiceConnector) findById(connectorRaw.getId());
		conn.setWsdl(connectorRaw.getWsdl());
		populateConnectorFromRaw(conn, connectorRaw);				
	}

}
