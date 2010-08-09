package br.com.navita.mobile.console.domain.entity;

import javax.persistence.Entity;

@Entity
public class EjbConnector extends Connector {

	private String ejbName;

	public String getEjbName() {
		return ejbName;
	}

	public void setEjbName(String ejbName) {
		this.ejbName = ejbName;
	}

	@Override
	public Class<? extends Operation> getOperationType() {
		// Nenhuma operacao admitida 
		return null;
	}
	
	
}
