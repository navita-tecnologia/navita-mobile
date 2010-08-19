package br.com.navita.mobile.console.legacy.processor.sap;

import java.io.Serializable;
import java.util.List;

import br.com.navita.mobile.console.legacy.processor.sap.wrap.SapParameter;
import br.com.navita.mobile.console.legacy.processor.sap.wrap.SapTable;


public class SapExecutionConfig implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String functionName;
	private List<SapParameter> inputParameterList;
	private List<SapParameter> outputParameterList;
	private List<SapTable> inputTableList;
	private List<SapTable> outputTableList;
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	public List<SapParameter> getInputParameterList() {
		return inputParameterList;
	}
	public void setInputParameterList(List<SapParameter> inputParameterList) {
		this.inputParameterList = inputParameterList;
	}
	public List<SapParameter> getOutputParameterList() {
		return outputParameterList;
	}
	public void setOutputParameterList(List<SapParameter> outputParameterList) {
		this.outputParameterList = outputParameterList;
	}
	public List<SapTable> getInputTableList() {
		return inputTableList;
	}
	public void setInputTableList(List<SapTable> inputTableList) {
		this.inputTableList = inputTableList;
	}
	public List<SapTable> getOutputTableList() {
		return outputTableList;
	}
	public void setOutputTableList(List<SapTable> outputTableList) {
		this.outputTableList = outputTableList;
	}
	

}
