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
package br.com.navita.mobile.console.service;

import br.com.navita.mobile.console.domain.Operation;
import br.com.navita.mobile.console.exception.EntityNotFoundException;

public interface BaseOperationService<T extends Operation> {
	T findById(String id) throws EntityNotFoundException;
	void remove(String id) throws EntityNotFoundException;
	boolean isTagUniqueForConnector(String tag,String connectorId)throws EntityNotFoundException;
	boolean isTagUniqueForIdAndConnector(String tag,String operationId, String connectorId)throws EntityNotFoundException;
	T findByTagAndConnectorId(String connectorId, String operationTag);
}
