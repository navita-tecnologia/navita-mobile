package br.com.navita.mobile.console.view.rawdata;

public interface ConnectorRaw extends LicenseWare {

	boolean isEnabled();	

	String getTag();

	String getAuthContainerId();

	String getTokenConnectorId();
	
	String getApplicationId();

}
