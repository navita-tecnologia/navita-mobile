package br.com.navita.mobile.console.dao.jpa;

import java.util.List;

import br.com.navita.mobile.console.model.LicenseActivation;
import br.com.navita.mobile.console.model.util.SearchCriteria;


public interface LicenseActivationRepository<T extends LicenseActivation> extends GenericRepository<LicenseActivation>{

	LicenseActivation findPinOnBundle(String pin, String bundleId);
	
	Long countLicenceBundleActivations(String bundleId);
	
	List<LicenseActivation> paginateActivationsByBundle(SearchCriteria criteria);

}
