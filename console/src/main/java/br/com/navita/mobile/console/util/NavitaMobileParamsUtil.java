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

}
