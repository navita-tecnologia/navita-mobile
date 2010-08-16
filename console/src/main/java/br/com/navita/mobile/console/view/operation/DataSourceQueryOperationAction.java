package br.com.navita.mobile.console.view.operation;

import br.com.navita.mobile.console.domain.entity.DataSourceQueryOperation;
import br.com.navita.mobile.console.service.OperationService;
import br.com.navita.mobile.console.view.rawdata.DataSourceQueryOperationRaw;

public class DataSourceQueryOperationAction extends OperationsAction implements DataSourceQueryOperationRaw {
	
	private OperationService<DataSourceQueryOperation, DataSourceQueryOperationRaw> dataSourceQueryOperationService;
	
	public void setDataSourceQueryOperationService(
			OperationService<DataSourceQueryOperation, DataSourceQueryOperationRaw> dataSourceQueryOperationService) {
		this.dataSourceQueryOperationService = dataSourceQueryOperationService;
	}

	private String query;
	
	public String getQuery() {
		return query;
	}
	
	public void setQuery(String query) {
		this.query = query;
	}
	
	public String save() throws Exception {
		if(! baseOperationService.isTagUniqueForIdAndConnector(tag, id, connectorId)){
			addActionError("Tag " + tag + " existe em outra operação deste mesmo conector");
			return edit();
		}
		dataSourceQueryOperationService.update(this);
		addActionMessage("Salvo com sucesso");
		return edit();
	}
	public String create() throws Exception {
		if(! baseOperationService.isTagUniqueForConnector(tag, connectorId)){
			addActionError("Tag " + tag + " existe em outra operação deste mesmo conector");
			return prepareCreate();
		}
		operation = dataSourceQueryOperationService.create(this);
		id = operation.getId();
		addActionMessage("Criado com sucesso");
		return edit();
	}
	
	
}
