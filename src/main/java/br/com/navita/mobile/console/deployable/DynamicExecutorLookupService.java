package br.com.navita.mobile.console.deployable;

import java.io.IOException;

public interface DynamicExecutorLookupService {

	DynamicExecutor findInstance(String jarName, String className) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException;
}
