package br.com.navita.mobile.console.view;

import java.util.List;

import br.com.navita.mobile.console.domain.Application;
import br.com.navita.mobile.console.domain.Connector;
import br.com.navita.mobile.console.service.ApplicationService;
import br.com.navita.mobile.console.service.BaseConnectorService;
import br.com.navita.mobile.console.service.PushServerService;
import br.com.navita.mobile.console.view.rawdata.ApplicationRaw;

public class ApplicationsAction extends LicenseWareActionSupport implements ApplicationRaw {
	
	private ApplicationService applicationService;
	protected BaseConnectorService<Connector> baseConnectorService;	
	protected PushServerService pushServerService;
	

	private Application app;
	private boolean enabled;
	private boolean usingAnalytics;
	
	public void setPushServerService(PushServerService pushServerService) {
		this.pushServerService = pushServerService;
	}
	
	public void setBaseConnectorService(
			BaseConnectorService<Connector> baseConnectorService) {
		this.baseConnectorService = baseConnectorService;
	}
		
	public List<Application> getApplications(){
		return applicationService.findAll();
	}
	
	public void setApplicationService(ApplicationService applicationService) {
		this.applicationService = applicationService;
	}
	
	public Application getApp() {
		return app;
	}
	
	public void setApp(Application app) {
		this.app = app;
	}
	
	public String prepareCreate(){
		app = new Application();
		id = app.getId();
		return INPUT;
	}

	public String create() throws Exception{
		app = applicationService.create(this);
		id = app.getId();
		addActionMessage("Criado com sucesso");
		return edit();
	}
	
	public String edit() throws Exception {
		app = applicationService.findbyId(id);
		return INPUT;
	}

	public String save() throws Exception{
		app = applicationService.save(this);
		addActionMessage("Salvo com sucesso");
		return INPUT;
	}
	
	public String delete() throws Exception{
		applicationService.remove(id);		
		addActionMessage("Removido com sucesso");
		return SUCCESS;
	}
	
	
	
	@Override
	public boolean isEnabled() {		
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public Integer getCountConnectors(String id){
		return baseConnectorService.listByApp(id).size();
		
	}
	
	public Integer getCountPushServers(String id){
		return pushServerService.listbyApplicationId(id).size();
	}

	public boolean isUsingAnalytics() {
		return usingAnalytics;
	}

	public void setUsingAnalytics(boolean usingAnalytics) {
		this.usingAnalytics = usingAnalytics;
	}

	
	
	
	
}
