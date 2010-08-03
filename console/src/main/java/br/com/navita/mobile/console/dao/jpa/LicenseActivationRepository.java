package br.com.navita.mobile.console.dao.jpa;

import java.util.List;

import br.com.navita.mobile.console.domain.entity.LicenseActivation;
import br.com.navita.mobile.console.domain.entity.util.SearchCriteria;


public interface LicenseActivationRepository<T extends LicenseActivation> extends GenericRepository<LicenseActivation>{

	LicenseActivation findPinOnBundle(String pin, String bundleId);
	
	Long countLicenceBundleActivations(String bundleId);
	
	List<LicenseActivation> paginateActivationsByBundle(SearchCriteria criteria);

}
