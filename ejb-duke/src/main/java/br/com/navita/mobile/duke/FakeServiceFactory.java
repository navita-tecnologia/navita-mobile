package br.com.navita.mobile.duke;

import java.io.Serializable;
import java.util.Map;

import javax.ejb.Stateless;

import br.com.navita.mobile.domain.MobileBean;
import br.com.navita.mobile.exception.ServiceNotFoundException;
import br.com.navita.mobile.remote.EjbServiceFactory;
import br.com.navita.mobile.remote.EjbServiceFactoryLocal;
import br.com.navita.mobile.remote.MobileService;

@Stateless(mappedName="ejb/FakeServiceFactory")
public class FakeServiceFactory implements EjbServiceFactory, EjbServiceFactoryLocal, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public MobileService getServiceByName(String name)
			throws ServiceNotFoundException {
		
		return new MobileService(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public MobileBean execute(Map<String, Object> params) {
				MobileBean bean = new MobileBean();
				bean.setMessage("Fake message");
				return bean;
			}
		};
	}

}
