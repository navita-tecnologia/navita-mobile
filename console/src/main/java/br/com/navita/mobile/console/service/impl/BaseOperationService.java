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

import br.com.navita.mobile.console.dao.OperationRepository;
import br.com.navita.mobile.console.domain.Connector;
import br.com.navita.mobile.console.domain.LicenseBundle;
import br.com.navita.mobile.console.domain.Operation;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.service.BaseConnectorService;
import br.com.navita.mobile.console.service.LicenseService;
import br.com.navita.mobile.console.view.rawdata.OperationRaw;

@Transactional
public class BaseOperationService implements br.com.navita.mobile.console.service.BaseOperationService<Operation>{

	protected OperationRepository<Operation> operationRepository;
	protected LicenseService licenseService;
	protected BaseConnectorService<Connector> baseConnectorService;
	public void setBaseConnectorService(
			BaseConnectorService<Connector> baseConnectorService) {
		this.baseConnectorService = baseConnectorService;
	}

	public void setOperationRepository(
			OperationRepository<Operation> operationRepository) {
		this.operationRepository = operationRepository;
	}

	public void setLicenseService(LicenseService licenseService) {
		this.licenseService = licenseService;
	}


	@Override
	public Operation findById(String id) throws EntityNotFoundException {		
		return operationRepository.findById(id);
	}

	protected void populateOperationFromRaw(Operation op, OperationRaw raw) throws EntityNotFoundException{
		if(raw.getLicenseBundleId() != null && ! raw.getLicenseBundleId().isEmpty()){
			LicenseBundle bundle = licenseService.getBundle(raw.getLicenseBundleId());
			op.setLicenseBundle(bundle);
		}
		Connector connector = baseConnectorService.findById(raw.getConnectorId());
		op.setConnector(connector);
		op.setLicenseKey(raw.getLicenseKey());
		op.setName(raw.getName());
		op.setTag(raw.getTag());
	}

	@Override
	public void remove(String id) throws EntityNotFoundException {
		Operation op = operationRepository.findById(id);
		operationRepository.remove(op);
		
	}

	@Override
	public boolean isTagUniqueForConnector(String tag, String connectorId) throws EntityNotFoundException {
		
		return operationRepository.findByTagAndConnectorId(tag,connectorId) == null;
	}

	@Override
	public boolean isTagUniqueForIdAndConnector(String tag, String operationId,
			String connectorId) throws EntityNotFoundException {
		Operation operation = operationRepository.findByTagAndConnectorId(tag,connectorId);
		
		return operation == null || operation.getId().equals(operationId);
	}

	@Override
	public Operation findByTagAndConnectorId(String connectorId, String operationTag) {		
		return operationRepository.findByTagAndConnectorId(operationTag,connectorId);
	}


}
