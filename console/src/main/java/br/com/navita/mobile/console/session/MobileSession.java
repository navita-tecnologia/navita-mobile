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
package br.com.navita.mobile.console.session;
import java.io.Serializable;


public abstract class MobileSession implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected long UM_SEGUNDO = 1000L;
	protected long UM_MINUTO = 60L * UM_SEGUNDO;
	protected long QUINZE_MINUTOS = 15L * UM_MINUTO;
	
	protected String token;
	protected long timeStamp;
	protected Object innerSession;
	
	protected enum Type{
		SAP_SESSION,
		PEOPLE_SOFT_SESSION
	}
	
	public Object getInnerSession() {
		return innerSession;
	}

	public void setInnerSession(Object innerSession) {
		this.innerSession = innerSession;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	/**
	 * encerra a sessao liberando os recursos
	 */
	public abstract void release();
	
	/**
	 * Inatividade maxima permitida para esta sessao
	 * @return
	 */
	public abstract long getTimeout();
	
	
}
