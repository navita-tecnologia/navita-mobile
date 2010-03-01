package br.com.foo;

import java.util.Map;

import br.com.navita.mobile.console.deployable.DynamicExecutor;
import br.com.navita.mobile.console.domain.MobileBean;


public class TesteMobileExecutor implements DynamicExecutor {
	
	@Override
	public MobileBean execute(Map<String, Object> params) {
		MobileBean bean = new MobileBean();
		bean.setMessage("Lalalalal lalalal");
		bean.setToken("token 123");
		//bean.setList(Arrays.asList(new SomeBean("v1","v2"),new SomeBean("v3","v4")));
		LalaBean lala = new LalaBean();
		lala.setLala("valor de lala");
		bean.setObject(lala);
		return bean;
	}
	
}
