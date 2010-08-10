package br.com.navita.mobile.console.view;

import java.util.Set;

import br.com.navita.mobile.console.domain.entity.SapFunctionOperation;
import br.com.navita.mobile.console.domain.entity.SapParameter;
import br.com.navita.mobile.console.service.OperationService;
import br.com.navita.mobile.console.view.rawdata.SapFunctionOperationRaw;

public class SapFunctionOperationAction extends OperationsAction implements SapFunctionOperationRaw{
	
	private OperationService<SapFunctionOperation, SapFunctionOperationRaw> sapFunctionOperationService;
	
	public void setSapFunctionOperationService(
			OperationService<SapFunctionOperation, SapFunctionOperationRaw> sapFunctionOperationService) {
		this.sapFunctionOperationService = sapFunctionOperationService;
	}

	private Set<SapParameter> inputParameters;
	private String functionName;
	
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

}
