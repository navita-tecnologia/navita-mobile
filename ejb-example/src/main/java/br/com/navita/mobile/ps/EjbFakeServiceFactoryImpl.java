package br.com.navita.mobile.ps;

import javax.ejb.Stateless;

import br.com.lele.ClasseQualquer;
import br.com.navita.mobile.exception.ServiceNotFoundException;
import br.com.navita.mobile.remote.EjbServiceFactory;
import br.com.navita.mobile.remote.EjbServiceFactoryLocal;
import br.com.navita.mobile.remote.MobileService;

@Stateless(mappedName="ejb/FakeFactory")
public class EjbFakeServiceFactoryImpl implements EjbServiceFactory, EjbServiceFactoryLocal{

	@Override
	public MobileService getServiceByName(String name)
			throws ServiceNotFoundException {
		
		return new ClasseQualquer();
	}

}
