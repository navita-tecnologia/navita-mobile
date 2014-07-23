package br.com.navita.mobile.console.operator;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.navita.mobile.console.domain.Connector;
import br.com.navita.mobile.console.domain.DataSourceQueryOperation;
import br.com.navita.mobile.console.domain.EjbConnector;
import br.com.navita.mobile.console.domain.Operation;
import br.com.navita.mobile.console.domain.ProxyConnector;
import br.com.navita.mobile.console.domain.SapFunctionOperation;
import br.com.navita.mobile.console.domain.StaticOperation;
import br.com.navita.mobile.console.domain.WebServiceConnector;
import br.com.navita.mobile.domain.MobileBean;

public class GenericOperator implements ConnectorOperator,Operator {
	
	@Autowired
	private Operator staticOperator;
	@Autowired
	private Operator dataSourceOperator;
	@Autowired
	private Operator sapOperator;
	@Autowired
	private ConnectorOperator ejbOperator;
	@Autowired
	private ConnectorOperator proxyOperator;
	@Autowired
	private ConnectorOperator wsOperator;
	
	
	

	public void setStaticOperator(Operator staticOperator) {
		this.staticOperator = staticOperator;
	}

	public void setDataSourceOperator(Operator dataSourceOperator) {
		this.dataSourceOperator = dataSourceOperator;
	}

	public void setSapOperator(Operator sapOperator) {
		this.sapOperator = sapOperator;
	}

	public void setEjbOperator(ConnectorOperator ejbOperator) {
		this.ejbOperator = ejbOperator;
	}

	public void setProxyOperator(ConnectorOperator proxyOperator) {
		this.proxyOperator = proxyOperator;
	}

	public void setWsOperator(ConnectorOperator wsOperator) {
		this.wsOperator = wsOperator;
	}

	@Override
	public MobileBean doConnectorOperation(Connector connector,	Map<String, Object> params) throws Exception {		
		return getConnectorOperator(connector).doConnectorOperation(connector,params);
	}

	@Override
	public MobileBean doOperation(Operation operation,	Map<String, Object> params) throws Exception {
		return getOperator(operation).doOperation(operation,params);
	}

	private Operator getOperator(Operation operation) {
		if(operation instanceof StaticOperation){
			return staticOperator;
		}		
		if(operation instanceof DataSourceQueryOperation){
			return dataSourceOperator;
		}
		if(operation instanceof SapFunctionOperation){
			return sapOperator;
		}		
		
		return null;
	}

	private ConnectorOperator getConnectorOperator(Connector connector) {
		if(connector instanceof EjbConnector){
			return ejbOperator;
		}
		if(connector instanceof ProxyConnector){
			return proxyOperator;
		}
		if(connector instanceof WebServiceConnector){
			return wsOperator;
		}
		
		return null;
	}

}
