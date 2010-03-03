package br.com.navita.mobile.remote;

import br.com.navita.mobile.exception.ServiceNotFoundException;

public interface EjbServiceFactoryLocal {
	MobileService getServiceByName(String name) throws ServiceNotFoundException;
}
