package br.com.navita.mobile.console.view.operation;

import java.util.List;

import br.com.navita.mobile.console.domain.Connector;
import br.com.navita.mobile.console.domain.LicenseBundle;
import br.com.navita.mobile.console.domain.Operation;
import br.com.navita.mobile.console.service.BaseConnectorService;
import br.com.navita.mobile.console.service.BaseOperationService;
import br.com.navita.mobile.console.service.LicenseService;
import br.com.navita.mobile.console.service.OperationService;
import br.com.navita.mobile.console.view.RawActionSupport;
import br.com.navita.mobile.console.view.rawdata.OperationRaw;

public abstract class OperationRawActionSupport extends RawActionSupport implements OperationRaw {
	
	protected String connectorId;
	protected String licenseBundleId;
	protected String licenseKey;
	protected String tag;
	
	protected OperationService<Operation, OperationRaw> operationService;
	protected BaseOperationService<Operation> baseOperationService;
	protected LicenseService licenseService;
	protected BaseConnectorService<Connector> baseConnectorService;
	
	public void setBaseConnectorService(
			BaseConnectorService<Connector> baseConnectorService) {
		this.baseConnectorService = baseConnectorService;
	}
	
	public void setBaseOperationService(
			BaseOperationService<Operation> baseOperationService) {
		this.baseOperationService = baseOperationService;
	}
	
	public void setLicenseService(LicenseService licenseService) {
		this.licenseService = licenseService;
	}
	
	
	public String getConnectorId() {
		return connectorId;
	}
	public void setConnectorId(String connectorId) {
		this.connectorId = connectorId;
	}
	
	public List<LicenseBundle> getLicenseBundles(){
		return licenseService.listBundle();
	}
	
	@Override
	public String getLicenseBundleId() {
		return licenseBundleId;
	}	
	public void setLicenseBundleId(String licenseBundleId) {
		this.licenseBundleId = licenseBundleId;
	}
	
	@Override
	public String getLicenseKey() {
		return licenseKey;
	}
	public void setLicenseKey(String licenseKey) {
		this.licenseKey = licenseKey;
	}
	
	@Override
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
		

}
