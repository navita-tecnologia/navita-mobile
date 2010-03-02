package br.com.navita.mobile.console.sap;

import java.util.Map;

import br.com.navita.mobile.domain.MobileBean;
import br.com.navita.mobile.console.exception.SapGatewayException;

public abstract class SapExecution {
	protected SapExecutionConfig config;
	public void setConfig(SapExecutionConfig config) {
		this.config = config;
	}
	
	protected abstract MobileBean execute( Map<String, Object> params) throws SapGatewayException;
	
	
}
