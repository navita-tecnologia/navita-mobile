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

import java.util.Map;

import br.com.navita.mobile.console.exception.SapGatewayException;
import br.com.navita.mobile.console.operator.sap.PoolManager;
import br.com.navita.mobile.domain.MobileBean;

import com.sap.mw.jco.JCO;
import com.sap.mw.jco.JCO.ParameterList;
import com.sap.mw.jco.JCO.Table;

public class ZgasoaApproval  {


	protected MobileBean execute(Map<String, Object> params) throws SapGatewayException {
		String token = (String) params.get("token");
		JCO.Client client = null;
		try{
			client = JCO.getClient(token);
			JCO.Function func = PoolManager.createFunction("ZGASOA_APPROVAL", token);
			ParameterList input = func.getImportParameterList();
			input.setValue(params.get("wiId"), "WI_ID");
			input.setValue(params.get("aproveFlag"), "APPROVEFLAG");
			Table message = func.getTableParameterList().getTable("MESSAGE");
			message.appendRow();
			message.setValue("TXTMOTIVO", "ELEMENT");
			message.setValue(params.get("message"), "VALUE");

			client.execute(func);
		}finally{
			JCO.releaseClient(client);
		}
		return new MobileBean();
	}

}
