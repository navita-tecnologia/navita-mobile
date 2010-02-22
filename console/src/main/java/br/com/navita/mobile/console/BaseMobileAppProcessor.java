package br.com.navita.mobile.console;

import br.com.navita.mobile.console.domain.MobileApplication;
import br.com.navita.mobile.console.domain.MobileApplicationExecutor;

public abstract class BaseMobileAppProcessor implements MobileAppProcessor{

	protected final MobileApplicationExecutor findOperationExecutor(MobileApplication mobApp, String operation){
		for(MobileApplicationExecutor exec : mobApp.getExecutors()){
			if(operation.equals(exec.getName())){
				return exec;
			}
		}
		return null;
	}
}
