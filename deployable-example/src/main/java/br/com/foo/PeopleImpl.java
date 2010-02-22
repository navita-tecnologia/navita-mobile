package br.com.foo;

import java.util.Arrays;
import java.util.Map;

import br.com.navita.mobile.console.deployable.DynamicExecutor;
import br.com.navita.mobile.console.domain.MobileBean;

public class PeopleImpl implements DynamicExecutor {

	@Override
	public MobileBean execute(Map<String, Object> params) {
		CarlaoBean b = new CarlaoBean();
		b.setC1("campo1");
		b.setC2("campo 2");
		MobileBean bean = new MobileBean();
		bean.setObject(b);
		bean.setMessage("Deu certo");
		CarlaoBean x = new CarlaoBean();
		x.setC1("outro c1");
		bean.setList(Arrays.asList(new CarlaoBean(),x));
		return bean;
	}

}
