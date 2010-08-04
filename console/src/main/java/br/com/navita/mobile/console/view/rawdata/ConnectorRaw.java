package br.com.navita.mobile.console.view.rawdata;

public interface ConnectorRaw extends RawData {

	boolean isEnabled();

	String getLicenceBundleId();

	String getLicenseKey();

	String getTag();

	String getAuthContainerId();

	String getTokenConnectorId();

}
