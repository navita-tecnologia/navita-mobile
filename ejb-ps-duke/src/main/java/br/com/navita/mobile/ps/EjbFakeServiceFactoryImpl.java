package br.com.navita.mobile.ps;

import javax.ejb.Stateless;

import br.com.lele.ClasseQualquer;
import br.com.navita.mobile.exception.ServiceNotFoundException;
import br.com.navita.mobile.remote.EjbServiceFactorySupport;
import br.com.navita.mobile.remote.MobileService;

@Stateless(mappedName="ejb/FakeFactory")
public class EjbFakeServiceFactoryImpl extends EjbServiceFactorySupport{

	@Override
	public MobileService getServiceByName(String name) throws ServiceNotFoundException {
		if("super".equals(name)){
			return super.getServiceByName(name);
		}
		
		return new ClasseQualquer();
	}

}
