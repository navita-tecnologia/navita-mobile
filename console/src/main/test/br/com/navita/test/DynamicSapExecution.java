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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.navita.mobile.console.domain.SapParameter;
import br.com.navita.mobile.console.domain.SapRow;
import br.com.navita.mobile.console.domain.SapTable;
import br.com.navita.mobile.console.exception.SapGatewayException;
import br.com.navita.mobile.console.operator.sap.PoolManager;
import br.com.navita.mobile.domain.MobileBean;

import com.sap.mw.jco.JCO;
import com.sap.mw.jco.JCO.Function;
import com.sap.mw.jco.JCO.ParameterList;
import com.sap.mw.jco.JCO.Table;

public class DynamicSapExecution extends SapExecution {

	
	protected MobileBean execute(Map<String, Object> params) throws SapGatewayException {
		String token = (String) params.get("token");		
		JCO.Client client = null;
		MobileBean bean = new MobileBean();
		try{
			client = JCO.getClient(token);

			String fName = config.getFunctionName();
			Function function = PoolManager.createFunction(fName, token);

			ParameterList paramInList = function.getImportParameterList();
			if(paramInList != null){
				for(SapParameter sapParam:config.getInputParameterList()){			
					String value = sapParam.getValue();
					if(value.startsWith("$")){
						Object param = params.get(value.substring(1));
						if(null == param){
							value= " ";
						}else{
							value = param.toString();
						}						
						
					}				
					paramInList.setValue(value, sapParam.getName());				
				}
			}
			ParameterList tList = function.getTableParameterList();

			if(config.getInputTableList()!=null){
				for(SapTable paramTable: config.getInputTableList()){
					Table table = tList.getTable(paramTable.getName());
					int paramIndex = 0;
					for(SapRow row:paramTable.getSapRows()){
						table.appendRow();
						table.setRow(paramIndex++);
						for(SapParameter param:row.getAttributes()){	
							String value = param.getValue();
							if(value.startsWith("$")){
								value = (String) params.get(value.substring(1));
							}	
							table.setValue(value, param.getName());
						}
					}
				}
			}
			client.execute(function);

			List<SapTable> tables = new ArrayList<SapTable>();
			for(SapTable st : config.getOutputTableList()){				
				Table sapTable = tList.getTable(st.getName());
				for(int row =0;row < sapTable.getNumRows();row++){
					sapTable.setRow(row);
					SapRow mapRow = new SapRow();
					for(int field = 0;field < sapTable.getFieldCount();field++){
						mapRow.addAttribute(new SapParameter(sapTable.getField(field).getName(), sapTable.getString(field)));
					}				
					st.addRow(mapRow);
				}
				tables.add(st);
			}
			bean.setList(tables);
			bean.setMessage("");
			bean.setResultCode(0);
		}finally{		
			try{
				JCO.releaseClient(client);
			}catch (Throwable e) {
				//engole a exception pois nao ha nada o que fazer...
			}
		}

		return bean;
	}



}
