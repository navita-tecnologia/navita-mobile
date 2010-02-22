package br.com.navita.test;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.StringTokenizer;

import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class GetAD {

	public static void main( String args[] )
	{
		String domainController    = null;
		String dnsServiceName      = "_ldap._tcp";
		//Specifies a Global Catalog server
		String aDSite              = "";
		//The Active Directory SITE to look
		String dnsDomain           = "navita.corp";
		//The DNS base Zone to look
		String aDDomain            = aDSite +	"._sites.dc._msdcs." +
		dnsDomain;    //The DNS Zone to look
		String dnsNameServer       = "navita.corp";
		//The DNS server to query
		String dnsQueryType[]      = {"SRV"};
		//DNS record type to query
		String retDomainController = null;
		//Returned Domain Controller
		Long retDNSweight;
		//Returned DNS record weight for the returned Domain Controller


		try {
			Hashtable dnsEnv = new Hashtable();
			dnsEnv.put("java.naming.factory.initial",
			"com.sun.jndi.dns.DnsContextFactory");
			dnsEnv.put("java.naming.provider.url", "dns://"	+ dnsNameServer +
					"/" + aDDomain);
			DirContext dnsContext = new
			InitialDirContext(dnsEnv);
			Attributes dnsQueryResult =
				dnsContext.getAttributes(dnsServiceName,
						dnsQueryType);
			if (dnsQueryResult == null)	{
				System.out.println("Returned NULL");
			}
			for (NamingEnumeration dnsRR =		dnsQueryResult.getAll();dnsRR.hasMoreElements();)
			{
				Attribute rr = (Attribute)dnsRR.next();

				String attrId = rr.getID();
				for (Enumeration vals =		rr.getAll();vals.hasMoreElements();)	{
					domainController =
						vals.nextElement().toString();


					StringTokenizer st = new
					StringTokenizer( domainController );
					retDNSweight = new
					Long(st.nextToken());
					st.nextToken();
					st.nextToken();
					retDomainController = st.nextToken();


					System.out.println("Domain	Controller: " + retDomainController + "Weight: " + retDNSweight.longValue());
					retDomainController = null;
					retDNSweight        = null;
				}
			}
			dnsContext.close();
		} catch(Exception e) {
			System.err.println("Error performing DNS lookup	for: " + aDDomain +		"\n" + e);
		} 

	}
}
