package br.com.navita.mobile.console.legacy.processor.jar;

import java.io.IOException;

import br.com.navita.mobile.remote.MobileService;

public interface DynamicExecutorLookupService {

	MobileService findInstance(String jarName, String className) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException;
}
