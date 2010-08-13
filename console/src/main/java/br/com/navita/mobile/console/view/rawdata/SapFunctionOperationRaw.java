package br.com.navita.mobile.console.view.rawdata;

import java.util.List;


public interface SapFunctionOperationRaw extends OperationRaw {
	
	String getFunctionName();
		
	String getSapParameterId();
	
	String getParameterName();

	String getParameterValue();

	String getSapTableName();

	String getSapTableId();

	String getSapTabelFieldName();

	String getSapTableFieldId();
	
	List<SapFieldRaw> getSapRowRaw() ;

	String getSapRowId();

}
