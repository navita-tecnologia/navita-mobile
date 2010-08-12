package br.com.navita.mobile.console.view;

import br.com.navita.mobile.console.service.SapFunctionOperationService;
import br.com.navita.mobile.console.view.rawdata.SapFunctionOperationRaw;

public class SapFunctionOperationAction extends OperationsAction implements SapFunctionOperationRaw{

	private String paramType;	
	private String functionName;
	private SapFunctionOperationService sapFunctionOperationService;

	private String parameterName;
	private String parameterValue;
	private String sapParameterId;

	private String sapTableName;

	@Override
	public String getSapTableName() {

		return sapTableName;
	}

	public void setSapTableName(String sapTableName) {
		this.sapTableName = sapTableName;
	}

	@Override
	public String getSapParameterId() {		
		return sapParameterId;
	}

	public void setSapParameterId(String sapParameterId) {
		this.sapParameterId = sapParameterId;
	}


	public void setSapFunctionOperationService(
			SapFunctionOperationService sapFunctionOperationService) {
		this.sapFunctionOperationService = sapFunctionOperationService;
	}

	@Override
	public String getParameterName() {		
		return parameterName;
	}
	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	@Override
	public String getParameterValue() {		
		return parameterValue;
	}
	public void setParameterValue(String parameterValue) {
		this.parameterValue = parameterValue;
	}

	@Override
	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
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
		if("input".equals(paramType)){
			sapFunctionOperationService.addInputParameter(this);
		}

		if("output".equals(paramType)){
			sapFunctionOperationService.addOutputParameter(this);
		}

		return edit();
	}

	public String removeParameter() throws Exception{
		if("input".equals(paramType)){
			sapFunctionOperationService.removeInputParameter(this);
		}
		if("output".equals(paramType)){
			sapFunctionOperationService.removeOutputParameter(this);
		}
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

}
