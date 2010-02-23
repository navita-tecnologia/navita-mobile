package br.com.navita.mobile.console.deployable;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DynamicExecutorLookupServiceImpl implements DynamicExecutorLookupService {
	private static final Logger LOG = Logger.getLogger(DynamicExecutorLookupServiceImpl.class.getName());
	public static final Map<String,Class<?>> DEPLOY_MAP =Collections.synchronizedMap( new TreeMap<String, Class<?>>()); 
	
			
	@Override
	public DynamicExecutor findInstance(String jarName, String className) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {
		LOG.log(Level.WARNING,"Looking up " + className);					
		return lookup(jarName, className);
	}
	
	private DynamicExecutor lookup(String jarName, String className) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		String key = jarName + className;
		Class<?> clazz = DEPLOY_MAP.get(key);
		if(clazz != null){
			LOG.log(Level.WARNING,"Class cache found " + className);			
		} else{		
			clazz = load(jarName, className);
		}
		
		return (DynamicExecutor) clazz.newInstance();
		
	}
	
	public static Class<?> load(String jarName, String className) throws IOException, ClassNotFoundException {
		LOG.log(Level.WARNING,"Loading " + className + " from " + jarName);
		String key = jarName + className;
		ZipClassLoader loader = new ZipClassLoader(jarName,Thread.currentThread().getContextClassLoader()); 
		Class<?> cls = loader.findClass(className);		
		DEPLOY_MAP.put(key, cls);
		return cls;
	}

}
