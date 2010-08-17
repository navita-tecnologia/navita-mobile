package br.com.navita.mobile.console.domain.entity;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.navita.mobile.domain.MobileBean;

@Entity
public class ProxyConnector extends Connector {

	
	@Column
	private String url;
	
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public Class<? extends Operation> getOperationType() {
		// nenhuma opracao admitida
		return null;
	}

	@Override
	public Operation createDynamicOperation(String operationTag) {		
		return new ProxyOperation();
	}
	
	class ProxyOperation extends Operation{

		@Override
		public MobileBean process(Map<?, ?> params) throws Exception {
			
			return null;
		}
		
	}
}
