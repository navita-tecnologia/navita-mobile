package br.com.navita.mobile.console.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class SapParameter extends BaseEntity {

	@Column
	private String parameterName;
	
	@Column
	private String parameterValue;
	
	@OneToOne
	private SapRow sapRow;
	
	@OneToOne
	private SapFunctionOperation sapFunctionOperation;

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getParameterValue() {
		return parameterValue;
	}

	public void setParameterValue(String parameterValue) {
		this.parameterValue = parameterValue;
	}

	public SapRow getSapRow() {
		return sapRow;
	}

	public void setSapRow(SapRow sapRow) {
		this.sapRow = sapRow;
	}

	public SapFunctionOperation getSapFunctionOperation() {
		return sapFunctionOperation;
	}

	public void setSapFunctionOperation(SapFunctionOperation sapFunctionOperation) {
		this.sapFunctionOperation = sapFunctionOperation;
	}
	
	
	
}
