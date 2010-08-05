package br.com.navita.mobile.console.view.rawdata;

public interface ConnectorRaw extends RawData {

	boolean isEnabled();

	String getLicenseBundleId();

	String getLicenseKey();

	String getTag();

	String getAuthContainerId();

	String getTokenConnectorId();

}
