package br.com.navita.mobile.console.dao;

import java.util.List;

import br.com.navita.mobile.console.domain.PushServer;

public interface PushServerRepository<T extends PushServer> extends GenericRepository<T> {

	List<T> listPushServerByAppId(String appId);
	
	PushServer findByTag(String tag);
}
