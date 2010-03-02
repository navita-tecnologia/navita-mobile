package br.com.navita.mobile.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

import br.com.navita.mobile.exception.ServiceNotFoundException;



public interface ServiceFactory extends Remote{
	MobileService getServiceByName(String name) throws ServiceNotFoundException,RemoteException;
}
