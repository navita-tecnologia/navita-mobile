package br.com.navita.mobile.console.view.rawdata;

public interface ProcessorRaw extends RawData{
	
	String getConnectorTag();
	String getOperationTag();
	String getRaw();
	
	String getPin();
	String getEmail();
	String getCarrier();
	String getDevice();
	String getBrand();
	
	String getLogin();
	String getUser();
	String getPassword();
	String getPasswd();

}
