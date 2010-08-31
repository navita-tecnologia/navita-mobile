package br.com.navita.mobile.console.service;

import br.com.navita.mobile.console.dao.jpa.BesServer;

public interface BesPushService {

	BesServer getBesServer(String applicationId);

}
