package br.com.navita.test;

import java.util.Enumeration;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;


public class DomainTest {
	String getDomain(String name) throws NamingException  {		
		String prefix = "dns:/_ldap._tcp.dc._msdcs.";
		DirContext context = new InitialDirContext();
		Attributes attributes = context.getAttributes(
				prefix + name,
				new String[] { "SRV" });
		String v="";
		for(Enumeration<String> e= attributes.getIDs();e.hasMoreElements();){
			String key = e.nextElement();
			v = attributes.get(key).get().toString();
			System.out.println(v);
		}
		
		return v;
	}

	public static void main(String argv[]) throws Exception {
		String domain = "navita.corp";
		if (argv.length > 0){
			domain = argv[0];
		}
		DomainTest dnsSrv = new DomainTest();
		dnsSrv.getDomain(domain);
	}

}
