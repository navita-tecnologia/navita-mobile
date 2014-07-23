/*
 * Copyright 2014 Navita Tecnologia.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.navita.mobile.console.domain;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
public class SapTable extends BaseEntity {

	
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<SapRow> sapRows;
	
	@OneToMany(cascade = CascadeType.ALL)
	@OrderBy("name")
	private Set<SapTableField> fieldNames;
	
	public SapTable() {
		sapRows =  new TreeSet<SapRow>() ;
		fieldNames = new TreeSet<SapTableField>();
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
