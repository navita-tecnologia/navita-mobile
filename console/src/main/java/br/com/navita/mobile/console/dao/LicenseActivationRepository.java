package br.com.navita.mobile.console.dao;

import java.util.List;

import br.com.navita.mobile.console.domain.LicenseActivation;
import br.com.navita.mobile.console.domain.util.SearchCriteria;


public interface LicenseActivationRepository<T extends LicenseActivation> extends GenericRepository<LicenseActivation>{

	LicenseActivation findPinOnBundle(String pin, String bundleId);
	
	Long countLicenceBundleActivations(String bundleId);
	
	List<T> paginateActivationsByBundle(SearchCriteria criteria);

}
