package br.com.lele;

import java.util.Map;

import br.com.navita.mobile.domain.MobileBean;
import br.com.navita.mobile.remote.MobileService;


public class ClasseQualquer implements MobileService {

	private static final long serialVersionUID = 1L;

	@Override
	public MobileBean execute(Map<String, Object> params) {
		MobileBean bean = new MobileBean();
		bean.setObject(new Object[]{"v1","v2",234});		
		return bean;
	}
	
	

}
