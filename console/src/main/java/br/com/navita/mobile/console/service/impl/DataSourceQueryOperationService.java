package br.com.navita.mobile.console.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import br.com.navita.mobile.console.dao.jpa.OperationRepository;
import br.com.navita.mobile.console.domain.entity.DataSourceQueryOperation;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.service.OperationService;
import br.com.navita.mobile.console.view.rawdata.DataSourceQueryOperationRaw;

@Transactional
public class DataSourceQueryOperationService extends BaseOperationService implements OperationService<DataSourceQueryOperation, DataSourceQueryOperationRaw>{

	private OperationRepository<DataSourceQueryOperation> dataSourceQueryOperationRepository;
	
	public void setDataSourceQueryOperationRepository(
			OperationRepository<DataSourceQueryOperation> dataSourceQueryOperationRepository) {
		this.dataSourceQueryOperationRepository = dataSourceQueryOperationRepository;
	}
	
	@Override
	public DataSourceQueryOperation create(DataSourceQueryOperationRaw operationRaw) throws EntityNotFoundException {
		DataSourceQueryOperation op = new DataSourceQueryOperation();
		op.setQuery(operationRaw.getQuery());
		populateOperationFromRaw(op, operationRaw);
		dataSourceQueryOperationRepository.persist(op);
		return op;
	}

	@Override
	public List<DataSourceQueryOperation> getConnectorOperations(String connectorId) {		
		return dataSourceQueryOperationRepository.listConnectorOperations(connectorId);
	}

	@Override
	public void remove(String id) throws EntityNotFoundException {
		DataSourceQueryOperation entity = (DataSourceQueryOperation) dataSourceQueryOperationRepository.findById(id);
		dataSourceQueryOperationRepository.remove(entity);
		
	}

	@Override
	public void update(DataSourceQueryOperationRaw operationRaw) throws EntityNotFoundException {
			DataSourceQueryOperation op = (DataSourceQueryOperation) dataSourceQueryOperationRepository.findById(operationRaw.getId());
			op.setQuery(operationRaw.getQuery());
			populateOperationFromRaw(op, operationRaw);
			
	}

}
