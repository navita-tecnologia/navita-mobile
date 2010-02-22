package br.com.lele;
import java.util.Date;
import java.util.Map;

import br.com.navita.mobile.console.deployable.DynamicExecutor;
import br.com.navita.mobile.console.domain.MobileBean;


public class ClasseQualquer implements DynamicExecutor {

	@Override
	public MobileBean execute(Map<String, Object> params) {
		MobileBean bean = new MobileBean();
		bean.setObject(new Date());
		return bean;
	}

}
