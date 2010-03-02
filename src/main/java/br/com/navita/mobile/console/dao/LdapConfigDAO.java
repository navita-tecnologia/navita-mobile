package br.com.navita.mobile.console.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.apache.commons.configuration.AbstractConfiguration;
import org.apache.commons.configuration.Configuration;

import br.com.navita.mobile.console.domain.LdapConfig;
import br.com.navita.mobile.console.util.Encryptor;
import br.com.navita.mobile.exception.NavitaMobileError;


public class LdapConfigDAO {
	private AbstractConfiguration commonConfiguration;

	public void setCommonConfiguration(AbstractConfiguration commonConfiguration) {
		this.commonConfiguration = commonConfiguration;		
	}
	private static final String KEY = "RrSe916DqrdQANfFKaQkgQ==";

	public void saveService(LdapConfig properties ,String seedId) throws NavitaMobileError{
		String id = seedId;
		if(id == null){
			id = UUID.randomUUID().toString();
		}
		commonConfiguration.setProperty(LdapConfig.ID_PREFIX + id, id);
		commonConfiguration.setProperty(LdapConfig.NAME_PREFIX + id, properties.getName());
		commonConfiguration.setProperty(LdapConfig.DOMAIN_NAME_PREFIX + id, properties.getDomainName());
		commonConfiguration.setProperty(LdapConfig.DOMAIN_CONTROLLER_IP_PREFIX + id, properties.getIp());
		commonConfiguration.setProperty(LdapConfig.DOMAIN_CONTROLLER_IP_AUTO_PREFIX + id, properties.isAutoIp());
		commonConfiguration.setProperty(LdapConfig.GROUP_ATTRIBUTE_PREFIX + id, properties.getGroupAttribute());
		if(properties.getPassword()!=null && ! properties.getPassword().isEmpty()){
			String password = null;
			try {
				password = Encryptor.encrypt(properties.getPassword(), KEY);
				commonConfiguration.setProperty(LdapConfig.PASSWORD_PREFIX + id, password);
			} catch (Exception e) {
				throw new NavitaMobileError(e);
			}
		}

		commonConfiguration.setProperty(LdapConfig.SEARCH_BASE_PREFIX + id, properties.getSearchBase());
		commonConfiguration.setProperty(LdapConfig.SEARCH_FILTER_PREFIX + id, properties.getSearchFilter());
		commonConfiguration.setProperty(LdapConfig.SERVICE_URL_PREFIX + id, properties.getUrl());
		commonConfiguration.setProperty(LdapConfig.USER_PREFIX + id, properties.getUser());
	}

	public LdapConfig getServiceProperties(String id){
		if(null == commonConfiguration.getString(LdapConfig.ID_PREFIX + id)){
			return null;
		}
		LdapConfig p = new LdapConfig();		
		p.setIp(commonConfiguration.getString(LdapConfig.DOMAIN_CONTROLLER_IP_PREFIX + id));
		p.setGroupAttribute(commonConfiguration.getString(LdapConfig.GROUP_ATTRIBUTE_PREFIX + id));
		p.setName(commonConfiguration.getString(LdapConfig.NAME_PREFIX + id));
		p.setDomainName(commonConfiguration.getString(LdapConfig.DOMAIN_NAME_PREFIX + id));
		p.setPassword(commonConfiguration.getString(LdapConfig.PASSWORD_PREFIX + id));
		p.setSearchBase(commonConfiguration.getString(LdapConfig.SEARCH_BASE_PREFIX + id));
		p.setSearchFilter(commonConfiguration.getString(LdapConfig.SEARCH_FILTER_PREFIX + id));
		p.setUrl(commonConfiguration.getString(LdapConfig.SERVICE_URL_PREFIX + id));
		p.setUser(commonConfiguration.getString(LdapConfig.USER_PREFIX + id));
		p.setId(commonConfiguration.getString(LdapConfig.ID_PREFIX + id));
		p.setAutoIp(commonConfiguration.getBoolean(LdapConfig.DOMAIN_CONTROLLER_IP_AUTO_PREFIX + id));
		return p;
	}

	public List<String> listServiceIds(){
		ArrayList<String> ret = new ArrayList<String>();
		Configuration config =	commonConfiguration.subset("login.service.id");
		for(Iterator<?> it =  config.getKeys();it.hasNext();){
			ret.add(it.next().toString());
		}
		return ret;
	}

	public List<LdapConfig> listServices(){
		ArrayList<LdapConfig> ret = new ArrayList<LdapConfig>();
		List<String> ids = listServiceIds();

		for(String id: ids){
			ret.add(getServiceProperties(id));
		}
		return ret;
	}

	public void removeService(String id) {
		commonConfiguration.clearProperty(LdapConfig.ID_PREFIX + id);
		commonConfiguration.clearProperty(LdapConfig.NAME_PREFIX + id);
		commonConfiguration.clearProperty(LdapConfig.DOMAIN_NAME_PREFIX + id);
		commonConfiguration.clearProperty(LdapConfig.DOMAIN_CONTROLLER_IP_PREFIX + id);		
		commonConfiguration.clearProperty(LdapConfig.DOMAIN_CONTROLLER_IP_AUTO_PREFIX + id);	
		commonConfiguration.clearProperty(LdapConfig.GROUP_ATTRIBUTE_PREFIX + id);
		commonConfiguration.clearProperty(LdapConfig.PASSWORD_PREFIX + id);
		commonConfiguration.clearProperty(LdapConfig.SEARCH_BASE_PREFIX + id);
		commonConfiguration.clearProperty(LdapConfig.SEARCH_FILTER_PREFIX + id);
		commonConfiguration.clearProperty(LdapConfig.SERVICE_URL_PREFIX + id);
		commonConfiguration.clearProperty(LdapConfig.USER_PREFIX + id);
	}



}
