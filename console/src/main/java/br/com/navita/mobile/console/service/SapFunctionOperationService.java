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

import br.com.navita.mobile.console.domain.SapFunctionOperation;
import br.com.navita.mobile.console.domain.SapTable;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.view.rawdata.SapFunctionOperationRaw;

public interface SapFunctionOperationService extends OperationService<SapFunctionOperation, SapFunctionOperationRaw> {
	
	void addInputParameter(SapFunctionOperationRaw raw) throws EntityNotFoundException;
	void addOutputParameter(SapFunctionOperationRaw raw) throws EntityNotFoundException;	
	void removeInputParameter(SapFunctionOperationRaw raw) throws EntityNotFoundException;
	void removeOutputParameter(SapFunctionOperationRaw raw) throws EntityNotFoundException;
	
	SapTable findTableById(String id) throws EntityNotFoundException;	
	void addInputTable(SapFunctionOperationRaw raw) throws EntityNotFoundException;
	void addOutputTable(SapFunctionOperationRaw raw)throws EntityNotFoundException;
	void updateTable(SapFunctionOperationRaw raw) throws EntityNotFoundException;
	void removeInputTable(SapFunctionOperationRaw raw) throws EntityNotFoundException;
	void removeOutputTable(SapFunctionOperationRaw raw) throws EntityNotFoundException;
	void saveTable(SapFunctionOperationRaw raw)throws EntityNotFoundException;
	
	void addTableRow(SapFunctionOperationRaw rRaw) throws EntityNotFoundException;
	void removeTableRow(SapFunctionOperationRaw raw) throws EntityNotFoundException;
	void addSapTableField(SapFunctionOperationRaw raw) throws EntityNotFoundException;
	void removeSapTableField(SapFunctionOperationRaw raw) throws EntityNotFoundException;
	
	
}
