/*
 * Copyright 2014 Navita Tecnologia.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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

	@SuppressWarnings("unchecked")
	public static void main( String args[] ) throws Throwable
	{
		String domainController    = null;
		String dnsServiceName      = "_ldap._tcp";
		//Specifies a Global Catalog server
		String aDSite              = "";
		//The Active Directory SITE to look
		String dnsDomain           = "NVT";
		//The DNS base Zone to look
		String aDDomain            = aDSite +	"._sites.dc._msdcs." +
		dnsDomain;    //The DNS Zone to look
		String dnsNameServer       = "NVT";
		//The DNS server to query
		String dnsQueryType[]      = {"SRV"};
		//DNS record type to query
		String retDomainController = null;
		//Returned Domain Controller
		Long retDNSweight;
		//Returned DNS record weight for the returned Domain Controller



		Hashtable dnsEnv = new Hashtable();
		dnsEnv.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
		dnsEnv.put("java.naming.provider.url", "dns://"	+ dnsNameServer +	"/" + aDDomain);
		DirContext dnsContext = new	InitialDirContext(dnsEnv);
		Attributes dnsQueryResult =	dnsContext.getAttributes(dnsServiceName,
				dnsQueryType);
		if (dnsQueryResult == null)	{
			System.out.println("Returned NULL");
		}
		for (NamingEnumeration dnsRR = dnsQueryResult.getAll();dnsRR.hasMoreElements();)
		{
			Attribute rr = (Attribute)dnsRR.next();

			//String attrId = rr.getID();
			for (Enumeration vals = rr.getAll();vals.hasMoreElements();)	{
				domainController = vals.nextElement().toString();

				StringTokenizer st = new StringTokenizer( domainController );
				retDNSweight = new Long(st.nextToken());
				st.nextToken();
				st.nextToken();
				retDomainController = st.nextToken();

				System.out.println("Domain	Controller: " + retDomainController + "Weight: " + retDNSweight.longValue());
				retDomainController = null;
				retDNSweight = null;
			}
		}
		dnsContext.close();


	}
}
