package br.com.navita.mobile.remote;

import java.io.Serializable;
import java.util.Map;

import br.com.navita.mobile.domain.MobileBean;


/**
 * 
 * @author mpguedes
 *
 */
public interface MobileService extends Serializable{
	/**
	 * 
	 * @param params
	 * @return
	 */
	MobileBean execute(Map<String,Object> params);
}
