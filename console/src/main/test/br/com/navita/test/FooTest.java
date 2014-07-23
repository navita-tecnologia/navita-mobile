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
