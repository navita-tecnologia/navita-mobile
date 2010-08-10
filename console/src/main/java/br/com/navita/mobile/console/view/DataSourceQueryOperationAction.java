package br.com.navita.mobile.console.view;

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
		dataSourceQueryOperationService.update(this);
		addActionMessage("Salvo com sucesso");
		return edit();
	}
	public String create() throws Exception {
		operation = dataSourceQueryOperationService.create(this);
		id = operation.getId();
		addActionMessage("Criado com sucesso");
		return edit();
	}
	
	
}
