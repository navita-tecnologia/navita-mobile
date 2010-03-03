package br.com.navita.mobile.ps;

import javax.ejb.Stateless;

import br.com.navita.mobile.exception.ServiceNotFoundException;
import br.com.navita.mobile.remote.EjbServiceFactory;
import br.com.navita.mobile.remote.EjbServiceFactoryLocal;
import br.com.navita.mobile.remote.MobileService;

@Stateless(mappedName="ejb/PeopleSoftFactory")
public class EjbServiceFactoryImpl implements EjbServiceFactory, EjbServiceFactoryLocal {

	@Override
	public MobileService getServiceByName(String name)	throws ServiceNotFoundException {
		
		if("login".equals(name)){
			return new LoginPeopleSoft();
		}
		
		if("teste".equals(name)){
			return new TestePeople();
		}
		
		throw new ServiceNotFoundException(name + " nao existe neste servico");
	
	}

}
