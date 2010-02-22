package br.com.foo;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import br.com.foo.OutroBean;
import br.com.navita.mobile.console.deployable.DynamicExecutor;
import br.com.navita.mobile.console.domain.MobileBean;


public class TesteMobileExecutor implements DynamicExecutor {
	
	@Override
	public MobileBean execute(Map<String, Object> params) {
		MobileBean bean = new MobileBean();
		bean.setMessage("Estrutura nova");
		bean.setToken(String.valueOf(System.currentTimeMillis()));
		bean.setList(Arrays.asList(new SomeBean("v1","v2"),new SomeBean("v3","v4")));
		OutroBean b = new OutroBean();
		b.setD1(new Date());
		b.setNum1(123);
		bean.setObject(b);
		return bean;
	}
	
	@Override
	public String toString() {
		
		return "Lala 2";
	}

}
