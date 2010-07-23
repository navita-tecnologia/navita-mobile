package br.com.navita.mobile.console.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author mpguedes
 *
 */
public class MobileApplication implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private boolean enabled;
	private boolean usingNativeLoginService;
	private String loginServiceId;
	private String tokenGeneratorUrl;	
	private Map<String,Object> extendedProperty;
	private List<MobileApplicationExecutor> executors;
	private int licenseBundleId;
	private String licenseActivationKey;
	
	
	public MobileApplicationExecutor getExecutorByName(String execName){
		if(executors == null){
			return null;
		}
		for(MobileApplicationExecutor executor:executors){
			if(executor.getName().equals(execName)){
				return executor;
			}
		}
		return null;
	}
	
	
	
	public int getLicenseBundleId() {
		return licenseBundleId;
	}



	public void setLicenseBundleId(int licenseBundleId) {
		this.licenseBundleId = licenseBundleId;
	}



	public String getLicenseActivationKey() {
		return licenseActivationKey;
	}



	public void setLicenseActivationKey(String licenseActivationKey) {
		this.licenseActivationKey = licenseActivationKey;
	}



	public List<MobileApplicationExecutor> getExecutors() {
		return executors;
	}
	public void setExecutors(List<MobileApplicationExecutor> executors) {
		this.executors = executors;
	}
	
	public boolean isUsingNativeLoginService() {
		return usingNativeLoginService;
	}
	public void setUsingNativeLoginService(boolean usingNativeLoginService) {
		this.usingNativeLoginService = usingNativeLoginService;
	}
	public Map<String, Object> getExtendedProperty() {
		return extendedProperty;
	}
	public void setExtendedProperty(Map<String, Object> extendedProperty) {
		this.extendedProperty = extendedProperty;
	}
	
	
	
	public String getLoginServiceId() {
		return loginServiceId;
	}
	public void setLoginServiceId(String loginServiceId) {
		this.loginServiceId = loginServiceId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	private String url;
		
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	

	public String getTokenGeneratorUrl() {
		return tokenGeneratorUrl;
	}

	public void setTokenGeneratorUrl(String tokenGeneratorUrl) {
		this.tokenGeneratorUrl = tokenGeneratorUrl;
	}
	
	
}
