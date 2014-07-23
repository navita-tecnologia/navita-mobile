package br.com.navita.mobile.console.view;

import org.apache.struts2.dispatcher.DefaultActionSupport;

import br.com.navita.mobile.console.view.rawdata.RawData;

/**
 * 
 * @author mpguedes
 *
 */
public abstract class RawActionSupport extends DefaultActionSupport implements	RawData {
	
	

	protected String id;
	protected String name;
	
	@Override
	public String getId() {
		
		return id;
	}

	@Override
	public String getName() {
		
		return name;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	

}
