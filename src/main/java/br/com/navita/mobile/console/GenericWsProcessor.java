package br.com.navita.mobile.console;

import java.net.URL;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.navita.mobile.console.domain.MobileApplication;
import br.com.navita.mobile.console.domain.MobileBean;
import br.com.navita.mobile.ws.client.DynamicClient;

public class GenericWsProcessor implements MobileAppProcessor {

	@Override
	public MobileBean processApplication(MobileApplication mobApp,
			String operation, Map<String, Object> processedParams)
			throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		DynamicClient dynamicClient = (DynamicClient) ctx.getBean("dynaClient",new Object[]{new URL( mobApp.getUrl() + DynamicClient.wsPart)});
		return dynamicClient.execute(normalizeWsInput(operation,processedParams));
	}
	
	private MobileBean normalizeWsInput(String operation, Map<String, Object> params) {
		MobileBean bean = new MobileBean();		
		
//		List<NameValue> worker = bean.getObject();	
//		NameValue nv = null;
//		for(Iterator<?> it = params.keySet().iterator();it.hasNext();){
//			String key = it.next().toString();
//			nv = new NameValue();
//			nv.setName(key);
//			nv.setValue(params.get(key));
//			worker.add(nv);
//		}		
//		nv = new NameValue();
//		nv.setName("operation");
//		nv.setValue(operation);
//		worker.add(nv);
		
		return bean;
	}
}
