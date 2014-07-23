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
package br.com.navita.mobile.console.util;

import java.util.Enumeration;
import java.util.logging.Logger;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import br.com.navita.mobile.console.domain.DomainControler;

public class DcResolver {
	private static final Logger LOG = Logger.getLogger(DcResolver.class.getName());
	
	public static DomainControler resolveDomainControler(String domainName) throws NamingException{
		DomainControler dc = null;
		String[] SRV = getSRVRecord(domainName);
		if (SRV != null && SRV.length == 4){
			dc = new DomainControler(SRV[3],Integer.valueOf(SRV[2]));
		}
		return dc;
	}
	
	private static String[] getSRVRecord(String name) throws NamingException  {		
		String prefix = "dns:/_ldap._tcp.dc._msdcs.";
		LOG.info("Searching for "+prefix+name);
		DirContext context = new InitialDirContext();
		Attributes attributes = context.getAttributes(
				prefix + name,
				new String[] { "SRV" });
		String v="";
		for(Enumeration<String> e= attributes.getIDs();e.hasMoreElements();){
			String key = e.nextElement();
			v = attributes.get(key).get().toString();
			//returna apenas o primeiro
			LOG.info(name +" resolved to "+v);
			return v.split(" ");
		}
		
		return null;
		
	}
}
