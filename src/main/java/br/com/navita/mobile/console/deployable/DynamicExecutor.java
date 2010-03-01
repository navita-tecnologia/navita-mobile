package br.com.navita.mobile.console.deployable;

import java.io.Serializable;
import java.util.Map;

import br.com.navita.mobile.console.domain.MobileBean;


public interface DynamicExecutor extends Serializable{
	MobileBean execute(Map<String,Object> params);
}
