package br.com.navita.mobile.console.operator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;

import br.com.navita.mobile.console.domain.entity.Operation;
import br.com.navita.mobile.console.domain.entity.StaticOperation;
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
