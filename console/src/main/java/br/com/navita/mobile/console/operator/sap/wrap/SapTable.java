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
package br.com.navita.mobile.console.operator.sap.wrap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class SapTable implements Serializable {

	/**
	 * 
	 */
	public SapTable() {
		this.rows = new ArrayList<SapRow>();
	}
	
	
	private static final long serialVersionUID = 1L;
	private String tableName;
	private List<SapRow> rows;
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
