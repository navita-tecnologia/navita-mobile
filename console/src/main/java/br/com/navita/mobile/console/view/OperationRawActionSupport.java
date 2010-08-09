package br.com.navita.mobile.console.view;

import br.com.navita.mobile.console.domain.entity.Operation;
import br.com.navita.mobile.console.service.OperationService;
import br.com.navita.mobile.console.view.rawdata.OperationRaw;

public abstract class OperationRawActionSupport extends RawActionSupport implements OperationRaw {
	
	protected String connectorId;
	protected String licenseBundleId;
	protected String licenseKey;
	protected String tag;
	
	protected OperationService<Operation, OperationRaw> operationService;
	
	
	
	public String getConnectorId() {
		return connectorId;
	}
	public void setConnectorId(String connectorId) {
		this.connectorId = connectorId;
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
