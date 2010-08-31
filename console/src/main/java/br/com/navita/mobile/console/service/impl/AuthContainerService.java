package br.com.navita.mobile.console.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import br.com.navita.mobile.console.EncryptionAware;
import br.com.navita.mobile.console.dao.jpa.GenericRepository;
import br.com.navita.mobile.console.domain.entity.AdAuthContainer;
import br.com.navita.mobile.console.domain.entity.AuthContainer;
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
