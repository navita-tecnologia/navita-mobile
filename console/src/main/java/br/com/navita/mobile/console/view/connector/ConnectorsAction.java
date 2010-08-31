package br.com.navita.mobile.console.view.connector;

import java.util.List;

import br.com.navita.mobile.console.domain.entity.AuthContainer;
import br.com.navita.mobile.console.domain.entity.Connector;

public class ConnectorsAction extends ConnectorRawActionSupport {
	
	private String type;
	private String operationId;
	
	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}
	
	public String getOperationId() {
		return operationId;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public List<Connector> getAllConnectors(){
		return baseConnectorService.listAll();
	}
	
	public List<AuthContainer> getAuthContainers(){
		return authContainerService.listAll();
	}
	
	public String remove() throws Exception{
		baseConnectorService.remove(id);
		addActionMessage("Removido com sucesso");		
		return SUCCESS;
	}
	
	public String removeOperation() throws Exception{
		baseOperationService.remove(operationId);
		addActionMessage("Removido com sucesso");		
		return edit();
	}
	
	public String edit() throws Exception{
		connector = baseConnectorService.findById(id);
		return connector.getClass().getSimpleName();		
	}
	
	public String prepareCreate(){		
		return INPUT;
	}
	
	public String preCreate() throws Exception{
		connector = (Connector) Class.forName("br.com.navita.mobile.console.domain.entity."+type).newInstance();
		return type;
	}

	
	
	
	
}
