package br.com.navita.mobile.console.domain.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class SapConnector extends Connector {

	
	private String router;
	
	@Column(nullable = false)
	private String ip;
	
	@Column(nullable = false)
	private String sysnr;
	
	@Column(nullable = false)
	private String client;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="sapConnector")
	private Set<SapFunctionOperation> sapFunctionOperations;

	public String getRouter() {
		return router;
	}

	public void setRouter(String router) {
		this.router = router;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getSysnr() {
		return sysnr;
	}

	public void setSysnr(String sysnr) {
		this.sysnr = sysnr;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public void setSapFunctionOperations(
			Set<SapFunctionOperation> sapFunctionOperations) {
		this.sapFunctionOperations = sapFunctionOperations;
	}
	
	public Set<SapFunctionOperation> getSapFunctionOperations() {
		return sapFunctionOperations;
	}

	@Override
	public Class<? extends Operation> getOperationType() {
		
		return SapFunctionOperation.class;
	}
	
	
	
}
