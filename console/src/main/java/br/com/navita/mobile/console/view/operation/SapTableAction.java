package br.com.navita.mobile.console.view.operation;

import java.util.ArrayList;
import java.util.List;

import br.com.navita.mobile.console.domain.entity.SapTable;
import br.com.navita.mobile.console.view.rawdata.SapFieldRaw;



public class SapTableAction extends SapFunctionOperationAction  {

	private SapTable sapTable;
	private String rowData;
	
	public String getRowData() {
		return rowData;
	}
	
	public void setRowData(String rowData) {
		this.rowData = rowData;
		setSapRowRaw(parseRowData(this.rowData));
	}
	
	private List<SapFieldRaw> parseRowData(String rowData) {
		List<SapFieldRaw> ret = new ArrayList<SapFieldRaw>();
		String[] pairs = rowData.split("\\|");
		for(String pair : pairs){
			final String[] tk = pair.split(":");
			SapFieldRaw raw = new SapFieldRaw() {
				
				@Override
				public String getName() {
					return tk[0];
				}
				
				@Override
				public String getId() {
					return "";
				}

				@Override
				public String getFieldValue() {
					
					return tk[1];
				}
			};
			ret.add(raw);
		}
		
		return ret;
	}

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
	public String removeField() throws Exception{
		sapFunctionOperationService.removeSapTableField(this);
		addActionMessage("Campo excluido com sucesso");
		return input();
	}
	
	public String addRow() throws Exception{		
		sapFunctionOperationService.addTableRow(this);
		addActionMessage("Linha inserida com sucesso");
		return input();
	}
	public String removeRow() throws Exception{		
		sapFunctionOperationService.removeTableRow(this);
		addActionMessage("Linha removida com sucesso");
		return input();
	}
	
}
