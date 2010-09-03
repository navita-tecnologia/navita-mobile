package br.com.navita.test;

import org.json.JSONObject;

import br.com.navita.mobile.console.util.Encryptor;
import br.com.navita.mobile.console.util.HttpClientUtil;

public class MobileClientTester {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception  {
		HttpClientUtil browser = new HttpClientUtil();


		String appid = "dynamic1";
		String raw = Encryptor.encrypt("user=navita&password=navita", "RrSe916DqrdQANfFKaQkgQ==");
		String operation = "op1";
		String retType = "json";

		String url = "http://127.0.0.180/mobile-console/gateway.action?app="+appid+"&operation="+operation+"&retType="+retType+"&raw="+raw;
		System.out.println(url);

		String result1 = null;
		
		if("a".equals("a"))
		while(true){
			result1 = browser.get(url, null);
			System.out.println(result1);
			Thread.sleep(500L);
		}
		JSONObject obj1 = new JSONObject(result1);


		System.out.println(obj1.getString("foo"));


		if("a".equals("a"))return;
		String token = obj1.getString("token");
		System.out.println(token);
		String op2="teste";
		url = "http://192.168.10.104/mobile-console/gateway.action?app="+
		appid+"&operation="+op2+"&retType="+retType+"&usuario=COORDORCAMEN&token="+token;
		String otherParams = "&pedido=4500000282";//"&userId=APIVETTA";
		String result2 = browser.get(url+otherParams, null);

		System.out.println(result2);

	}

}
