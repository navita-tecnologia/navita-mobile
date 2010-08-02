package br.com.navita.mobile.console.dao.jpa.impl;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.navita.mobile.console.dao.jpa.LicenseActivationRepository;
import br.com.navita.mobile.console.model.LicenseActivation;
import br.com.navita.mobile.console.view.rawdata.LicenseActivationRaw;


public class LicenseActivationDAO extends GenericJpaDAO<LicenseActivation> implements LicenseActivationRepository<LicenseActivation>{

	@Override
	public LicenseActivation findPinOnBundle(LicenseActivationRaw la) {
		//FIXME: verificar como se faz este tipo de query
		String ql = "FROM " + persistentClass.getSimpleName() + " e WHERE e.pin = :pin and licensebundle_id = :bundleId";
		Query query = entityManager.createQuery(ql);
		query.setParameter("pin", la.getPin());
		query.setParameter("bundleId", la.getBundleId());
		try{
			return (LicenseActivation) query.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
	}

	
}
