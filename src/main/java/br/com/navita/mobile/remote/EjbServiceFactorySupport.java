package br.com.navita.mobile.remote;

import java.util.Map;

import br.com.navita.mobile.domain.MobileBean;
import br.com.navita.mobile.exception.ServiceNotFoundException;

public class EjbServiceFactorySupport implements EjbServiceFactory, EjbServiceFactoryLocal{

	@Override
	public MobileService getServiceByName(String name)	throws ServiceNotFoundException {
		
		return new MobileService(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public MobileBean execute(Map<String, Object> params) {
				MobileBean bean =  new MobileBean();
				bean.setMessage("Default bean message");
				bean.setObject(new Object[]{"v1","v2"});
				bean.setToken("sample-token-value");
				return bean;
			}
		};
	}

}
