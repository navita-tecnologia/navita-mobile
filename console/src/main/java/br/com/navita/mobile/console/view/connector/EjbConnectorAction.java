package br.com.navita.mobile.console.view.connector;

import br.com.navita.mobile.console.domain.entity.EjbConnector;
import br.com.navita.mobile.console.service.ConnectorService;
import br.com.navita.mobile.console.view.rawdata.EjbConnectorRaw;

public class EjbConnectorAction extends ConnectorsAction implements EjbConnectorRaw {

	private ConnectorService<EjbConnector,EjbConnectorRaw> ejbConnectorService;
	
	private String ejbName;
	
	public void setEjbConnectorService(
			ConnectorService<EjbConnector, EjbConnectorRaw> ejbConnectorService) {
		this.ejbConnectorService = ejbConnectorService;
	}

	public String save() throws Exception{	
		if(! baseConnectorService.isTagUniqueForId(tag, id)){
			addActionError("Tag " + tag + " duplicada");
			return edit();
		}
		ejbConnectorService.update(this);
		addActionMessage("Salvo com sucesso");
		return edit();
	}

	public String create() throws Exception{
		if(! baseConnectorService.isTagUnique(tag)){
			addActionError("Tag " + tag + " duplicada");
			return preCreate();
		}
		connector =	ejbConnectorService.create(this);
		addActionMessage("Criado com sucesso");
		id = connector.getId();
		return edit();
	}

	public String getEjbName() {
		return ejbName;
	}
	
	public void setEjbName(String ejbName) {
		this.ejbName = ejbName;
	}
}
