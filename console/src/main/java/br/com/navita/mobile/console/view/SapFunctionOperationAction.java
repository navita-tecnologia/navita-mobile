package br.com.navita.mobile.console.view;

import java.util.Set;

import br.com.navita.mobile.console.domain.entity.SapFunctionOperation;
import br.com.navita.mobile.console.domain.entity.SapParameter;
import br.com.navita.mobile.console.service.OperationService;
import br.com.navita.mobile.console.view.rawdata.SapFunctionOperationRaw;

public class SapFunctionOperationAction extends OperationsAction implements SapFunctionOperationRaw{
	
	private String paramType;
	private Set<SapParameter> inputParameters;
	private String functionName;

	
	private OperationService<SapFunctionOperation, SapFunctionOperationRaw> sapFunctionOperationService;
	
	public void setSapFunctionOperationService(
			OperationService<SapFunctionOperation, SapFunctionOperationRaw> sapFunctionOperationService) {
		this.sapFunctionOperationService = sapFunctionOperationService;
	}
		
	@Override
	public String getFunctionName() {
		return functionName;
	}
	
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	@Override
	public Set<SapParameter> getInputParameters() {		
		return inputParameters;
	}
	
	public void setInputParameters(Set<SapParameter> inputParameters) {
		this.inputParameters = inputParameters;
	}
	
	
	public String getParamType() {
		return paramType;
	}
	
	public void setParamType(String paramType) {
		this.paramType = paramType;
	}
	
	public String save() throws Exception {
		sapFunctionOperationService.update(this);
		addActionMessage("Salvo com sucesso");
		return edit();
	}
	public String create() throws Exception {
		operation = sapFunctionOperationService.create(this);
		id = operation.getId();
		addActionMessage("Criado com sucesso");
		return edit();
	}
	
	
	//input parameter

	public String addParameter() throws Exception{
		
		
		return edit();
	}
	
	public String removeParameter() throws Exception{
		
		return edit();
	}
	
	public String saveParameter() throws Exception{
		
		return edit();
	}

	//input table
	public String addTable() throws Exception{
		
		return edit();
	}
	
	public String removeTable() throws Exception{
		
		return edit();
	}
	
	public String saveTable() throws Exception{
		
		return edit();
	}
	
	//table data
	public String addTableAttribute() throws Exception{
		
		return edit();
	}
	
	public String removeAttribute() throws Exception{
		
		return edit();
	}
	
	public String saveAttribute() throws Exception{
		
		return edit();
	}
	

}
