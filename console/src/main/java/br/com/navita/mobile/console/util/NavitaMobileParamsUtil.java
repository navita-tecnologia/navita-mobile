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

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.navita.mobile.console.EncryptionAware;



public abstract class NavitaMobileParamsUtil implements EncryptionAware{
	
	
	private static final Logger LOG = Logger.getLogger(NavitaMobileParamsUtil.class.getName());
	
	

	public static Map<String,Object> decodeParams(String hash)  {		
		Map<String, Object> result = new HashMap<String, Object>();
		String plain = null;
		try {
			plain = Decryptor.decrypt(hash,PRIVATE_KEY);			
		} catch (DecryptorException e) {
			LOG.log(Level.SEVERE,"Error decripting raw parameters",e);
			return null;
		}
		for(StringTokenizer tk = new StringTokenizer(plain,"&");tk.hasMoreTokens();){
			String token = tk.nextToken();
			if(token.indexOf("=")>0){
				String pair[] = token.split("=");
				try {
					result.put(pair[0],URLDecoder.decode( pair[1],"utf-8"));
				} catch (Exception e) {
					LOG.log(Level.SEVERE,"Error decripting encoded parameter " + pair[0],e);
					result.put(pair[0], pair[1]);
				}
			}
		}
		return result;
	}

	public static String extractFirstParam(Object object) {
		if(object instanceof String){
			return (String) object;
		}else if(object instanceof String[]){
			return ((String[])object)[0];
		}else{
			return object.toString();
		}		
	}

	public static Map<String, Object> extractFromArray(Map<String,Object> source){
		Map<String, Object> ret = new HashMap<String,Object>();
		for(String key: source.keySet()){
			ret.put(key,extractFirstParam( source.get(key)));
		}
		return ret;
	}
	
}
