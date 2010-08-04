package br.com.navita.mobile.console.domain.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class SapTable extends BaseEntity {

	@Column
	private String tableName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="sapTable")
	private Set<SapRow> sapRows;
	
	@OneToOne
	private SapFunctionOperation sapFunctionOperation;

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

	public SapFunctionOperation getSapFunctionOperation() {
		return sapFunctionOperation;
	}

	public void setSapFunctionOperation(SapFunctionOperation sapFunctionOperation) {
		this.sapFunctionOperation = sapFunctionOperation;
	}
	
	
	
	
	
}
