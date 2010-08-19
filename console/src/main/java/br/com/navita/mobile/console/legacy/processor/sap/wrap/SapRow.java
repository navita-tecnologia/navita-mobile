package br.com.navita.mobile.console.legacy.processor.sap.wrap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SapRow extends HashMap<String,Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void add(SapParameter sapParameter) {
		put(sapParameter.getName(),sapParameter.getValue());
		
	}

	public List<SapParameter> getSapParameters() {
		ArrayList<SapParameter> ret = new ArrayList<SapParameter>();
		for(String key:keySet()){
			ret.add(new SapParameter(key,get(key).toString()));
		}
		return ret;
	}

	
}
