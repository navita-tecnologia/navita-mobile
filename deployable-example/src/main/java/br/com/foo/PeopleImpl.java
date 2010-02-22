package br.com.foo;


import java.util.Arrays;
import java.util.Map;

import br.com.navita.mobile.console.deployable.DynamicExecutor;
import br.com.navita.mobile.console.domain.MobileBean;

public class PeopleImpl implements DynamicExecutor {

	@Override
	public MobileBean execute(Map<String, Object> params) {
		
		MobileBean bean = new MobileBean();
		bean.setMessage("Only a message");
		Object f1 = params.get("f1");
		if(f1!= null && f1.getClass().isArray()){
			bean.setList(Arrays.asList(f1));
		}else{
			bean.setObject(f1);
		}
		
		
		return bean;
	}

}
