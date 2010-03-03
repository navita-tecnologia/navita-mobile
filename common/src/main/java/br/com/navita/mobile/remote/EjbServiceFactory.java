package br.com.navita.mobile.remote;



import javax.ejb.Remote;

import br.com.navita.mobile.exception.ServiceNotFoundException;

@Remote
public interface EjbServiceFactory {
	MobileService getServiceByName(String name) throws ServiceNotFoundException;
}
