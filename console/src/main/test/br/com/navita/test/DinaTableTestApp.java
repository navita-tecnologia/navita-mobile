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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import br.com.navita.mobile.console.operator.sap.wrap.SapParameter;
import br.com.navita.mobile.console.operator.sap.wrap.SapRow;
import br.com.navita.mobile.console.operator.sap.wrap.SapTable;

public class DinaTableTestApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SapTable table = new SapTable();
		table.setTableName("TB_01");
		SapParameter p1 = new SapParameter("P1", "v1");
		SapParameter p2 = new SapParameter("P2", "v2");
		SapRow row = new SapRow();
		row.add(p1);
		row.add(p2);
		table.add(row);
		
		List<SapTable> tables = new ArrayList<SapTable>();
		tables.add(table);

		System.out.println( JSONSerializer.toJSON(tables).toString());
		
		String ret = "[{'rows':[{'rowEnvelop':[{'name':'P1','value':'v1'},{'name':'P2','value':'v2'}]}],'tableName':'TB_01'}]";
		JSONArray array = (JSONArray) JSONSerializer.toJSON(ret);
		for(int i = 0; i < array.size(); i++){
			JSONObject obj = array.getJSONObject(i);
			System.out.println(obj.get("tableName"));
			JSONArray rows = obj.getJSONArray("rows");
			for(int j = 0; j < rows.size(); j++){
				JSONArray values = rows.getJSONObject(j).getJSONArray("rowEnvelop");
				for(int k = 0; k < values.size();k++){
					JSONObject item = values.getJSONObject(k);
					System.out.println(item.getString("name") + ":" + item.getString("value"));
				}
			}
		}
	}

}
