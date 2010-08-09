package br.com.navita.mobile.console.service.impl;

import org.springframework.transaction.annotation.Transactional;

import br.com.navita.mobile.console.dao.jpa.GenericRepository;
import br.com.navita.mobile.console.domain.entity.Operation;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.service.LicenseService;

@Transactional
public class BaseOperationService implements br.com.navita.mobile.console.service.BaseOperationService<Operation>{

	protected GenericRepository<Operation> operationRepository;
	protected LicenseService licenseService;
	
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

}
