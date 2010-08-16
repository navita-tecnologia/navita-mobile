package br.com.navita.mobile.console.view.connector;

import br.com.navita.mobile.console.domain.entity.SapConnector;
import br.com.navita.mobile.console.service.ConnectorService;
import br.com.navita.mobile.console.view.rawdata.SapConnectorRaw;

public class SapConnectorAction extends ConnectorsAction implements SapConnectorRaw{
	private ConnectorService<SapConnector,SapConnectorRaw> sapConnectorService;
	
	private String ip;
	private String sysnr;
	private String client;
	private String router;
	
	public void setSapConnectorService(
			ConnectorService<SapConnector, SapConnectorRaw> sapConnectorService) {
		this.sapConnectorService = sapConnectorService;
	}
	
	@Override
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	@Override
	public String getSysnr() {
		return sysnr;
	}
	public void setSysnr(String sysnr) {
		this.sysnr = sysnr;
	}
	
	@Override
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	
	@Override
	public String getRouter() {
		return router;
	}
	public void setRouter(String router) {
		this.router = router;
	}
	
	public String save() throws Exception{	
		if(! baseConnectorService.isTagUniqueForId(tag, id)){
			addActionError("Tag " + tag + " duplicada");
			return edit();
		}
		sapConnectorService.update(this);
		addActionMessage("Salvo com sucesso");
		return edit();
	}

	public String create() throws Exception{		
		if(! baseConnectorService.isTagUnique(tag)){
			addActionError("Tag " + tag + " duplicada");
			return preCreate();
		}
		connector =	sapConnectorService.create(this);
		addActionMessage("Criado com sucesso");
		id = connector.getId();
		return edit();
	}
	
	
}
