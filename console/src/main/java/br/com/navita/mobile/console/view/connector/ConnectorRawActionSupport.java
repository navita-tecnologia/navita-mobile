package br.com.navita.mobile.console.view.connector;

import java.util.List;

import br.com.navita.mobile.console.domain.entity.Connector;
import br.com.navita.mobile.console.domain.entity.LicenseBundle;
import br.com.navita.mobile.console.domain.entity.Operation;
import br.com.navita.mobile.console.service.AuthContainerService;
import br.com.navita.mobile.console.service.BaseConnectorService;
import br.com.navita.mobile.console.service.BaseOperationService;
import br.com.navita.mobile.console.service.LicenseService;
import br.com.navita.mobile.console.view.RawActionSupport;
import br.com.navita.mobile.console.view.rawdata.ConnectorRaw;

public abstract class ConnectorRawActionSupport extends RawActionSupport implements ConnectorRaw{
	
	protected BaseConnectorService<Connector> baseConnectorService;
	protected LicenseService licenseService;
	protected BaseOperationService<Operation> baseOperationService;
	protected AuthContainerService authContainerService;
	
	public void setAuthContainerService(
			AuthContainerService authContainerService) {
		this.authContainerService = authContainerService;
	}
	
	
	
	protected String authContainerId;
	protected String licenseBundleId;
	protected String licenseKey;
	protected String tag;
	protected String tokenConnectorId;
	protected boolean enabled;
	
	protected Connector connector;
	
	public void setBaseOperationService(
			BaseOperationService<Operation> baseOperationService) {
		this.baseOperationService = baseOperationService;
	}
	
	public Connector getConnector() {
		return connector;
	}
	
	public void setConnector(Connector connector) {
		this.connector = connector;
	}

	@Override
	public String getAuthContainerId() {
		
		return authContainerId;
	}

	@Override
	public String getLicenseBundleId() {
		
		return licenseBundleId;
	}

	@Override
	public String getLicenseKey() {		
		return licenseKey;
	}

	@Override
	public String getTag() {
		
		return tag;
	}

	@Override
	public String getTokenConnectorId() {
		
		return tokenConnectorId;
	}

	@Override
	public boolean isEnabled() {
		
		return enabled;
	}
	

	
	public void setAuthContainerId(String authContainerId) {
		this.authContainerId = authContainerId;
	}

	public void setLicenseBundleId(String licenseBundleId) {
		this.licenseBundleId = licenseBundleId;
	}

	public void setLicenseKey(String licenseKey) {
		this.licenseKey = licenseKey;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public void setTokenConnectorId(String tokenConnectorId) {
		this.tokenConnectorId = tokenConnectorId;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setBaseConnectorService(
			BaseConnectorService<Connector> baseConnectorService) {
		this.baseConnectorService = baseConnectorService;
	}
	
	public void setLicenseService(LicenseService licenseService) {
		this.licenseService = licenseService;
	}
	
	public List<LicenseBundle> getLicenseBundles(){
		return licenseService.listBundle();
	}
}
