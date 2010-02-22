package br.com.navita.mobile.console.dao;

import java.util.List;

import br.com.navita.mobile.console.domain.MobileApplication;
import br.com.navita.mobile.console.domain.MobileApplicationExecutor;

/**
 * 
 * @author mpguedes
 *
 */
public interface MobileApplicationDAO {

	MobileApplication findById(String id);
	List<MobileApplication> listAll();
	void save(MobileApplication mobileApplication);
	void create(MobileApplication mobileApplication);
	void delete(MobileApplication mobileApplication);
	
	void appendExecutor(String name, String className, String configuration, String mobileId);
	void saveExecutor(String name, String className, String configuration, String mobileId);
	void removeExecutor(String name, String mobileId);	
	List<MobileApplicationExecutor> listExecutors(String mobileId);
	
	
}
