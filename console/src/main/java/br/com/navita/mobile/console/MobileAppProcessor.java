package br.com.navita.mobile.console;

import java.util.Map;

import br.com.navita.mobile.console.domain.MobileApplication;
import br.com.navita.mobile.console.domain.MobileBean;


public interface MobileAppProcessor {
	MobileBean processApplication(MobileApplication mobApp,	String operation, Map<String, Object> processedParams) throws Exception;
}
