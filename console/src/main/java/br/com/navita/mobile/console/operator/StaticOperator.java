package br.com.navita.mobile.console.operator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.navita.mobile.console.domain.entity.Operation;
import br.com.navita.mobile.console.domain.entity.StaticOperation;
import br.com.navita.mobile.domain.MobileBean;

public class StaticOperator implements Operator{

	
	@Override
	public MobileBean doOperation(Operation operation, Map<String, Object> params) throws JSONException {
		MobileBean bean = new MobileBean();
		StaticOperation staticOperation = (StaticOperation) operation;	
		JSONObject j = new JSONObject();
		if(! j.isNull("message")){
			bean.setMessage(staticOperation.getMessage());
		}
		if(! j.isNull("token")){
			bean.setToken(staticOperation.getToken());
		}
		if(! j.isNull("resultCode")){
			bean.setResultCode(staticOperation.getResultCode());
		}
		if(! j.isNull("object")){
			bean.setObject(staticOperation.getObject());
		}
		if(! j.isNull("list")){
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
