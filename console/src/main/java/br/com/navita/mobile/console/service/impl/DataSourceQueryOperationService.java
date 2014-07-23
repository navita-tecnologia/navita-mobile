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

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import br.com.navita.mobile.console.dao.OperationRepository;
import br.com.navita.mobile.console.domain.DataSourceQueryOperation;
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
		op.setReturnResultSet(operationRaw.isReturnResultSet());
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
			op.setReturnResultSet(operationRaw.isReturnResultSet());
			populateOperationFromRaw(op, operationRaw);
			
	}

}
