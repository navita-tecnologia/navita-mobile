package br.com.navita.mobile.remote;



import javax.ejb.Remote;

import br.com.navita.mobile.exception.ServiceNotFoundException;

/**
 * 
 * @author mpguedes
 *
 */
@Remote
public interface EjbServiceFactory {
	/**
	 * 
	 * @param name
	 * @return
	 * @throws ServiceNotFoundException
	 */
	MobileService getServiceByName(String name) throws ServiceNotFoundException;
}
