package br.com.navita.mobile.console.processor.sap.wrap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class SapTable implements Serializable {

		
	private static final long serialVersionUID = 1L;
	private String tableName;
	private List<SapRow> rows = new ArrayList<SapRow>();
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public List<SapRow> getRows() {
		return rows;
	}
	
	public void setRows(List<SapRow> rows) {
		this.rows = rows;
	}
	
	public void add(SapRow row) {
		this.rows.add(row);		
	}
	
	
	
	
	

}
