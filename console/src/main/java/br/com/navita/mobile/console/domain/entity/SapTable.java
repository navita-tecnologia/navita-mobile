package br.com.navita.mobile.console.domain.entity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class SapTable extends BaseEntity {

	
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<SapRow> sapRows;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<SapTableField> fieldNames;
	
	public SapTable() {
		sapRows = Collections.synchronizedSet( new HashSet<SapRow>() );
		fieldNames = new HashSet<SapTableField>();
	}
	
	public void addRow(SapRow row){
		sapRows.add(row);
	}
	
	public Set<SapRow> getSapRows() {
		return sapRows;
	}

	public void setSapRows(Set<SapRow> sapRows) {
		this.sapRows = sapRows;
	}	
	
	public Set<SapTableField> getFieldNames() {
		return fieldNames;
	}
	
	public void setFieldNames(Set<SapTableField> fieldNames) {
		this.fieldNames = fieldNames;
	}

	public void addField(SapTableField f) {
		fieldNames.add(f);		
	}
	public void removeField(SapTableField f) {
		fieldNames.remove(f);	
	}

	public void removeRow(SapRow row) {
		sapRows.remove(row);
		
	}
	
	
}
