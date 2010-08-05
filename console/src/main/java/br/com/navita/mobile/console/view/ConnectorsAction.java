package br.com.navita.mobile.console.view;

import java.util.List;

import br.com.navita.mobile.console.domain.entity.Connector;

public class ConnectorsAction extends ConnectorRawActionSupport {
	
	

	public List<Connector> getAllConnectors(){
		return baseConnectorService.listAll();
	}
	
	public String remove() throws Exception{
		baseConnectorService.remove(id);
		addActionMessage("Removido com sucesso");		
		return SUCCESS;
	}
	
	public String edit() throws Exception{
		connector = baseConnectorService.findById(id);
		return connector.getClass().getSimpleName();		
	}
	
	
	
}
