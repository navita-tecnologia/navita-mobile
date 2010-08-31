package br.com.navita.mobile.console.view.rawdata;



public interface AdAuthContainerRaw extends RawData{

	String getDomainUser();
	
	String getDomainUserPassword();
	
	String getDomainName();
	
	boolean isDnsResolving();
	
	String getIp();
	
	String getUrl();
	
	String getSearchBase();
	
	String getSearchFilter();
	
	String getGroupAttribute();
	
	String getGroupFilter();
}
