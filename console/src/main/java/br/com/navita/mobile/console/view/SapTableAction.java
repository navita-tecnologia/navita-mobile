package br.com.navita.mobile.console.view;

import br.com.navita.mobile.console.domain.entity.SapTable;



public class SapTableAction extends SapFunctionOperationAction  {

	private SapTable sapTable;
	
	
		

	public SapTable getSapTable() {
		return sapTable;
	}
	
	public void setSapTable(SapTable sapTable) {
		this.sapTable = sapTable;
	}
	
	public String input() throws Exception{		
		sapTable = sapFunctionOperationService.findTableById(sapTableId);
		
		edit();
		return INPUT;
	}
	
	public String save() throws Exception{
		sapFunctionOperationService.saveTable(this);
		return input();
	}

	public String addField() throws Exception{
		sapFunctionOperationService.addSapTableField(this);
		addActionMessage("Campo incluido com sucesso");
		return input();
	}
	
	
}
