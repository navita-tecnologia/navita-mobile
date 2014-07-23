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

import br.com.navita.mobile.console.domain.SapConnector;
import br.com.navita.mobile.console.operator.sap.PoolManager;
import br.com.navita.mobile.console.operator.sap.SapSession;

import com.sap.mw.jco.JCO;

public class SapTestApp {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		SapConnector connector = new SapConnector();
		connector.setClient("???");
		connector.setSysnr("???");
		connector.setAsHost("???");
		connector.setLang("PT");

		SapSession session = PoolManager.createSession("???", "???", connector);


		JCO.Client client = null;
		client = JCO.getClient(session.getToken());
		JCO.Function func = PoolManager.createFunction("?????", session.getToken());

		func.getImportParameterList();//set
		client.execute(func);
		func.getExportParameterList();//get

	}

}
