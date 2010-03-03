package br.com.foo;

import java.util.Map;

import br.com.navita.mobile.domain.MobileBean;
import br.com.navita.mobile.remote.MobileService;


public class TesteMobileExecutor implements MobileService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
