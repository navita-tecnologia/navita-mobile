package br.com.navita.mobile.console.service;

import br.com.navita.mobile.console.domain.entity.SapFunctionOperation;
import br.com.navita.mobile.console.domain.entity.SapTable;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.view.rawdata.SapFunctionOperationRaw;

public interface SapFunctionOperationService extends OperationService<SapFunctionOperation, SapFunctionOperationRaw> {
	
	void addInputParameter(SapFunctionOperationRaw raw) throws EntityNotFoundException;
	void addOutputParameter(SapFunctionOperationRaw raw) throws EntityNotFoundException;	
	void removeInputParameter(SapFunctionOperationRaw raw) throws EntityNotFoundException;
	void removeOutputParameter(SapFunctionOperationRaw raw) throws EntityNotFoundException;
	
	SapTable findTableById(String id) throws EntityNotFoundException;	
	void addInputTable(SapFunctionOperationRaw raw) throws EntityNotFoundException;
	void addOutputTable(SapFunctionOperationRaw raw)throws EntityNotFoundException;
	void updateTable(SapFunctionOperationRaw raw) throws EntityNotFoundException;
	void removeInputTable(SapFunctionOperationRaw raw) throws EntityNotFoundException;
	void removeOutputTable(SapFunctionOperationRaw raw) throws EntityNotFoundException;
	void saveTable(SapFunctionOperationRaw raw)throws EntityNotFoundException;
	
	void addTableRow(SapFunctionOperationRaw rRaw) throws EntityNotFoundException;
	void removeTableRow(SapFunctionOperationRaw raw) throws EntityNotFoundException;
	void addSapTableField(SapFunctionOperationRaw raw) throws EntityNotFoundException;
	void removeSapTableField(SapFunctionOperationRaw raw) throws EntityNotFoundException;
	
	
}
