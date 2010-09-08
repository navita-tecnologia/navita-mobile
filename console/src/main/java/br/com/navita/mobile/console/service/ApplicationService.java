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
