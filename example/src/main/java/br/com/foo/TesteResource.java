package br.com.foo;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import br.com.navita.mobile.domain.MobileBean;
import br.com.navita.mobile.remote.MobileService;

public class TesteResource implements MobileService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public MobileBean execute(Map<String, Object> arg0) {
		MobileBean bean = new MobileBean();
		ResourceBundle b = ResourceBundle.getBundle("plugin",Locale.getDefault(),this.getClass().getClassLoader());
		
		bean.setMessage(b.getString("jolt.url"));
		return bean;
	}

}
