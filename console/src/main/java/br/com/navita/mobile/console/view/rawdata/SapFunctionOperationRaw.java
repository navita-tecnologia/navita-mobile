package br.com.navita.mobile.console.view.rawdata;


public interface SapFunctionOperationRaw extends OperationRaw {
	
	String getFunctionName();
		
	String getSapParameterId();
	
	String getParameterName();

	String getParameterValue();

	String getSapTableName();

}
