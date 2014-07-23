package br.com.navita.mobile.console.view;

import java.util.Date;

import org.apache.struts2.dispatcher.DefaultActionSupport;

import br.com.navita.mobile.console.util.LicenseHelper;
import br.com.navita.mobile.console.view.rawdata.LicenseActivationRaw;
import br.com.navita.mobile.console.view.rawdata.ProcessorRaw;

public class LicenseGatewayAction extends DefaultActionSupport implements LicenseActivationRaw, ProcessorRaw{
	private LicenseHelper licenseHelper;
	
	private String licenseBundleId;
	private String brand;
	private String carrier;
	private String device;
	private String email;
	private String pin;
	
	public void setLicenseHelper(LicenseHelper licenseHelper) {
		this.licenseHelper = licenseHelper;
	}
	
	
	@Override
	public String execute() throws Exception {
		licenseHelper.registerLicense(licenseBundleId, this);
		return SUCCESS;
	}


	public String getLicenseBundleId() {
		return licenseBundleId;
	}


	public void setLicenseBundleId(String licenseBundleId) {
		this.licenseBundleId = licenseBundleId;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getCarrier() {
		return carrier;
	}


	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}


	public String getDevice() {
		return device;
	}


	public void setDevice(String device) {
		this.device = device;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPin() {
		return pin;
	}


	public void setPin(String pin) {
		this.pin = pin;
	}


	@Override
	public Date getActivationDate() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getBundleId() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getModel() {
		
		return device;
	}
	public void setModel(String model) {		
		this.device = model;
	}
	


	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getConnectorTag() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getLogin() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getOperationTag() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getPasswd() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getRaw() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getUser() {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}
