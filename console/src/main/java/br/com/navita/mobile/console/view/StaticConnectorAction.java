package br.com.navita.mobile.console.view;

import br.com.navita.mobile.console.domain.entity.StaticConnector;
import br.com.navita.mobile.console.service.ConnectorService;
import br.com.navita.mobile.console.view.rawdata.ConnectorRaw;

public class StaticConnectorAction extends ConnectorsAction {

	private ConnectorService<StaticConnector,ConnectorRaw> staticConnectorService;
	public void setStaticConnectorService(
			ConnectorService<StaticConnector, ConnectorRaw> staticConnectorService) {
		this.staticConnectorService = staticConnectorService;
	}
	
	public String save() throws Exception{		
		staticConnectorService.update(this);
		addActionMessage("Salvo com sucesso");
		return edit();
	}
}
