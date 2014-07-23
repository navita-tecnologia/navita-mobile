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

import java.util.List;

import br.com.navita.mobile.console.domain.Application;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.view.rawdata.ApplicationRaw;

public interface ApplicationService {

	Application findbyId(String id) throws EntityNotFoundException;
	List<Application> findAll();
	Application create(ApplicationRaw raw) throws EntityNotFoundException;
	Application save(ApplicationRaw raw) throws EntityNotFoundException;
	void remove(String id) throws EntityNotFoundException;
}
