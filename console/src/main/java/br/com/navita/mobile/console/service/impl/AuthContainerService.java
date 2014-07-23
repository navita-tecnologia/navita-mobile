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
package br.com.navita.mobile.console.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import br.com.navita.mobile.console.EncryptionAware;
import br.com.navita.mobile.console.dao.GenericRepository;
import br.com.navita.mobile.console.domain.AdAuthContainer;
import br.com.navita.mobile.console.domain.AuthContainer;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.util.Encryptor;
import br.com.navita.mobile.console.view.rawdata.AdAuthContainerRaw;

@Transactional
public class AuthContainerService implements br.com.navita.mobile.console.service.AuthContainerService, EncryptionAware{

	private GenericRepository<AuthContainer> authContainerRepository;
	
	public void setAuthContainerRepository(
			GenericRepository<AuthContainer> authContainerRepository) {
		this.authContainerRepository = authContainerRepository;
	}
	
	
	@Override
	public AuthContainer findbyId(String authContainerId) throws EntityNotFoundException {		
		return authContainerRepository.findById(authContainerId);
	}


	@Override
	public List<AuthContainer> listAll() {		
		return authContainerRepository.findAll();
	}


	@Override
	public AdAuthContainer insertAD(AdAuthContainerRaw raw) {
		AdAuthContainer ad = new AdAuthContainer();
		fillContainer(ad,raw);
		authContainerRepository.persist(ad);
		return ad;
	}
	
	


	private void fillContainer(AdAuthContainer ad, AdAuthContainerRaw raw) {
		ad.setDnsResolving(raw.isDnsResolving());
		ad.setDomainName(raw.getDomainName());
		ad.setDomainUser(raw.getDomainUser());
		if(raw.getDomainUserPassword() != null && ! raw.getDomainUserPassword().isEmpty())
		try {
			ad.setDomainUserPassword(Encryptor.encrypt(raw.getDomainUserPassword(),PRIVATE_KEY));
		} catch (Exception e) {
			
		}
		ad.setGroupAttribute(raw.getGroupAttribute());
		ad.setGroupFilter(raw.getGroupFilter());
		ad.setIp(raw.getIp());
		ad.setName(raw.getName());
		ad.setSearchBase(raw.getSearchBase());
		ad.setSearchFilter(raw.getSearchFilter());
		ad.setUrl(raw.getUrl());
		
	}


	@Override
	public AdAuthContainer saveAD(AdAuthContainerRaw raw) throws EntityNotFoundException {
		AdAuthContainer ad = (AdAuthContainer) findbyId(raw.getId());
		fillContainer(ad, raw);	
		return ad;
	}


	@Override
	public void remove(AdAuthContainerRaw raw) throws EntityNotFoundException {
		AdAuthContainer ad = (AdAuthContainer) findbyId(raw.getId());
		authContainerRepository.remove(ad);
		
	}

}
