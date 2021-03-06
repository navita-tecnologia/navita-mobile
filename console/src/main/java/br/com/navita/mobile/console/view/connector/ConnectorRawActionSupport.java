/*
 * Copyright 2014 Navita Tecnologia.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.navita.mobile.console.view.connector;

import br.com.navita.mobile.console.domain.Connector;
import br.com.navita.mobile.console.domain.Operation;
import br.com.navita.mobile.console.service.ApplicationService;
import br.com.navita.mobile.console.service.AuthContainerService;
import br.com.navita.mobile.console.service.BaseConnectorService;
import br.com.navita.mobile.console.service.BaseOperationService;
import br.com.navita.mobile.console.view.LicenseWareActionSupport;
import br.com.navita.mobile.console.view.rawdata.ConnectorRaw;

public abstract class ConnectorRawActionSupport extends LicenseWareActionSupport implements ConnectorRaw{
	
	protected BaseConnectorService<Connector> baseConnectorService;	
	protected BaseOperationService<Operation> baseOperationService;
	protected AuthContainerService authContainerService;
	protected ApplicationService applicationService;
	
	protected String authContainerId;
	protected String applicationId;
	protected String tag;
	protected String tokenConnectorId;
	protected boolean enabled;
	protected Connector connector;
	
	
	public String getApplicationId() {
		return applicationId;
	}
	
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	
	public void setApplicationService(ApplicationService applicationService) {
		this.applicationService = applicationService;
	}
	
	public void setAuthContainerService(
			AuthContainerService authContainerService) {
		this.authContainerService = authContainerService;
	}
	
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
	
	
}
