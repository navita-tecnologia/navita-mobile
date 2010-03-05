package br.com.navita.mobile.duke;

import java.io.Serializable;
import java.util.Map;

import javax.ejb.Stateless;

import br.com.navita.mobile.domain.MobileBean;
import br.com.navita.mobile.exception.ServiceNotFoundException;
import br.com.navita.mobile.ps.LoginPeopleSoft;
import br.com.navita.mobile.ps.PeopleServiceTest;
import br.com.navita.mobile.remote.EjbServiceFactory;
import br.com.navita.mobile.remote.EjbServiceFactoryLocal;
import br.com.navita.mobile.remote.MobileService;

@Stateless(mappedName="ejb/PeopleSoftFactory")
public class EjbServiceFactoryImpl implements EjbServiceFactory, EjbServiceFactoryLocal, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public MobileService getServiceByName(String name)	throws ServiceNotFoundException {
		
		if("login".equals(name)){
			return new LoginPeopleSoft();
		}
		
		if("teste".equals(name)){
			return new PeopleServiceTest();
		}
		if("foo".equals(name)){
			return new MobileService(){
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
				public MobileBean execute(Map<String, Object> params) {
					MobileBean bean = new MobileBean();
					bean.setMessage("Foo Fake message");
					return bean;
				}
			};
		}
		
		throw new ServiceNotFoundException(name + " nao existe neste servico");
	
	}

}
