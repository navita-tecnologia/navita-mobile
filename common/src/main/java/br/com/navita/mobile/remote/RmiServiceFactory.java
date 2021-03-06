/*
 * Copyright 2014 Navita Tecnologia.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
