package br.com.navita.mobile.console.service.impl;

import java.util.List;

import br.com.navita.mobile.console.dao.jpa.OperationRepository;
import br.com.navita.mobile.console.domain.entity.SapFunctionOperation;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.service.OperationService;
import br.com.navita.mobile.console.view.rawdata.SapFunctionOperationRaw;

public class SapFunctionOperationService extends BaseOperationService implements OperationService<SapFunctionOperation, SapFunctionOperationRaw> {

	private OperationRepository<SapFunctionOperation> sapFunctionOperationRepository;
	
	public void setSapFunctionOperationRepository(
			OperationRepository<SapFunctionOperation> sapFunctionOperationRepository) {
		this.sapFunctionOperationRepository = sapFunctionOperationRepository;
	}
	
	@Override
	public SapFunctionOperation create(SapFunctionOperationRaw raw) throws EntityNotFoundException {
		SapFunctionOperation op = new SapFunctionOperation();
		populateOperationFromRaw(op, raw);
		op.setFunctionName(raw.getFunctionName());
		op.setInputParameters(raw.getInputParameters());
		sapFunctionOperationRepository.persist(op);
		return op;
	}

	@Override
	public List<SapFunctionOperation> getConnectorOperations(String connectorId) {		
		return sapFunctionOperationRepository.listConnectorOperations(connectorId);
	}

	@Override
	public void remove(String id) throws EntityNotFoundException {
		SapFunctionOperation entity = (SapFunctionOperation) sapFunctionOperationRepository.findById(id);
		sapFunctionOperationRepository.remove(entity);		
	}

	@Override
	public void update(SapFunctionOperationRaw raw) throws EntityNotFoundException {
		SapFunctionOperation op = (SapFunctionOperation) sapFunctionOperationRepository.findById(raw.getId());
		populateOperationFromRaw(op, raw);
		op.setFunctionName(raw.getFunctionName());
		op.setInputParameters(raw.getInputParameters());
		
	}

}
