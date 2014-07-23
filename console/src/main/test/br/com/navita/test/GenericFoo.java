package br.com.navita.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;




public class GenericFoo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws Exception {
		StringBuffer buff = new StringBuffer();
		File f = new File("C:\\java\\workspace\\navita-mobile-console\\src\\main\\test\\br\\com\\navita\\test\\json.txt");
		BufferedReader r = new BufferedReader(new FileReader(f));
		String linha = "";
		while((linha = r.readLine())!=null){
			buff.append(linha);
		}

		r.close();
		String jsonText = buff.toString();

		JSONObject genericBean = new JSONObject(jsonText);
		JSONArray array = genericBean.getJSONArray("list");
		Vector<Hashtable<String, String>> ret = new Vector<Hashtable<String, String>>();
		for(int i=0;i<array.length();i++){
			JSONObject item = array.getJSONObject(i);
			JSONArray values = item.getJSONArray("item");
			Hashtable<String, String> bean = new Hashtable<String,String>();
			for(int j = 0;j < values.length();j++){
				JSONObject pair = values.getJSONObject(j);				
				bean.put(pair.getString("name"), pair.getString("value"));	
			}
			ret.add(bean);

		}

		System.out.println(ret);
	}

}
