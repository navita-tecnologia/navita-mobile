package br.com.navita.mobile.console.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class WebServiceConnector extends Connector {

	
	@Column
	private String wsdl;
	
	public String getWsdl() {
		return wsdl;
	}
	
	public void setWsdl(String wsdl) {
		this.wsdl = wsdl;
	}

	@Override
	public Class<? extends Operation> getOperationType() {
		// nenhuma opracao permitida
		return null;
	}

	
	
}
