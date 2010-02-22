package br.com.navita.test;


import java.net.URL;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.navita.mobile.ws.client.DynamicClient;

public class WsDynamicClient {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		DynamicClient dynamicClient = (DynamicClient) ctx.getBean("dynaClient",new Object[]{new URL( "http://127.0.0.1:8889/navita-mobile-sample-app" + DynamicClient.wsPart)});
		//GenericBean bean = dynamicClient.execute(new GenericBean());
		//System.out.println(new JSONObject(bean));
		/*List<NameValuePair>	 list = dynamicClient.execute(new ArrayList<NameValuePair>());
		for(NameValuePair pair:list){
		System.out.println(pair.getName()+ "=" +pair.getValue().getClass().getName());
		}*/
	}

}
