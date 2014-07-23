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
package br.com.navita.mobile.console.operator.sap;

import br.com.navita.mobile.console.session.MobileSession;

import com.sap.mw.jco.JCO;

public class SapSession extends MobileSession {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JCO.Repository repository;




	public JCO.Repository getRepository() {
		return repository;
	}



	public void setRepository(JCO.Repository repository) {
		this.repository = repository;
	}



	public SapSession(JCO.Repository repository, String token) {
		this.repository = repository;
		this.token = token;
	}


	@Override
	public void release() {
		JCO.removeClientPool(token);				
	}



	@Override
	public long getTimeout() {		
		return QUINZE_MINUTOS;
	}


}
