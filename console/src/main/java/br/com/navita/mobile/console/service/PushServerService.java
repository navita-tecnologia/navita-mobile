package br.com.navita.mobile.console.service;

import java.util.List;

import br.com.navita.mobile.console.domain.PushServer;
import br.com.navita.mobile.console.exception.EntityNotFoundException;

public interface PushServerService {

	PushServer findById(String id) throws EntityNotFoundException;

	List<PushServer> listbyApplicationId(String appId);
}
