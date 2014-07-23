package br.com.navita.mobile.console.service;

import java.util.List;

import br.com.navita.mobile.console.domain.PushServer;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.view.rawdata.PushServerRaw;

public interface PushServerService {

	PushServer findById(String id) throws EntityNotFoundException;

	List<PushServer> listbyApplicationId(String appId);

	PushServer create(PushServerRaw pushServersAction) throws EntityNotFoundException;

	PushServer save(PushServerRaw pushServersAction) throws EntityNotFoundException;

	void remove(String id) throws EntityNotFoundException;

	PushServer findByTag(String applicationId);
}
