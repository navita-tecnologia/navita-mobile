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
