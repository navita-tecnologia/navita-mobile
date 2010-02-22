package br.com.navita.mobile.console.deployable;

import java.util.Map;

import br.com.navita.mobile.console.domain.MobileBean;

public interface DynamicExecutor {
	MobileBean execute(Map<String,Object> params);
}
