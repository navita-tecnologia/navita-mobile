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
package br.com.navita.mobile.console.dao;

import java.util.List;

import br.com.navita.mobile.console.domain.Operation;

public interface OperationRepository<T extends Operation> extends GenericRepository<Operation> {
	List<T> listConnectorOperations(String connectorId);	
	T findByTagAndConnectorId(String tag, String connectorId);
}
