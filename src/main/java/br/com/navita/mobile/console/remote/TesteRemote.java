package br.com.navita.mobile.console.remote;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import br.com.navita.mobile.exception.ServiceNotFoundException;
import br.com.navita.mobile.remote.ServiceFactory;

public class TesteRemote {
	private ServiceFactory serviceFactory;
	
	public void setServiceFactory(ServiceFactory serviceFactory) {
		this.serviceFactory = serviceFactory;
	}
	
	public void test() throws ServiceNotFoundException, RemoteException{
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(serviceFactory.getServiceByName("login").execute(map).getMessage());
	}
}
