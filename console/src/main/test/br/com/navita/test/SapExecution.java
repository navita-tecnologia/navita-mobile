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
package br.com.navita.test;

import java.util.Map;

import br.com.navita.mobile.console.exception.SapGatewayException;
import br.com.navita.mobile.domain.MobileBean;

public abstract class SapExecution {
	protected SapExecutionConfig config;
	public void setConfig(SapExecutionConfig config) {
		this.config = config;
	}
	
	protected abstract MobileBean execute( Map<String, Object> params) throws SapGatewayException;
	
}
