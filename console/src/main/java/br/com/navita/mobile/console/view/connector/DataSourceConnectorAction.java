package br.com.navita.mobile.console.view.connector;

import br.com.navita.mobile.console.domain.entity.DataSourceConnector;
import br.com.navita.mobile.console.service.ConnectorService;
import br.com.navita.mobile.console.view.rawdata.DataSourceConnectorRaw;

public class DataSourceConnectorAction extends ConnectorsAction implements DataSourceConnectorRaw {

	private ConnectorService<DataSourceConnector,DataSourceConnectorRaw> dataSourceConnectorService;
	
	private String dataSource;
	
	public void setDataSourceConnectorService(
			ConnectorService<DataSourceConnector, DataSourceConnectorRaw> dataSourceConnectorService) {
		this.dataSourceConnectorService = dataSourceConnectorService;
	}

	public String save() throws Exception{	
		if(! baseConnectorService.isTagUniqueForId(tag, id)){
			addActionError("Tag " + tag + " duplicada");
			return  edit();
		}
		dataSourceConnectorService.update(this);
		addActionMessage("Salvo com sucesso");
		return edit();
	}

	public String create() throws Exception{	
		if(! baseConnectorService.isTagUnique(tag)){
			addActionError("Tag " + tag + " duplicada");
			return preCreate();
		}
		connector =	dataSourceConnectorService.create(this);
		addActionMessage("Criado com sucesso");
		id = connector.getId();
		return edit();
	}

	@Override
	public String getDataSource() {		
		return dataSource;
	}
	
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
}
