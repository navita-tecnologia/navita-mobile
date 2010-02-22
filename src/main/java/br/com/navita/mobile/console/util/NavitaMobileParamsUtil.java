package br.com.navita.mobile.console.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.navita.mobile.console.domain.MobileApplication;



public abstract class NavitaMobileParamsUtil {
	private static final Logger LOG = Logger.getLogger(NavitaMobileParamsUtil.class.getName());
	public static Map<String, Object> extractFromRequestMap(MobileApplication app, Map<?, ?> params) {
		LOG.log(Level.INFO,"Extracting parameters for "+app.getId());
		Map<String, Object> result = new HashMap<String, Object>();

		for(Iterator<?> it = params.keySet().iterator();it.hasNext();){
			String key = it.next().toString();
			String[] values = (String[]) params.get(key);
			
			if("raw".equals(key)){
				if(!"plain".equals(values[0])){
					result.putAll(decodeParams(app.getPrivateKey(),((String[]) params.get(key))[0]));
					continue;
				}
			}
			

			if(values.length == 1){
				result.put(key, values[0]);
			}else{
				result.put(key, values);
			}
		}

		LOG.log(Level.INFO,"Extracting parameters for "+app.getId()+" done");
		return result;
	}

	private static Map<String,Object> decodeParams(String privateKey, String hash)  {		
		Map<String, Object> result = new HashMap<String, Object>();
		String plain = null;
		try {
			plain = Decryptor.decrypt(hash,privateKey);			
		} catch (DecryptorException e) {
			LOG.log(Level.SEVERE,"Error decripting raw parameters",e);
			return null;
		}
		for(StringTokenizer tk = new StringTokenizer(plain,"&");tk.hasMoreTokens();){
			String token = tk.nextToken();
			if(token.indexOf("=")>0){
				String pair[] = token.split("=");
				result.put(pair[0], pair[1]);
			}
		}
		return result;
	}

	
	
//	public static void fillList(GenericBean bean, List<?> listParam) {		
//		List<NameValueArray> list = bean.getList();
//		for(Object g : listParam){
//			NameValueArray item = new NameValueArray();
//			item.getItem().addAll(Arrays.asList( extractNameValueArray(g)));
//			list.add(item);
//		}
//		
//	}
//	
//	public static NameValue[] extractNameValueArray(Object bean){
//		Map<?,?> props =null;
//		try {
//			props = PropertyUtils.describe(bean);
//		} catch (Exception e) {
//			return null;
//		}
//		NameValue[] ret = new NameValue[props.size()];
//
//		int i=0;
//		for(Object key:props.keySet()){
//			NameValue temp = new NameValue();
//			temp.setName(key.toString());
//			temp.setValue(props.get(key));			
//			ret[i++] = temp;
//		}
//
//		return ret;
//	}

}
