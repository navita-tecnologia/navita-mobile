package br.com.navita.mobile.console.bizz;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
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

import br.com.navita.mobile.console.domain.DomainControler;
import br.com.navita.mobile.console.domain.LdapConfig;
import br.com.navita.mobile.console.domain.UserGroup;
import br.com.navita.mobile.console.util.Decryptor;
import br.com.navita.mobile.console.util.DecryptorException;

public class LdapServiceImpl implements LdapService {

	private static final Logger LOG = Logger.getLogger(LdapServiceImpl.class.getName());


	@Override
	public List<String> getGroupLogins(String groupName, LdapConfig config) throws NamingException {
		ArrayList<String> groupList = new ArrayList<String>();		
		String searchFilter = "(cn="+groupName+")";
		String attributesToReturn[] = new String[]{"member"};
		LdapContext ctx = null;
		try{
			ctx = getLdapContext(config);
			List<String> ret = getAttributes(searchFilter, attributesToReturn,config,ctx);
			if(ret.size()==0){
				return null;
			}
			for(String dn : ret){
				List<String> att = getAttributes("(distinguishedName="+dn+")", new String[]{"objectClass"},config,ctx);
				if(att.contains("user")){
					List<String> nameAtt = getAttributes("(distinguishedName="+dn+")", new String[]{"givenName"},config,ctx);
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
	public List<UserGroup> getUserGroups(String login, LdapConfig config) throws NamingException {		
		String searchFilter = MessageFormat.format(config.getSearchFilter(), new Object[]{login});
		List<UserGroup> ret = new ArrayList<UserGroup>();
		LdapContext ctx = null;
		try{
			ctx = getLdapContext(config);
			List<String> groupCns = getAttributes(searchFilter,new String[]{"memberOf"},config,ctx);
			
			for(String dn : groupCns){
				UserGroup g = new UserGroup();
				g.setDn(dn);

				String groupFilter = "(distinguishedName="+dn+")";
				if (config.getGroupFilter() != null && config.getGroupFilter().length() > 0){
					//(distinguishedName=$dn) dn vem desse metodo
					//(&(distinguishedName=$dn)$filtro) $filtro é algo como (name=*prod)
					groupFilter = "(&" + groupFilter + config.getGroupFilter() + ")";
				}
				List<String> att = getAttributes(groupFilter, new String[]{"name"},config,ctx);
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

	private List<String> getAttributes(String searchFilter,String[] attributesToReturn, LdapConfig config,LdapContext ctx ) throws NamingException{
		LOG.log(Level.INFO,"Quering ldap for "+Arrays.asList(attributesToReturn)+" attributes on "+searchFilter+" : ");
		ArrayList<String> attrList=new ArrayList<String>();
		try {
			//Search for objects using the filter
			NamingEnumeration<SearchResult> answer = prepareAnswer(ctx, config.getSearchBase(), searchFilter, attributesToReturn);
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

	private LdapContext  getLdapContext(LdapConfig config) throws NamingException {
		Hashtable<String,String> env = new Hashtable<String,String>();
		String adminName = config.getUser();		
		String adminPassword = "";
		try {
			adminPassword = Decryptor.decrypt(config.getPassword(), LdapConfig.DEFAULT_PRIVATE_KEY);
		} catch (DecryptorException e) {

		}
		String ldapURL = null;
		if(config.isAutoIp()){
			DomainControler dc = DcResolver.resolveDomainControler(config.getDomainName());
			if(dc == null){
				throw new NamingException("Invalid domain controller");
			}
			ldapURL = dc.getUrl();
		}else{
			ldapURL = config.getUrl();
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

}
