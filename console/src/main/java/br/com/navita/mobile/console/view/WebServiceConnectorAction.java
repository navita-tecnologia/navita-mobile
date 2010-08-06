package br.com.navita.mobile.console.view;

import br.com.navita.mobile.console.domain.entity.WebServiceConnector;
import br.com.navita.mobile.console.service.ConnectorService;
import br.com.navita.mobile.console.view.rawdata.WebServiceConnectorRaw;

public class WebServiceConnectorAction extends ConnectorsAction implements WebServiceConnectorRaw {
	
	private ConnectorService<WebServiceConnector,WebServiceConnectorRaw> webServiceConnectorService;
	private String wsdl;
	
	public void setWebServiceConnectorService(
			ConnectorService<WebServiceConnector, WebServiceConnectorRaw> webServiceConnectorService) {
		this.webServiceConnectorService = webServiceConnectorService;
	}
	
	@Override
	public String getWsdl() {		
		return wsdl;
	}
	public void setWsdl(String wsdl) {
		this.wsdl = wsdl;
	}
	
	public String save() throws Exception{		
		webServiceConnectorService.update(this);
		addActionMessage("Salvo com sucesso");
		return edit();
	}

	public String create() throws Exception{		
		connector =	webServiceConnectorService.create(this);
		addActionMessage("Criado com sucesso");
		id = connector.getId();
		return edit();
	}
}
