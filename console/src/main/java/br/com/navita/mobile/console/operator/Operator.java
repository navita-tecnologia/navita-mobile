package br.com.navita.mobile.console.operator;

import java.util.Map;

import br.com.navita.mobile.console.domain.Operation;
import br.com.navita.mobile.domain.MobileBean;

public interface Operator {
	
	MobileBean doOperation(Operation operation, Map<String,Object> params) throws Exception;
	
}
