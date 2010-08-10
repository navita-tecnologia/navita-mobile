package br.com.navita.mobile.console.service.impl;

import org.springframework.transaction.annotation.Transactional;

import br.com.navita.mobile.console.dao.jpa.GenericRepository;
import br.com.navita.mobile.console.domain.entity.Connector;
import br.com.navita.mobile.console.domain.entity.LicenseBundle;
import br.com.navita.mobile.console.domain.entity.Operation;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.service.BaseConnectorService;
import br.com.navita.mobile.console.service.LicenseService;
import br.com.navita.mobile.console.view.rawdata.OperationRaw;

@Transactional
public class BaseOperationService implements br.com.navita.mobile.console.service.BaseOperationService<Operation>{

	protected GenericRepository<Operation> operationRepository;
	protected LicenseService licenseService;
	protected BaseConnectorService<Connector> baseConnectorService;
	public void setBaseConnectorService(
			BaseConnectorService<Connector> baseConnectorService) {
		this.baseConnectorService = baseConnectorService;
	}

	public void setOperationRepository(
			GenericRepository<Operation> operationRepository) {
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


}
