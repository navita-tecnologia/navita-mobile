package br.com.navita.mobile.console.service.impl;

import br.com.navita.mobile.console.domain.entity.AuthContainer;
import br.com.navita.mobile.console.domain.entity.Connector;
import br.com.navita.mobile.console.domain.entity.LicenseBundle;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.service.AuthContainerService;
import br.com.navita.mobile.console.service.BaseConnectorService;
import br.com.navita.mobile.console.service.LicenseService;
import br.com.navita.mobile.console.view.rawdata.ConnectorRaw;

public abstract class ConnectorHelper {

	public static void populateConnectorFromRaw(Connector connector, ConnectorRaw raw, 
			LicenseService licenseService,AuthContainerService loginService, 
			BaseConnectorService<Connector> connectorService) throws EntityNotFoundException{
		connector.setEnabled(raw.isEnabled());
		LicenseBundle bundle = licenseService.getBundle(raw.getLicenseBundleId());
		connector.setLicenseBundle(bundle);		
		connector.setLicenseKey(raw.getLicenseKey());
		if(raw.getAuthContainerId() != null){
			AuthContainer authContainer = loginService.findbyId(raw.getAuthContainerId());
			connector.setAuthContainer(authContainer);
		}
		connector.setName(raw.getName());
		connector.setTag(raw.getTag());
		if(raw.getTokenConnectorId() != null){
			Connector tokenConnector = connectorService.findById(raw.getTokenConnectorId());
			connector.setTokenConnector(tokenConnector);
		}

	}

}
