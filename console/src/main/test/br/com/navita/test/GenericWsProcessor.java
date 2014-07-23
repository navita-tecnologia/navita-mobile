/*
 * Copyright 2014 Navita Tecnologia.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
