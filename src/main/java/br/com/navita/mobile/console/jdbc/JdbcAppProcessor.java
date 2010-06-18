package br.com.navita.mobile.console.jdbc;

import java.util.Map;

import br.com.navita.mobile.console.BaseMobileAppProcessor;
import br.com.navita.mobile.console.domain.MobileApplication;
import br.com.navita.mobile.domain.MobileBean;

public class JdbcAppProcessor extends BaseMobileAppProcessor {

	@Override
	public MobileBean processApplication(MobileApplication mobApp,
			String operation, Map<String, Object> processedParams)
			throws Exception {
		
		return null;
	}

	@Override
	protected String getProcessorUrlPrefix() {
		
		return "jdbc";
	}

}
