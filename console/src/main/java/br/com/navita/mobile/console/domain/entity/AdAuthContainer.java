package br.com.navita.mobile.console.domain.entity;

import java.net.UnknownHostException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

import jcifs.UniAddress;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbException;
import jcifs.smb.SmbSession;

import br.com.navita.mobile.console.bizz.DcResolver;
import br.com.navita.mobile.console.domain.DomainControler;
import br.com.navita.mobile.console.domain.LdapConfig;
import br.com.navita.mobile.console.domain.LoginResult;
import br.com.navita.mobile.console.domain.UserGroup;
import br.com.navita.mobile.console.util.Decryptor;
import br.com.navita.mobile.console.util.DecryptorException;

@Entity
public class AdAuthContainer extends AuthContainer{
	
	@Transient
	private static final Logger LOG = Logger.getLogger(AdAuthContainer.class.getName());

	@Column
	private String domainUser;
	
	@Column
	private String domainUserPassword;
	
	@Column
	private String domainName;
	
	@Column
	private boolean dnsResolving;
	
	@Column
	private String ip;
	
	@Column
	private String url;
	
	@Column
	private String searchBase;
	
	@Column
	private String searchFilter;
	
	@Column
	private String groupAttribute;
	
	@Column
	private String groupFilter;
	
	@Override
	public LoginResult login(String user, String passwd) {
		
		LoginResult result = new LoginResult();
		UniAddress dcUniAddress = null;
		String hostName = null;
		if(this.dnsResolving){
			try {
				DomainControler dc = DcResolver.resolveDomainControler(this.domainName);
				if(dc == null){
					throw new NullPointerException("Invalid domain controller");
				}
				hostName = dc.getHostName();
			} catch (Exception e) {
				LOG.log(Level.SEVERE,"Error getting auto uniaddress using " + this.domainName,e);
				result.setMessage(e.getMessage());
				return result;
			}
		}else{
			hostName = this.ip;
		}
		try {
			dcUniAddress = UniAddress.getByName(hostName);
		} catch (UnknownHostException e) {
			LOG.log(Level.SEVERE,"Error getting uniaddress using "+hostName,e);
			result.setMessage(e.getMessage());
			return result;
		}
		NtlmPasswordAuthentication mycreds = new NtlmPasswordAuthentication( this.domainName, user, passwd );
		try {
			LOG.info("Loging in " + this.domainName +"\\"+user+" against "+hostName);
			SmbSession.logon( dcUniAddress, mycreds );
			LOG.info(this.domainName +"\\"+user+" successfully logged in against "+hostName);
		} catch (SmbException e) {
			LOG.log(Level.SEVERE,"Error  loging in " + this.domainName + "\\"+user,e);
			result.setMessage(e.getMessage());
			return result;
		}
		if(null != this.domainUser && ! this.domainUser.isEmpty()){//FIXME: incluir flag para buscar grupos ou nao!
			try {
				LOG.info("Getting groups from user " + this.domainName +"\\"+user+" against "+hostName);
				result.setGroups(getUserGroups(user));
				LOG.info("Groups successfully retrieved for user " + this.domainName + "\\"+user+" against "+hostName);
			} catch (NamingException e) {
				LOG.log(Level.SEVERE,"Error getting groups for "+  this.domainName +"\\"+user,e);
				result.setMessage(e.getMessage());
				return result;
			}
		}

		result.setLogged(true);
		result.setToken(UUID.randomUUID().toString());

		return result;
	}
	
	@Override
	public List<String> getGroupLogins(String groupName) throws NamingException {
		ArrayList<String> groupList = new ArrayList<String>();		
		String searchFilter = "(cn="+groupName+")";
		String attributesToReturn[] = new String[]{"member"};
		LdapContext ctx = null;
		try{
			ctx = getLdapContext();
			List<String> ret = getAttributes(searchFilter, attributesToReturn,ctx);
			if(ret.size()==0){
				return null;
			}
			for(String dn : ret){
				List<String> att = getAttributes("(distinguishedName="+dn+")", new String[]{"objectClass"},ctx);
				if(att.contains("user")){
					List<String> nameAtt = getAttributes("(distinguishedName="+dn+")", new String[]{"givenName"},ctx);
					groupList.add( nameAtt.get(0));
				}
			}
			
		}finally{
			ctx.close();
			ctx = null;
		}
		return groupList;
	}

