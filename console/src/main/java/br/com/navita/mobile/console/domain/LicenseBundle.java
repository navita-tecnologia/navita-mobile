package br.com.navita.mobile.console.domain;

import java.io.Serializable;

public class LicenseBundle implements Serializable{

	private String name;
	private int typeId;
	private boolean enabled;
	private int defaultPeriodInDays;
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
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
	
	
}
