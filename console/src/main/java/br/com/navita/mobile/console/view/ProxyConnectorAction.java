package br.com.navita.mobile.console.view;

import br.com.navita.mobile.console.domain.entity.ProxyConnector;
import br.com.navita.mobile.console.service.ConnectorService;
import br.com.navita.mobile.console.view.rawdata.ProxyConnectorRaw;

public class ProxyConnectorAction extends ConnectorsAction implements ProxyConnectorRaw {
	
	private ConnectorService<ProxyConnector,ProxyConnectorRaw> proxyConnectorService;
	
	public void setProxyConnectorService(
			ConnectorService<ProxyConnector, ProxyConnectorRaw> proxyConnectorService) {
		this.proxyConnectorService = proxyConnectorService;
	}

	private String url;
	@Override
	public String getUrl() {		
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String save() throws Exception{		
		proxyConnectorService.update(this);
		addActionMessage("Salvo com sucesso");
		return edit();
	}

	public String create() throws Exception{		
		connector =	proxyConnectorService.create(this);
		addActionMessage("Criado com sucesso");
		id = connector.getId();
		return edit();
	}
	
}
