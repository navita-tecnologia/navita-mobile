package br.com.navita.test;

import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.httpclient.HttpException;

import br.com.navita.mobile.console.util.Encryptor;

public class FooTest {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws HttpException 
	 */
	public static void main(String[] args) throws Exception {
		//new  HttpClientUtil(null).get("http://weril.navita.corp/col1/administracao/home.html", null);
		Calendar cal = Calendar.getInstance();
		String app = "sap-tbg";
		cal.add(Calendar.MONTH, 1);
		System.out.println(Encryptor.encrypt(app+"|"+cal.getTimeInMillis(), "RrSe916DqrdQANfFKaQkgQ=="));
		
	}

}
