package br.com.navita.mobile.console.view.operation;

import java.util.List;

import br.com.navita.mobile.console.service.SapFunctionOperationService;
import br.com.navita.mobile.console.view.rawdata.SapFieldRaw;
import br.com.navita.mobile.console.view.rawdata.SapFunctionOperationRaw;

public class SapFunctionOperationAction extends OperationsAction implements SapFunctionOperationRaw{

	protected String paramType;	
	protected String functionName;
	protected SapFunctionOperationService sapFunctionOperationService;

	protected String parameterName;
	protected String parameterValue;
	protected String sapParameterId;

	protected String sapTableName;
	protected String sapTableId;
	protected String sapTableFieldName;
	protected String sapTableFieldId;
	protected List<SapFieldRaw> sapRowRaw;
	protected String sapRowId;
	
	@Override
	public String getSapRowId() {		
		return sapRowId;
	}
	
	public void setSapRowId(String sapRowId) {
		this.sapRowId = sapRowId;
	}
	
	public List<SapFieldRaw> getSapRowRaw() {
		return sapRowRaw;
	}
	
	public void setSapRowRaw(List<SapFieldRaw> sapRowRaw) {
		this.sapRowRaw = sapRowRaw;
	}
		

	
	@Override
	public String getSapTabelFieldName() {		
		return sapTableFieldName;
	}
	
	public void setSapTableFieldName(String sapTableFieldName) {
		this.sapTableFieldName = sapTableFieldName;
	}
	
	public String getSapTableFieldId() {
		return sapTableFieldId;
	}
	
	public void setSapTableFieldId(String sapTableFieldId) {
		this.sapTableFieldId = sapTableFieldId;
	}
	
	@Override
	public String getSapTableId() {		
		return sapTableId;
	}
	
	public void setSapTableId(String sapTableId) {
		this.sapTableId = sapTableId;
	}

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
		if(! baseOperationService.isTagUniqueForIdAndConnector(tag, id, connectorId)){
			addActionError("Tag " + tag + " existe em outra operação deste mesmo conector");
			return edit();
		}
		sapFunctionOperationService.update(this);
		addActionMessage("Salvo com sucesso");
		return edit();
	}
	public String create() throws Exception {
		if(! baseOperationService.isTagUniqueForConnector(tag, connectorId)){
			addActionError("Tag " + tag + " existe em outra operação deste mesmo conector");
			return prepareCreate();
		}
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
		addActionMessage("Criado com sucesso");
		return edit();
	}

	public String removeParameter() throws Exception{
		if("input".equals(paramType)){
			sapFunctionOperationService.removeInputParameter(this);
		}
		if("output".equals(paramType)){
			sapFunctionOperationService.removeOutputParameter(this);
		}
		addActionMessage("Removido com sucesso");
		return edit();
	}

	
	//input table
	public String addTable() throws Exception{
		if("input".equals(paramType)){
			sapFunctionOperationService.addInputTable(this);
		}

		if("output".equals(paramType)){
			sapFunctionOperationService.addOutputTable(this);
		}
		return edit();
	}

	public String removeTable() throws Exception{

		if("input".equals(paramType)){
			sapFunctionOperationService.removeInputTable(this);
		}
		if("output".equals(paramType)){
			sapFunctionOperationService.removeOutputTable(this);
		}
		addActionMessage("Removido com sucesso");
		return edit();
	}

	public String saveTable() throws Exception{

		return edit();
	}

	

}
