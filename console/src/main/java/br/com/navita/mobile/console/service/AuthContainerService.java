package br.com.navita.mobile.console.service;

import java.util.List;

import br.com.navita.mobile.console.domain.entity.AdAuthContainer;
import br.com.navita.mobile.console.domain.entity.AuthContainer;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.view.rawdata.AdAuthContainerRaw;

public interface AuthContainerService {

	AuthContainer findbyId(String authContainerId) throws EntityNotFoundException;
	List<AuthContainer> listAll();
	
	AdAuthContainer insertAD(AdAuthContainerRaw raw);
	AdAuthContainer saveAD(AdAuthContainerRaw raw) throws EntityNotFoundException;	
	void remove(AdAuthContainerRaw raw) throws EntityNotFoundException;

}
