package br.com.navita.mobile.console.domain.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class SapTable extends BaseEntity {

	@Column
	private String tableName;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<SapRow> sapRows;
	
	public SapTable() {
		sapRows = new HashSet<SapRow>();
	}
	
	public void addRow(SapRow row){
		sapRows.add(row);
	}
	
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Set<SapRow> getSapRows() {
		return sapRows;
	}

	public void setSapRows(Set<SapRow> sapRows) {
		this.sapRows = sapRows;
	}	
	
	
	
}
