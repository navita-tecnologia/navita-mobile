package br.com.navita.mobile.console.domain;

public class LdapConfig {

public static final String DOMAIN_NAME_PREFIX = "login.service.domain.name.";
public static final String ID_PREFIX = "login.service.id.";
public static final String NAME_PREFIX = "login.service.name.";
public static final String DOMAIN_CONTROLLER_IP_PREFIX = "login.service.domain.controller.ip.";
public static final String DOMAIN_CONTROLLER_IP_AUTO_PREFIX = "login.service.domain.controller.ip.auto.";
public static final String USER_PREFIX = "login.service.user.";
public static final String PASSWORD_PREFIX = "login.service.password.";
public static final String SERVICE_URL_PREFIX = "login.service.url.";
public static final String SEARCH_BASE_PREFIX = "login.service.search.base.";
public static final String SEARCH_FILTER_PREFIX = "login.service.search.filter.";
public static final String GROUP_ATTRIBUTE_PREFIX = "login.service.group.attribute.";
public static final String GROUP_FILTER_PREFIX = "login.service.group.filter.";
public static final String DEFAULT_PRIVATE_KEY = "RrSe916DqrdQANfFKaQkgQ==";

	private String name;
	private String domainName;
	private String ip;
	private String user; // CN=navita,OU=externo,OU=Grupos,DC=navita,DC=com,DC=br
	private String password;
	private String url; //ldap://192.168.10.9:389
	private String searchBase; // DC=navita,DC=com,DC=BR
	private String searchFilter; // (&(objectClass=user)(sAMAccountName=${1}))
	private String groupAttribute; //  memberOf
	private String groupFilter;
	private String id;
	private boolean autoIp;
	
	public boolean isAutoIp() {
		return autoIp;
	}
	public void setAutoIp(boolean autoIp) {
		this.autoIp = autoIp;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSearchBase() {
		return searchBase;
	}
	public void setSearchBase(String searchBase) {
		this.searchBase = searchBase;
	}
	public String getSearchFilter() {
		return searchFilter;
	}
	public void setSearchFilter(String searchFilter) {
		this.searchFilter = searchFilter;
	}
	public String getGroupAttribute() {
		return groupAttribute;
	}
	public void setGroupAttribute(String groupAttribute) {
		this.groupAttribute = groupAttribute;
	}
	public String getGroupFilter() {
		return groupFilter;
	}
	public void setGroupFilter(String groupFilter) {
		this.groupFilter = groupFilter;
	}
	
	@Override
		public String toString() {
			StringBuffer buffer = new StringBuffer();
			buffer
			.append("id=").append(this.id).append('\n')
			.append("domainName=").append(this.domainName).append('\n')
			.append("groupAttribute=").append(this.groupAttribute).append('\n')
			.append("groupFilter=").append(this.groupFilter).append('\n')
			.append("ip=").append(this.ip).append('\n')
			.append("autoIp=").append(this.autoIp).append('\n')
			.append("name=").append(this.name).append('\n')
			.append("password=").append(this.password).append('\n')
			.append("searchBase=").append(this.searchBase).append('\n')
			.append("searchFilter=").append(this.searchFilter).append('\n')
			.append("url=").append(this.url).append('\n')
			.append("user=").append(this.user);
			return buffer.toString();
		}

}
