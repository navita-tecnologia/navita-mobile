package br.com.navita.mobile.console.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class EjbConnector extends Connector {

	@Column
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

	@Override
	public Operation createDynamicOperation(String operationTag) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
