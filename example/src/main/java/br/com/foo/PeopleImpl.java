package br.com.foo;


import java.util.Arrays;
import java.util.Map;

import br.com.navita.mobile.domain.MobileBean;
import br.com.navita.mobile.remote.MobileService;

public class PeopleImpl implements MobileService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
