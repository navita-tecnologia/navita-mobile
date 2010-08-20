package br.com.navita.mobile.console.operator.sap;

import java.util.Map;

import br.com.navita.mobile.console.domain.entity.Operation;
import br.com.navita.mobile.console.domain.entity.SapFunctionOperation;
import br.com.navita.mobile.console.operator.Operator;
import br.com.navita.mobile.domain.MobileBean;

public class SapOperator implements Operator{

	

	@Override
	public MobileBean doOperation(Operation operation, Map<String, Object> params) {
		SapFunctionOperation sapOperation = (SapFunctionOperation) operation;
		
		
		
		return null;
	}

}

