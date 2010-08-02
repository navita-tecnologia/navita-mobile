package br.com.navita.mobile.console.bizz;

import java.util.List;

import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.model.LicenseBundle;
import br.com.navita.mobile.console.model.LicenseBundleType;
import br.com.navita.mobile.console.view.rawdata.LicenseActivationRaw;
import br.com.navita.mobile.console.view.rawdata.LicenseBundleRaw;

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
	 * @throws EntityNotFoundException 
	 */
	LicenseBundle insertBundle(LicenseBundleRaw bundleRaw) throws EntityNotFoundException;
	
	/**
	 * 
	 * @param model
	 * @throws EntityNotFoundException 
	 */
	void deleteBundle(LicenseBundleRaw rawData) throws EntityNotFoundException;
	
	/**
	 * 
	 * @param model
	 * @throws EntityNotFoundException 
	 */
	void updateBundle(LicenseBundleRaw bundle) throws EntityNotFoundException;

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
	void doLicenseActivation(LicenseActivationRaw activationRaw) throws EntityNotFoundException;	
	
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
