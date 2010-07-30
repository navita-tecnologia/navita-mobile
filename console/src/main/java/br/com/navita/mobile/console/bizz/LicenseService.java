package br.com.navita.mobile.console.bizz;

import java.util.List;

import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.model.LicenseBundle;
import br.com.navita.mobile.console.model.LicenseBundleType;
import br.com.navita.mobile.console.model.LicenseActivation;

public interface LicenseService {
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	List<LicenseBundle> listBundle();
	
	/**
	 * 
	 * @param model
	 * @return
	 * @throws EntityNotFoundException 
	 */
	LicenseBundle getBundle(String id) throws EntityNotFoundException;
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	LicenseBundle insertBundle(LicenseBundle bundle);
	
	/**
	 * 
	 * @param model
	 */
	void deleteBundle(LicenseBundle bundle);
	
	/**
	 * 
	 * @param model
	 */
	void updateBundle(LicenseBundle bundle);

	/**
	 * 
	 * @return
	 */
	List<LicenseBundleType> listBundleTypes();

	/**
	 * 
	 * @param use
	 * @throws EntityNotFoundException 
	 */
	void insertLicenseUse(LicenseActivation use,String bundleId) throws EntityNotFoundException;	
	
	/**
	 * 
	 * @param type
	 */
	void persistBundleType(LicenseBundleType type);
	
	/**
	 * 
	 * @param type
	 */
	void deleteBundleType(LicenseBundleType type);

}
