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
