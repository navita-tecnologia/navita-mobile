package br.com.navita.mobile.console.view.operation;

import br.com.navita.mobile.console.domain.Connector;
import br.com.navita.mobile.console.domain.Operation;
import br.com.navita.mobile.console.service.BaseConnectorService;
import br.com.navita.mobile.console.service.BaseOperationService;
import br.com.navita.mobile.console.service.OperationService;
import br.com.navita.mobile.console.view.LicenseWareActionSupport;
import br.com.navita.mobile.console.view.rawdata.OperationRaw;

public abstract class OperationRawActionSupport extends LicenseWareActionSupport implements OperationRaw {
	
	protected String connectorId;
	protected String licenseBundleId;
	protected String licenseKey;
	protected String tag;
	
	protected OperationService<Operation, OperationRaw> operationService;
	protected BaseOperationService<Operation> baseOperationService;	
	protected BaseConnectorService<Connector> baseConnectorService;
	
	public void setBaseConnectorService(
			BaseConnectorService<Connector> baseConnectorService) {
		this.baseConnectorService = baseConnectorService;
	}
	
	public void setBaseOperationService(
			BaseOperationService<Operation> baseOperationService) {
		this.baseOperationService = baseOperationService;
	}
	
	public String getConnectorId() {
		return connectorId;
	}
	public void setConnectorId(String connectorId) {
		this.connectorId = connectorId;
	}
		
	@Override
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
		

}
