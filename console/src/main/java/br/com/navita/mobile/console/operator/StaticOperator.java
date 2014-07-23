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
package br.com.navita.mobile.console.operator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;

import br.com.navita.mobile.console.domain.Operation;
import br.com.navita.mobile.console.domain.StaticOperation;
import br.com.navita.mobile.domain.MobileBean;

public class StaticOperator implements Operator{

	
	@Override
	public MobileBean doOperation(Operation operation, Map<String, Object> params) throws JSONException {
		MobileBean bean = new MobileBean();
		StaticOperation staticOperation = (StaticOperation) operation;	
		
		if(staticOperation.getMessage() != null && ! staticOperation.getMessage().isEmpty() ){
			bean.setMessage(staticOperation.getMessage());
		}
		if(staticOperation.getToken() != null && ! staticOperation.getToken().isEmpty()){
			bean.setToken(staticOperation.getToken());
		}
		
		bean.setResultCode(staticOperation.getResultCode());
		
		if(staticOperation.getObject() != null  && ! staticOperation.getObject().isEmpty()){
			bean.setObject(staticOperation.getObject());
		}
		if(staticOperation.getList() != null  && ! staticOperation.getList().isEmpty()){
			JSONArray array = new JSONArray(staticOperation.getList());
			List<Object> list = new ArrayList<Object>();
			bean.setList(list);
			for(int i = 0;i<array.length();i++){
				list.add(array.get(i).toString());
			}
		}

		return bean;
	}

}
