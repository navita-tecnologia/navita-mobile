package br.com.navita.mobile.console.view.rawdata;

import java.util.Set;

import br.com.navita.mobile.console.domain.entity.SapParameter;

public interface SapFunctionOperationRaw extends OperationRaw {
	
	String getFunctionName();
	Set<SapParameter> getInputParameters();

}
