package br.com.navita.test;

import java.rmi.RemoteException;
import java.security.Permission;

import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import br.com.navita.mobile.exception.ServiceNotFoundException;
import br.com.navita.mobile.remote.ServiceFactory;


public class RmiClientTest {

	/**
	 * @param args
	 * @throws RemoteException 
	 * @throws ServiceNotFoundException 
	 */
	public static void main(String[] args) throws ServiceNotFoundException, RemoteException {	
		System.setSecurityManager(new SecurityManager(){			
			public void checkPermission(Permission perm) {}
			public void checkPermission(Permission perm, Object context) {} 
		});
		RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
		rmiProxyFactoryBean.setServiceInterface(ServiceFactory.class);
		rmiProxyFactoryBean.setServiceUrl("rmi://127.0.0.1:1199/FactoryService");
		rmiProxyFactoryBean.afterPropertiesSet();
		System.out.println(((ServiceFactory)rmiProxyFactoryBean.getObject()).getServiceByName("login"));
		
	}

}
