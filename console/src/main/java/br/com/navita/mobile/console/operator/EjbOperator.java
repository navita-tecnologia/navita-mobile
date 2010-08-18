package br.com.navita.mobile.console.operator;

import java.util.Map;

import br.com.navita.mobile.console.domain.entity.Connector;
import br.com.navita.mobile.domain.MobileBean;

public class EjbOperator implements ConnectorOperator{

	@Override
	public MobileBean doConnectorOperation(Connector connector,	Map<String, Object> params) {
		return null;
	}

	

}
