package br.com.navita.mobile.console.deployable;

import java.util.Map;

import br.com.navita.mobile.console.BaseMobileAppProcessor;
import br.com.navita.mobile.console.domain.MobileApplication;
import br.com.navita.mobile.console.domain.MobileApplicationExecutor;
import br.com.navita.mobile.console.domain.MobileBean;
import br.com.navita.mobile.console.exception.OperationNotFoundException;

public class DeployableProcessor extends BaseMobileAppProcessor {
	private DynamicExecutorLookupService dynamicExecutorLookupService;
	public void setDynamicExecutorLookupService(
			DynamicExecutorLookupService dynamicExecutorLookupService) {
		this.dynamicExecutorLookupService = dynamicExecutorLookupService;
	}
	

	@Override
	public MobileBean processApplication(MobileApplication mobApp,
			String operation, Map<String, Object> processedParams)
			throws Exception {
		
		
		MobileApplicationExecutor exec = findOperationExecutor(mobApp, operation);
		if(exec == null){
			throw new OperationNotFoundException(operation);
		}
		String jarName = mobApp.getUrl().substring("jar://".length());
		String className = exec.getClassName();
		DynamicExecutor executor = dynamicExecutorLookupService.findInstance(jarName, className);
		if(executor == null){
			throw new OperationNotFoundException(jarName + " : "+className);
		}
		return executor.execute(processedParams);
	}

}
