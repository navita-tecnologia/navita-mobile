package br.com.navita.mobile.console.view.rawdata;

public interface SapConnectorRaw extends ConnectorRaw{

	String getSysnr();
	String getClient();
	String getRouter();
	String getAsHost();
	String getLang();
}
