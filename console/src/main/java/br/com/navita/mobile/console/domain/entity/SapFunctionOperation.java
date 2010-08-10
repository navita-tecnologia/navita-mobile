package br.com.navita.mobile.console.domain.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class SapFunctionOperation extends Operation {
	
	@Column
	private String functionName;
	
	@JoinTable(name="SapFunctionOperation_SapInputParameter")
	@OneToMany
	private Set<SapParameter> inputParameters;
	
	@JoinTable(name="SapFunctionOperation_SapOutputParameter")
	@OneToMany
	private Set<SapParameter>outputParameters;
	
	@JoinTable(name="SapFunctionOperation_SapInputTable")
	@OneToMany
	private Set<SapTable> inputTables;
	
	@JoinTable(name="SapFunctionOperation_SapOutputTable")
	@OneToMany
	private Set<SapTable> outputTables;
	
		

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
	
	

}
