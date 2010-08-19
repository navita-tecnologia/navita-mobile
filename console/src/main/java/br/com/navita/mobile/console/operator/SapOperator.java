package br.com.navita.mobile.console.operator;

import java.util.Map;

import br.com.navita.mobile.console.domain.entity.Operation;
import br.com.navita.mobile.console.domain.entity.SapFunctionOperation;
import br.com.navita.mobile.domain.MobileBean;

public class SapOperator implements Operator{

	

	@Override
	public MobileBean doOperation(Operation operation, Map<String, Object> params) {
		SapFunctionOperation sapOperation = (SapFunctionOperation) operation;
		
		return null;
	}

}

