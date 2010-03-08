package br.com.navita.mobile;

import java.util.ResourceBundle;

public interface AppResources {

	ResourceBundle BUNDLE = ResourceBundle.getBundle("ejb-duke");
	
	String PEOPLE_JOLT_URL = BUNDLE.getString("ps.jolt.url");
	String AUTOMIDIA_WS = BUNDLE.getString("automidia.webservice.url");
	Boolean DUMP_AUTOMDIA_IO = "true".equalsIgnoreCase( BUNDLE.getString("automidia.dump.io"));
}
