package br.com.navita.mobile.console;

import java.util.HashMap;
import java.util.Map;

import br.com.navita.mobile.console.domain.MobileApplication;
import br.com.navita.mobile.console.domain.MobileApplicationExecutor;

public abstract class BaseMobileAppProcessor implements MobileAppProcessor{

	protected String mappedName;
	protected Map<String, String> urlProperties;
	
	public BaseMobileAppProcessor() {
		
	}
	
	
	protected final void resolveProperties(MobileApplication mobApp) {
		mappedName = mobApp.getUrl().substring((getProcessorUrlPrefix()+ "://").length());
		int queryStringStart = mappedName.indexOf('?');
		urlProperties = new HashMap<String, String>();
		if(queryStringStart> -1 ){
			String[] pairs = mappedName.substring(queryStringStart + 1).split("&");
			for(String pair:pairs){
				String[] values = pair.split("=");
				urlProperties.put(values[0], values[1]);
			}
			mappedName = mappedName.substring(0,queryStringStart);				 
		}
	}
	
	
	protected abstract String getProcessorUrlPrefix();


	protected final MobileApplicationExecutor findOperationExecutor(MobileApplication mobApp, String operation){
		for(MobileApplicationExecutor exec : mobApp.getExecutors()){
			if(operation.equals(exec.getName())){
				return exec;
			}
		}
		return null;
	}
}
