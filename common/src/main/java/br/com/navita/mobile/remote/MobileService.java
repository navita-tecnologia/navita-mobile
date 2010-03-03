package br.com.navita.mobile.remote;

import java.io.Serializable;
import java.util.Map;

import br.com.navita.mobile.domain.MobileBean;


public interface MobileService extends Serializable{
	MobileBean execute(Map<String,Object> params);
}
