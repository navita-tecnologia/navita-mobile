package br.com.navita.mobile.console.domain;

import javax.persistence.Entity;

@Entity
public class StaticConnector extends Connector {

	@Override
	public Class<? extends Operation> getOperationType() {
		
		return StaticOperation.class;
	}

	

}
