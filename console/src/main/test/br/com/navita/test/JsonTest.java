package br.com.navita.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.sf.json.JSONSerializer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.navita.mobile.domain.MobileBean;
import br.com.navita.mobile.console.sap.wrap.SapRow;
import br.com.navita.mobile.console.sap.wrap.SapTable;

public class JsonTest {

	/**
	 * @param args
	 * @throws JSONException 
	 */
	public static void main(String[] args) throws Exception {
		SapRow foo = new SapRow();
		foo.put("a","b");
		foo.put("c","d");
		foo.put("e","f");
		SapTable table = new SapTable();
		table.setTableName("lala");		
		table.add(foo);
		MobileBean bean = new MobileBean();
		List<Object> l = new ArrayList<Object>();
		l.add(table);
		bean.setList(l);
		String result = JSONSerializer.toJSON(bean).toString();
		JSONObject obj = new JSONObject(result);
		System.out.println(result);
		JSONArray ar = obj.getJSONArray("list");
		System.out.println(ar.getJSONObject(0).getJSONArray("rows"));
		System.out.println(ar.getJSONObject(0).getJSONArray("rows").getJSONObject(0));
		
		
		
	}

	static JSONArray extractArray(Collection<?> c){
		JSONArray array = new JSONArray();
		for(Object o:c){
			if(o instanceof Collection){
				System.out.println("Puting coolection");
				array.put(extractArray((Collection<?>) o));
			}else{
				System.out.println("Puting obj");
				array.put(new JSONObject(o));
			}
		}
		
		return array;
	}
	
}
