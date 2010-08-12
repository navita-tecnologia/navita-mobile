package br.com.navita.mobile.console.service;

import br.com.navita.mobile.console.domain.entity.SapFunctionOperation;
import br.com.navita.mobile.console.domain.entity.SapTable;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.view.rawdata.SapFunctionOperationRaw;
import br.com.navita.mobile.console.view.rawdata.SapTableRowRaw;

public interface SapFunctionOperationService extends OperationService<SapFunctionOperation, SapFunctionOperationRaw> {
	
	void addInputParameter(SapFunctionOperationRaw raw) throws EntityNotFoundException;
	void addOutputParameter(SapFunctionOperationRaw raw) throws EntityNotFoundException;	
	void removeInputParameter(SapFunctionOperationRaw raw) throws EntityNotFoundException;
	void removeOutputParameter(SapFunctionOperationRaw raw) throws EntityNotFoundException;
	
	SapTable findTableById(String id) throws EntityNotFoundException;	
	void addInputTable(SapFunctionOperationRaw raw) throws EntityNotFoundException;
	void addOutputTable(SapFunctionOperationRaw raw)throws EntityNotFoundException;
	void updateTable(SapFunctionOperationRaw raw);
	void deleteTable(String id);
	
	void addTableRow(SapTableRowRaw rRaw);
	void deleteTableRow(SapTableRowRaw rRaw);
}
