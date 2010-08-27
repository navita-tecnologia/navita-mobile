package br.com.navita.mobile.console.dao.jpa.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.navita.mobile.console.dao.jpa.LicenseActivationRepository;
import br.com.navita.mobile.console.domain.entity.LicenseActivation;
import br.com.navita.mobile.console.domain.entity.util.SearchCriteria;


public class LicenseActivationDAO extends GenericJpaDAO<LicenseActivation> implements LicenseActivationRepository<LicenseActivation>{

	@Override
	public LicenseActivation findPinOnBundle(String pin, String bundleId) {		
		String ql = "FROM LicenseActivation WHERE upper(pin) = upper(:pin) and licenseBundle.id = :bundleId";
		Query query = getEntityManager().createQuery(ql);
		query.setParameter("pin", pin);
		query.setParameter("bundleId", bundleId);
		try{
			return (LicenseActivation) query.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Long countLicenceBundleActivations(String bundleId) {
		String ql = "select count(e) from LicenseActivation e where e.licenseBundle.id = :bundleId";
		Query query = getEntityManager().createQuery(ql);
		query.setParameter("bundleId", bundleId);
		return ((Number) query.getSingleResult()).longValue();
	}

	@Override
	public List<LicenseActivation> paginateActivationsByBundle(SearchCriteria criteria) {
		String ql = "FROM LicenseActivation where licenseBundle.id = :bundleId";
		TypedQuery<LicenseActivation> query = getEntityManager().createQuery(ql,LicenseActivation.class);
		query.setParameter("bundleId", criteria.getText());
		query.setFirstResult(criteria.getOffset());
		query.setMaxResults(criteria.getPageSize());
		return query.getResultList();
	}

	
}
