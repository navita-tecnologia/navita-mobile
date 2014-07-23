package br.com.navita.test;

import java.util.Map;

import br.com.navita.mobile.console.exception.SapGatewayException;
import br.com.navita.mobile.domain.MobileBean;

public abstract class SapExecution {
	protected SapExecutionConfig config;
	public void setConfig(SapExecutionConfig config) {
		this.config = config;
	}
	
	protected abstract MobileBean execute( Map<String, Object> params) throws SapGatewayException;
	
}
