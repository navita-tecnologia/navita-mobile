package br.com.navita.mobile.console.domain;

import java.io.Serializable;

public class LicenseBundle implements Serializable{

	private String name;	
	private boolean enabled;
	private int defaultPeriodInDays;
	private int id;
	private long usageNumber;
	private LicenseBundleType licenseBundleType;
	
	public LicenseBundle() {
		
	}
	
	public LicenseBundle(int licenseBundleId) {
		this.id = licenseBundleId;
	}

	public long getUsageNumber() {
		return usageNumber;
	}
	
	public void setUsageNumber(long usageNumber) {
		this.usageNumber = usageNumber;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public int getDefaultPeriodInDays() {
		return defaultPeriodInDays;
	}
	public void setDefaultPeriodInDays(int defaultPeriodInDays) {
		this.defaultPeriodInDays = defaultPeriodInDays;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDefaultPeriodInDaysLabel(){
		if(-1 == defaultPeriodInDays){
			return "Ilimitado";
		}else{
			return defaultPeriodInDays + " dia[s]";
		}
	}
	public LicenseBundleType getLicenseBundleType() {
		return licenseBundleType;
	}
	public void setLicenseBundleType(LicenseBundleType licenseBundleType) {
		this.licenseBundleType = licenseBundleType;
	}
	
	
	
	
}
