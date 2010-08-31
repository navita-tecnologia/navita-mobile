package br.com.navita.mobile.console.view;

import java.util.List;

import br.com.navita.mobile.console.domain.entity.AdAuthContainer;
import br.com.navita.mobile.console.domain.entity.AuthContainer;
import br.com.navita.mobile.console.service.AuthContainerService;
import br.com.navita.mobile.console.view.rawdata.AdAuthContainerRaw;

public class DomainsAction extends RawActionSupport implements AdAuthContainerRaw{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AuthContainerService authContainerService;
	
	private String domainUser;
	private String domainUserPassword;
	private String domainName;
	private boolean dnsResolving;
	private String ip;
	private String url;
	private String searchBase;
	private String searchFilter;
	private String groupAttribute;
	private String groupFilter;
	
	private AdAuthContainer adAuthContainer;
	
	public AdAuthContainer getAdAuthContainer() {
		return adAuthContainer;
	}
	
	public void setAdAuthContainer(AdAuthContainer adAuthContainer) {
		this.adAuthContainer = adAuthContainer;
	}
	
	
	
	public String getDomainUser() {
		return domainUser;
	}

	public void setDomainUser(String domainUser) {
		this.domainUser = domainUser;
	}

	public String getDomainUserPassword() {
		return domainUserPassword;
	}

	public void setDomainUserPassword(String domainUserPassword) {
		this.domainUserPassword = domainUserPassword;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public boolean isDnsResolving() {
		return dnsResolving;
	}

	public void setDnsResolving(boolean dnsResolving) {
		this.dnsResolving = dnsResolving;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
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

	public AuthContainerService getAuthContainerService() {
		return authContainerService;
	}

	public void setAuthContainerService(
			AuthContainerService authContainerService) {
		this.authContainerService = authContainerService;
	}
	
	public List<AuthContainer> getAuthContainers(){
		return authContainerService.listAll();
	}



	public String edit() throws Exception {		
		adAuthContainer = (AdAuthContainer) authContainerService.findbyId(id);
		return INPUT;

	}

	public String save() throws Exception  {	
		adAuthContainer = authContainerService.saveAD(this);
		addActionMessage("Domain salvo com sucesso");
		return INPUT;
	}

	public String remove() throws Exception{
		authContainerService.remove(this);
		addActionMessage("Domain excluido com sucesso");
		return SUCCESS;
	}

	public String createPrepare(){
		adAuthContainer = new AdAuthContainer();
		return INPUT;
	}
	public String create() throws Exception {
		adAuthContainer = authContainerService.insertAD(this);
		addActionMessage("Domain criado com sucesso");
		id = adAuthContainer.getId();
		return edit();
	}

	public String test(){
//		ldapConfig  = ldapConfigDAO.getServiceProperties(ldapConfig.getId());
//		((MSWindowsLoginService)msLoginService).setConfig(ldapConfig);
//		LoginResult result = null;
//		try {
//			result =  msLoginService.login(testUser,testPasswd);
//			if(result!=null && ! result.isLogged()){
//				addActionError(result.getMessage());
//			}
//			if(result!=null && result.isLogged()){
//				addActionMessage("Login realizado com sucesso");
//				
//			}
//			if(result==null){
//				addActionError("login failed");
//			}
//			List<UserGroup> groups = ldapService.getUserGroups(testUser, ldapConfig);
//			addActionMessage(groups.toString());
//			
//		} catch (Exception e) {
//			addActionError(e.getMessage());
//		}



		return 	INPUT;
	}

	
}
