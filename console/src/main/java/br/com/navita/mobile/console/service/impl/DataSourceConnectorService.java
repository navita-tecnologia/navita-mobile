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
import br.com.navita.mobile.console.domain.DataSourceConnector;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.service.ConnectorService;
import br.com.navita.mobile.console.view.rawdata.DataSourceConnectorRaw;

@Transactional
public class DataSourceConnectorService extends BaseConnectorService implements ConnectorService<DataSourceConnector, DataSourceConnectorRaw> {

	private GenericRepository<DataSourceConnector> dataSourceConnectorRepository;
	
	public void setDataSourceConnectorRepository(
			GenericRepository<DataSourceConnector> dataSourceConnectorRepository) {
		this.dataSourceConnectorRepository = dataSourceConnectorRepository;
	}
	
	@Override
	public DataSourceConnector create(DataSourceConnectorRaw connectorRaw)
			throws EntityNotFoundException {
		DataSourceConnector conn = new DataSourceConnector();
		conn.setDataSource(connectorRaw.getDataSource());
		populateConnectorFromRaw(conn, connectorRaw);
		dataSourceConnectorRepository.persist(conn);
		return conn;
	}

	@Override
	public void update(DataSourceConnectorRaw connectorRaw)	throws EntityNotFoundException {
		DataSourceConnector conn = (DataSourceConnector) findById(connectorRaw.getId());
		conn.setDataSource(connectorRaw.getDataSource());
		populateConnectorFromRaw(conn, connectorRaw);				
	}

}
