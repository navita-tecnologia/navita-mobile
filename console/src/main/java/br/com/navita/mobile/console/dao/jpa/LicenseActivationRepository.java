package br.com.navita.mobile.console.dao.jpa;

import br.com.navita.mobile.console.model.LicenseActivation;
import br.com.navita.mobile.console.view.rawdata.LicenseActivationRaw;

public interface LicenseActivationRepository<T extends LicenseActivation> extends GenericRepository<LicenseActivation>{

	LicenseActivation findPinOnBundle(LicenseActivationRaw raw);

}
