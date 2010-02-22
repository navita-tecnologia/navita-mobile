package br.com.navita.mobile.console.deployable;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.jci.listeners.FileChangeListener;
import org.apache.commons.jci.monitor.FilesystemAlterationListener;
import org.apache.commons.jci.monitor.FilesystemAlterationMonitor;

public class DeployListener {
	
	private static final FilesystemAlterationMonitor FAM = new FilesystemAlterationMonitor();	
	private static final Logger LOG = Logger.getLogger(DeployListener.class.getName());
	
	static{
		FAM.start();
	}
	
	public void register(String jarName, String className){
		FilesystemAlterationListener lst = getListener(className);		
		FAM.addListener(new File(jarName), lst);		
	}	

	private FilesystemAlterationListener getListener(final String className){

		FilesystemAlterationListener listener = new FileChangeListener(){

			@Override
			public void onFileChange(File file) {
				try {
					LOG.log(Level.WARNING,"Reloading " + className + " from " + file.getAbsolutePath());
					DynamicExecutorLookupServiceImpl.load(file.getAbsolutePath(), className);
				} catch (Exception e) {					
					e.printStackTrace();
				} 
				super.onFileChange(file);
			}


		};
		return listener;
	}
}
