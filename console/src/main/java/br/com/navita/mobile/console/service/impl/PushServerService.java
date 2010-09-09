package br.com.navita.mobile.console.service.impl;

import java.util.List;

import br.com.navita.mobile.console.dao.PushServerRepository;
import br.com.navita.mobile.console.domain.PushServer;
import br.com.navita.mobile.console.exception.EntityNotFoundException;

public class PushServerService implements br.com.navita.mobile.console.service.PushServerService {

	private PushServerRepository<PushServer> pushServerRepository;
	
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
	
	

}
