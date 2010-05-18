package br.com.navita.mobile.console.dao;

import java.util.List;

import br.com.navita.mobile.console.domain.LicenseBundle;
import br.com.navita.mobile.console.domain.LicenseBundleType;

public interface LicenseDAO {
	/**
	 * 
	 * @param model
	 * @return
	 */
	List<LicenseBundle> listBundle(LicenseBundle bundle);

	/**
	 * 
	 * @param model
	 * @return
	 */
	LicenseBundle getBundle(LicenseBundle bundle);

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

}
