package br.com.navita.test;


public class GenericWsProcessor  {
//
//	@Override
//	public MobileBean processApplication(MobileApplication mobApp, String operation, Map<String, Object> processedParams) throws Exception {		
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//		String mappedName = mobApp.getUrl().substring("ws://".length());
//		DynamicClient dynamicClient = (DynamicClient) ctx.getBean("dynaClient",new Object[]{new URL( mappedName + DynamicClient.wsPart)});
//		return dynamicClient.execute(normalizeWsInput(operation,processedParams));
//	}
//	
//	private GenericBean normalizeWsInput(String operation, Map<String, Object> params) {
//		GenericBean bean = new GenericBean();		
//		
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
//		
//		return bean;
//	}
//
//	@Override
//	protected String getProcessorUrlPrefix() {
//		
//		return "ws";
//	}
}
