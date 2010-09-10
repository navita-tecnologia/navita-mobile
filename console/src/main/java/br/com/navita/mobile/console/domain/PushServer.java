package br.com.navita.mobile.console.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class PushServer extends BaseEntity {
	
	@Column(nullable=false)
	private String url;
	
	@Column(nullable=false)
	private String port;
	
	@Column(nullable=false,unique=true)
	private String tag;
		
	@ManyToOne
	private Application application;

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

	public void setApplication(Application application) {
		this.application = application;
	}
	
	public Application getApplication() {
		return application;
	}
	
	public String getTag() {
		return tag;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}
	
}
