package br.com.navita.mobile.console.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import br.com.navita.mobile.console.dao.jpa.GenericRepository;
import br.com.navita.mobile.console.dao.jpa.OperationRepository;
import br.com.navita.mobile.console.domain.entity.SapFunctionOperation;
import br.com.navita.mobile.console.domain.entity.SapParameter;
import br.com.navita.mobile.console.domain.entity.SapTable;
import br.com.navita.mobile.console.domain.entity.SapTableField;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.view.rawdata.SapFunctionOperationRaw;

@Transactional
public class SapFunctionOperationService extends BaseOperationService implements br.com.navita.mobile.console.service.SapFunctionOperationService{

	private OperationRepository<SapFunctionOperation> sapFunctionOperationRepository;
	private GenericRepository<SapParameter> sapParameterRepository;
	private GenericRepository<SapTable> sapTableRepository;
	private GenericRepository<SapTableField> sapTableFieldRepository;
	
	public void setSapTableFieldRepository(
			GenericRepository<SapTableField> sapTableFieldRepository) {
		this.sapTableFieldRepository = sapTableFieldRepository;
	}
	
	public void setSapParameterRepository(
			GenericRepository<SapParameter> sapParameterRepository) {
		this.sapParameterRepository = sapParameterRepository;
	}
	
	public void setSapTableRepository(
			GenericRepository<SapTable> sapTableRepository) {
		this.sapTableRepository = sapTableRepository;
	}
	
	public void setSapFunctionOperationRepository(
			OperationRepository<SapFunctionOperation> sapFunctionOperationRepository) {
		this.sapFunctionOperationRepository = sapFunctionOperationRepository;
	}
	
	@Override
	public SapFunctionOperation create(SapFunctionOperationRaw raw) throws EntityNotFoundException {
		SapFunctionOperation op = new SapFunctionOperation();
		populateOperationFromRaw(op, raw);
		op.setFunctionName(raw.getFunctionName());		
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
		
	}

	@Override
	public void addInputParameter(SapFunctionOperationRaw raw) throws EntityNotFoundException {
		SapParameter parameter = new SapParameter();
		parameter.setName(raw.getParameterName());
		parameter.setValue(raw.getParameterValue());
		SapFunctionOperation oper = (SapFunctionOperation) findById(raw.getId());
		oper.addInputParameter(parameter);		
		
	}

	@Override
	public void addOutputParameter(SapFunctionOperationRaw raw) throws EntityNotFoundException {
		SapParameter parameter = new SapParameter();
		parameter.setName(raw.getParameterName());
		parameter.setValue(raw.getParameterValue());
		SapFunctionOperation oper = (SapFunctionOperation) findById(raw.getId());
		oper.addOutputParameter(parameter);
		
	}

	@Override
	public void removeInputParameter(SapFunctionOperationRaw raw) throws EntityNotFoundException {
		SapFunctionOperation oper = (SapFunctionOperation) findById(raw.getId());
		SapParameter parameter = sapParameterRepository.findById(raw.getSapParameterId());
		oper.removeInputParameter(parameter);
		
	}
	@Override
	public void removeOutputParameter(SapFunctionOperationRaw raw) throws EntityNotFoundException {
		SapFunctionOperation oper = (SapFunctionOperation) findById(raw.getId());
		SapParameter parameter = sapParameterRepository.findById(raw.getSapParameterId());
		oper.removeOutputParameter(parameter);
		
	}
	
	@Override
	public void addInputTable(SapFunctionOperationRaw raw) throws EntityNotFoundException {
		SapTable table = new SapTable();
		table.setName(raw.getSapTableName());
		SapFunctionOperation oper = (SapFunctionOperation) findById(raw.getId());
		oper.addInputTable(table);
	}

	@Override
	public void addOutputTable(SapFunctionOperationRaw raw) throws EntityNotFoundException {
		SapTable table = new SapTable();
		table.setName(raw.getSapTableName());
		SapFunctionOperation oper = (SapFunctionOperation) findById(raw.getId());
		oper.addOutputTable(table);
		
	}

	@Override
	public void addTableRow(SapFunctionOperationRaw rRaw) {
		
		
	}

	@Override
	public void removeOutputTable(SapFunctionOperationRaw raw) throws EntityNotFoundException {
		SapFunctionOperation oper = (SapFunctionOperation) findById(raw.getId());
		SapTable table = sapTableRepository.findById(raw.getSapTableId());
		oper.removeOutputTable(table);
	}
	
	@Override
	public void removeInputTable(SapFunctionOperationRaw raw) throws EntityNotFoundException {
		SapFunctionOperation oper = (SapFunctionOperation) findById(raw.getId());
		SapTable table = sapTableRepository.findById(raw.getSapTableId());
		oper.removeInputTable(table);
		
	}

	@Override
	public void deleteTableRow(SapFunctionOperationRaw rRaw) {
		
		
	}

	@Override
	public SapTable findTableById(String id) throws EntityNotFoundException {
		
		return sapTableRepository.findById(id);
	}

	
	@Override
	public void updateTable(SapFunctionOperationRaw raw) {
		
		
	}

	@Override
	public void saveTable(SapFunctionOperationRaw raw)
			throws EntityNotFoundException {
		SapTable entity  = sapTableRepository.findById(raw.getSapTableId());
		entity.setName(raw.getSapTableName());		
		
	}

	@Override
	public void addSapTableField(SapFunctionOperationRaw raw)
			throws EntityNotFoundException {
		SapTable table = sapTableRepository.findById(raw.getSapTableId());
		SapTableField f = new SapTableField();
		f.setName(raw.getSapTabelFieldName());
		table.addField(f);
	}

	@Override
	public void removeSapTableField(SapFunctionOperationRaw raw)
			throws EntityNotFoundException {
		SapTableField f = sapTableFieldRepository.findById(raw.getSapTableFieldId());
		SapTable table = sapTableRepository.findById(raw.getSapTableId());
		table.removeField(f);
		
	}

}
