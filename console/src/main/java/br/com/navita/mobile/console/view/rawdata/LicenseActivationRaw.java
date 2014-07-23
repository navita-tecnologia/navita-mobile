package br.com.navita.mobile.console.view.rawdata;

import java.util.Date;

public interface LicenseActivationRaw extends RawData {

	String getBundleId();
	Date getActivationDate();
	String getCarrier();
	String getModel();
	String getEmail();
	String getPin();
	String getBrand();

}
