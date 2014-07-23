package br.com.navita.mobile.console.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import br.com.navita.mobile.console.dao.PushServerRepository;
import br.com.navita.mobile.console.domain.Application;
import br.com.navita.mobile.console.domain.PushServer;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.service.ApplicationService;
import br.com.navita.mobile.console.view.rawdata.PushServerRaw;

@Transactional
public class PushServerService implements br.com.navita.mobile.console.service.PushServerService {

	private PushServerRepository<PushServer> pushServerRepository;
	private ApplicationService applicationService;
	
	public void setApplicationService(ApplicationService applicationService) {
		this.applicationService = applicationService;
	}
	
	public void setPushServerRepository(
			PushServerRepository<PushServer> pushServerRepository) {
		this.pushServerRepository = pushServerRepository;
	}
	
	@Override
	public PushServer findById(String id) throws EntityNotFoundException {		
		return pushServerRepository.findById(id);
	}

	@Override
	public List<PushServer> listbyApplicationId(String appId) {		
		return pushServerRepository.listPushServerByAppId(appId);
	}

	@Override
	public PushServer create(PushServerRaw raw) throws EntityNotFoundException {
		PushServer entity = new PushServer();
		fillEntityWithRaw(entity,raw);
		pushServerRepository.persist(entity);
		return entity;
	}

	private void fillEntityWithRaw(PushServer entity, PushServerRaw raw) throws EntityNotFoundException {
		entity.setName(raw.getName());
		entity.setPort(raw.getPort());
		entity.setUrl(raw.getUrl());
		entity.setTag(raw.getTag());
		Application app  = applicationService.findbyId(raw.getApplicationId());
		entity.setApplication(app);
		
	}

	@Override
	public void remove(String id) throws EntityNotFoundException {
		PushServer pushServer = pushServerRepository.findById(id);
		pushServerRepository.remove(pushServer);
		
	}

	@Override
	public PushServer save(PushServerRaw raw) throws EntityNotFoundException {
		PushServer pushServer = pushServerRepository.findById(raw.getId());
		fillEntityWithRaw(pushServer,raw);
		return pushServer;
	}

	@Override
	public PushServer findByTag(String applicationId) {
		
		return pushServerRepository.findByTag(applicationId);
	}
	
	

}
