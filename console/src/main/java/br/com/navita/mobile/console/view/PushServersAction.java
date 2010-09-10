package br.com.navita.mobile.console.view;

import java.util.List;

import br.com.navita.mobile.console.domain.Application;
import br.com.navita.mobile.console.domain.PushServer;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.service.ApplicationService;
import br.com.navita.mobile.console.service.PushServerService;
import br.com.navita.mobile.console.view.rawdata.PushServerRaw;

public class PushServersAction extends RawActionSupport implements PushServerRaw {
	
	protected PushServerService pushServerService;
	protected ApplicationService applicationService;
	private PushServer pushServer;
	
	private String url;
	private String applicationId;
	private String port;
	private String tag;
	
	
	public void setApplicationService(ApplicationService applicationService) {
		this.applicationService = applicationService;
	}
	
	public void setPushServerService(PushServerService pushServerService) {
		this.pushServerService = pushServerService;
	}
	
	public void setPushServer(PushServer pushServer) {
		this.pushServer = pushServer;
	}
	
	public PushServer getPushServer() {
		return pushServer;
	}
	
	
	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
	
	@Override
	public String getTag() {		
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public List<PushServer> getPushServers(){
		return pushServerService.listbyApplicationId(applicationId);
	}
	
	public Application getApplication() throws EntityNotFoundException{
		return applicationService.findbyId(applicationId);
	}

	public String prepareCreate() {
		pushServer = new PushServer();
		id = pushServer.getId();
		return INPUT;
	}
	
	public String create() throws Exception{
		pushServer = pushServerService.create(this);
		id = pushServer.getId();
		addActionMessage("Criado com sucesso");
		return edit();
	}
	
	public String edit() throws Exception {
		pushServer = pushServerService.findById(id);
		return INPUT;
	}

	public String save() throws Exception{
		pushServer = pushServerService.save(this);
		addActionMessage("Salvo com sucesso");
		return INPUT;
	}
	
	public String delete() throws Exception{
		pushServerService.remove(id);		
		addActionMessage("Removido com sucesso");
		return SUCCESS;
	}
	
}
