package br.com.navita.mobile.console.operator;

import java.util.Map;

import br.com.navita.mobile.console.domain.entity.Connector;
import br.com.navita.mobile.domain.MobileBean;

public interface ConnectorOperator {	
	MobileBean doConnectorOperation(Connector connector, Map<String,Object> params) throws Exception;

}
