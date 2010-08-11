package br.com.navita.mobile.console.service;

import br.com.navita.mobile.console.view.rawdata.SapFunctionOperationRaw;
import br.com.navita.mobile.console.view.rawdata.SapParameterRaw;
import br.com.navita.mobile.console.view.rawdata.SapTableRaw;
import br.com.navita.mobile.console.view.rawdata.SapTableRowRaw;

public interface SapFunctionService {

	void addInputParameter(SapFunctionOperationRaw function,SapParameterRaw raw);
	void addOutputParameter(SapFunctionOperationRaw function,SapParameterRaw raw);
	void saveParameter(SapParameterRaw raw);
	void deleteParameter(SapParameterRaw raw);
	
	void addInputTable(SapFunctionOperationRaw fRaw, SapTableRaw tRaw);
	void addOutputTable(SapFunctionOperationRaw fRaw, SapTableRaw tRaw);
	void saveTable(SapTableRaw tRaw);
	void deleteTable(SapTableRaw tRaw);
	
	void addTableRow(SapTableRaw tRaw, SapTableRowRaw rRaw);
	void deleteTableRow(SapTableRaw tRaw, SapTableRowRaw rRaw);
	
	
	
}