	@Override
	public List<UserGroup> getUserGroups(String login) throws NamingException {
		String searchFilterToUse = MessageFormat.format(this.searchFilter, new Object[]{login});
		List<UserGroup> ret = new ArrayList<UserGroup>();
		LdapContext ctx = null;
		try{
			ctx = getLdapContext();
			List<String> groupCns = getAttributes(searchFilterToUse,new String[]{"memberOf"},ctx);
			
			for(String dn : groupCns){
				UserGroup g = new UserGroup();
				g.setDn(dn);

				String groupFiltertoUse = "(distinguishedName="+dn+")";
				if (this.groupFilter != null && this.groupFilter.length() > 0){
					//(distinguishedName=$dn) dn vem desse metodo
					//(&(distinguishedName=$dn)$filtro) $filtro é algo como (name=*prod)
					groupFiltertoUse = "(&" + groupFiltertoUse + this.groupFilter + ")";
				}
				List<String> att = getAttributes(groupFiltertoUse, new String[]{"name"},ctx);
				if (att.size() > 0){
					g.setName(att.get(0));
					ret.add(g);
				}
			}
			
		}finally{
			ctx.close();
			ctx = null;
		}
		
		return ret;
	}
	
	
	
	private  NamingEnumeration<SearchResult> prepareAnswer(LdapContext ctx, String searchBase, String searchFilter,
			String[] attributesToReturn) throws NamingException{
		//Create the search controls 		
		SearchControls searchCtls = new SearchControls();

		//Specify the search scope
		searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);

		//Specify the attributes to return			
		searchCtls.setReturningAttributes(attributesToReturn);

		//Search for objects using the filter
		NamingEnumeration<SearchResult> answer = ctx.search(searchBase, searchFilter, searchCtls);

		return answer;
	}

	private List<String> getAttributes(String searchFilter,String[] attributesToReturn, LdapContext ctx ) throws NamingException{
		LOG.log(Level.INFO,"Quering ldap for "+Arrays.asList(attributesToReturn)+" attributes on "+searchFilter+" : ");
		ArrayList<String> attrList=new ArrayList<String>();
		try {
			//Search for objects using the filter
			NamingEnumeration<SearchResult> answer = prepareAnswer(ctx, this.searchBase, searchFilter, attributesToReturn);
			int totalResults = 0;

			//Loop through the search results
			while (answer.hasMoreElements()) {
				SearchResult sr = (SearchResult)answer.next();
				Attributes attrs = sr.getAttributes();
				if (attrs != null) {
					try {
						for (NamingEnumeration<?> ae = attrs.getAll();ae.hasMore();) {
							Attribute attr = (Attribute)ae.next();							
							for (NamingEnumeration<?> e = attr.getAll();e.hasMore();totalResults++) {
								String fullName=  e.next().toString();
								attrList.add(fullName);
								LOG.log(Level.INFO,searchFilter+" >> "+fullName);
							}
						}
					}	 
					catch (NamingException e)	{
						throw e;
					}
				}
			} 

		}catch (NamingException e) {

			throw e;
		}		
		return  attrList;
	}

	private LdapContext  getLdapContext() throws NamingException {
		//FIXME: este contexto pode vir do spring ou de um cache?
		Hashtable<String,String> env = new Hashtable<String,String>();
		String adminName = this.domainUser;		
		String adminPassword = "";
		try {
			adminPassword = Decryptor.decrypt(this.domainUserPassword, LdapConfig.DEFAULT_PRIVATE_KEY);
		} catch (DecryptorException e) {

		}
		String ldapURL = null;
		if(this.dnsResolving){
			DomainControler dc = DcResolver.resolveDomainControler(this.domainName);
			if(dc == null){
				throw new NamingException("Invalid domain controller");
			}
			ldapURL = dc.getUrl();
		}else{
			ldapURL = this.url;
		}


		env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
		//set security credentials, note using simple cleartext authentication
		env.put(Context.SECURITY_AUTHENTICATION,"simple");
		env.put(Context.SECURITY_PRINCIPAL,adminName);
		env.put(Context.SECURITY_CREDENTIALS,adminPassword);

		//connect to my domain controller
		env.put(Context.PROVIDER_URL,ldapURL);
		LOG.info("Creating LDAP context using url "+ldapURL+" and user "+adminName);
		return new InitialLdapContext(env,null);
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

	
	
	
	
	
}
