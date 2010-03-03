package br.com.navita.mobile.ps;

import br.com.lele.ClasseQualquer;
import br.com.navita.mobile.exception.ServiceNotFoundException;
import br.com.navita.mobile.remote.MobileService;
import br.com.navita.mobile.remote.ServiceFactory;

public class ServiceFactoryImpl implements ServiceFactory {

	@Override
	public MobileService getServiceByName(String name) throws ServiceNotFoundException {
		if("login".equals(name)){
			return new LoginPeopleSoft();
		}
		
		if("teste".equals(name)){
			return new TestePeople();
		}
		
		if("fake".equals(name)){
			return new ClasseQualquer();
		}
		
		throw new ServiceNotFoundException(name + " nao existe neste servico");
	}

	

}
