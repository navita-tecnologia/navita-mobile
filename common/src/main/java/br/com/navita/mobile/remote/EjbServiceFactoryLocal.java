package br.com.navita.mobile.remote;

import br.com.navita.mobile.exception.ServiceNotFoundException;

/**
 * 
 * @author mpguedes
 *
 */
public interface EjbServiceFactoryLocal {
	/**
	 * 
	 * @param name
	 * @return
	 * @throws ServiceNotFoundException
	 */
	MobileService getServiceByName(String name) throws ServiceNotFoundException;
}
