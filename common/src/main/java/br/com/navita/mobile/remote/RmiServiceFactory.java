package br.com.navita.mobile.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

import br.com.navita.mobile.exception.ServiceNotFoundException;



/**
 * 
 * @author mpguedes
 *
 */
public interface RmiServiceFactory extends Remote{
	/**
	 * 
	 * @param name
	 * @return
	 * @throws ServiceNotFoundException
	 * @throws RemoteException
	 */
	MobileService getServiceByName(String name) throws ServiceNotFoundException,RemoteException;
}
