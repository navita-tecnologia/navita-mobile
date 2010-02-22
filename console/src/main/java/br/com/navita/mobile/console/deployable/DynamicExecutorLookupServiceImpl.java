package br.com.navita.mobile.console.deployable;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DynamicExecutorLookupServiceImpl implements DynamicExecutorLookupService {
	private static final Logger LOG = Logger.getLogger(DynamicExecutorLookupServiceImpl.class.getName());
	public static final Map<String,DynamicExecutor> DEPLOY_MAP = new TreeMap<String, DynamicExecutor>(); 
	
	private DeployListener deployListener;
	
	public void setDeployListener(DeployListener deployListener) {
		this.deployListener = deployListener;
	}
	
	@Override
	public DynamicExecutor findInstance(String jarName, String className) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {
		LOG.log(Level.WARNING,"Looking up " + className);					
		return lookup(jarName, className);
	}
	
	private DynamicExecutor lookup(String jarName, String className) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		String key = jarName + className;
		DynamicExecutor o = DEPLOY_MAP.get(key);
		if(o != null){
			LOG.log(Level.WARNING,"Cache found " + className);
			return o;
		}		
		o = load(jarName, className);		
		deployListener.register(jarName, className);
		return o;
		
	}
	
	public static DynamicExecutor load(String jarName, String className) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		LOG.log(Level.WARNING,"Loading " + className + " from " + jarName);
		String key = jarName + className;
		ZipClassLoader loader = new ZipClassLoader(jarName,Thread.currentThread().getContextClassLoader()); 
		Class<?> cls = loader.findClass(className);		
		DynamicExecutor o = (DynamicExecutor) cls.newInstance();
		DEPLOY_MAP.put(key, o);
		return o;
	}

}
