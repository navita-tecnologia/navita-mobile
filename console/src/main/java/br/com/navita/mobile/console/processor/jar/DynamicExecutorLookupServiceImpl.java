package br.com.navita.mobile.console.processor.jar;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.navita.mobile.remote.MobileService;


public class DynamicExecutorLookupServiceImpl implements DynamicExecutorLookupService {
	private static final Logger LOG = Logger.getLogger(DynamicExecutorLookupServiceImpl.class.getName());
	public static final Map<String,Class<?>> DEPLOY_MAP =Collections.synchronizedMap( new TreeMap<String, Class<?>>()); 
	
			
	@Override
	public MobileService findInstance(String jarName, String className) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {
		LOG.log(Level.INFO,"Looking up " + className);					
		return lookup(jarName, className);
	}
	
	private MobileService lookup(String jarName, String className) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		String key = jarName + className;
		Class<?> clazz = DEPLOY_MAP.get(key);
		if(clazz != null){
			LOG.log(Level.INFO,"Class cache found " + className);			
		} else{		
			clazz = load(jarName, className);
		}
		
		return (MobileService) clazz.newInstance();
		
	}
	
	public static Class<?> load(String jarName, String className) throws IOException, ClassNotFoundException {
		LOG.log(Level.INFO,"Loading " + className + " from " + jarName);
		String key = jarName + className;
		ZipClassLoader loader = new ZipClassLoader(jarName,Thread.currentThread().getContextClassLoader()); 
		Class<?> cls = loader.findClass(className);		
		DEPLOY_MAP.put(key, cls);
		return cls;
	}

}
