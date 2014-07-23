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
import br.com.navita.mobile.console.domain.StaticOperation;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.service.OperationService;
import br.com.navita.mobile.console.view.rawdata.StaticOperationRaw;

@Transactional
public class StaticOperationService extends BaseOperationService implements OperationService<StaticOperation, StaticOperationRaw> {
	private OperationRepository<StaticOperation> staticOperationRepository;	

	public void setStaticOperationRepository(
			OperationRepository<StaticOperation> staticOperationRepository) {
		this.staticOperationRepository = staticOperationRepository;
	}

	@Override
	public StaticOperation create(StaticOperationRaw raw) throws EntityNotFoundException {
		StaticOperation oper = new StaticOperation();
		populateOperationFromRaw(oper, raw);		
		oper.setList(raw.getList());
		oper.setMessage(raw.getMessage());
		oper.setName(raw.getName());
		oper.setObject(raw.getObject());
		oper.setResultCode(raw.getResultCode());
		oper.setToken(raw.getToken());
		staticOperationRepository.persist(oper);
		return oper;
		

	}

	@Override
	public List<StaticOperation> getConnectorOperations(String connectorId) {
		return staticOperationRepository.listConnectorOperations(connectorId);
	}

	@Override
	public void remove(String id) throws EntityNotFoundException {
		staticOperationRepository.remove(staticOperationRepository.findById(id));

	}

	@Override
	public void update(StaticOperationRaw raw) throws EntityNotFoundException {
		StaticOperation oper = (StaticOperation) staticOperationRepository.findById(raw.getId());
		populateOperationFromRaw(oper, raw);		
		oper.setList(raw.getList());
		oper.setMessage(raw.getMessage());
		oper.setName(raw.getName());
		oper.setObject(raw.getObject());
		oper.setResultCode(raw.getResultCode());
		oper.setToken(raw.getToken());

	}

	

}
