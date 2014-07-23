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

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class SapFunctionOperation extends Operation {
	
	@Column
	private String functionName;
	
	@JoinTable(name="SapFunctionOperation_SapInputParameter")
	@OneToMany(cascade = CascadeType.ALL)
	private Set<SapParameter> inputParameters;
	
	@JoinTable(name="SapFunctionOperation_SapOutputParameter")
	@OneToMany(cascade = CascadeType.ALL)
	private Set<SapParameter>outputParameters;
	
	@JoinTable(name="SapFunctionOperation_SapInputTable")
	@OneToMany(cascade = CascadeType.ALL)
	private Set<SapTable> inputTables;
	
	@JoinTable(name="SapFunctionOperation_SapOutputTable")
	@OneToMany(cascade = CascadeType.ALL)
	private Set<SapTable> outputTables;
	
	
	public SapFunctionOperation() {
		inputParameters = new HashSet<SapParameter>();
		outputParameters = new HashSet<SapParameter>();
		inputTables = new HashSet<SapTable>();
		outputTables = new HashSet<SapTable>();
	}
		

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public Set<SapParameter> getInputParameters() {
		return inputParameters;
	}

	public void setInputParameters(Set<SapParameter> inputParameters) {
		this.inputParameters = inputParameters;
	}

	public Set<SapParameter> getOutputParameters() {
		return outputParameters;
	}

	public void setOutputParameters(Set<SapParameter> outputParameters) {
		this.outputParameters = outputParameters;
	}

	public Set<SapTable> getInputTables() {
		return inputTables;
	}

	public void setInputTables(Set<SapTable> inputTables) {
		this.inputTables = inputTables;
	}

	public Set<SapTable> getOutputTables() {
		return outputTables;
	}

	public void setOutputTables(Set<SapTable> outputTables) {
		this.outputTables = outputTables;
	}
	
	public void addInputParameter(SapParameter inputParameter){
		inputParameters.add(inputParameter);
	}
	public void addOutputParameter(SapParameter outputParameter){
		outputParameters.add(outputParameter);
	}
	
	public void addInputTable(SapTable inputTable){
		inputTables.add(inputTable);
	}
	public void addOutputTable(SapTable outputTable){
		outputTables.add(outputTable);
	}


	public void removeInputParameter(SapParameter parameter) {	
		inputParameters.remove(parameter);
		
	}
	public void removeOutputParameter(SapParameter parameter) {		
		outputParameters.remove(parameter);
	}


	public void removeOutputTable(SapTable table) {
		outputTables.remove(table);		
	}


	public void removeInputTable(SapTable table) {		
		inputTables.remove(table);		
	}
	
	
}
