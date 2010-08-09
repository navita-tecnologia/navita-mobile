package br.com.navita.mobile.console.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import br.com.navita.mobile.console.dao.jpa.OperationRepository;
import br.com.navita.mobile.console.domain.entity.Connector;
import br.com.navita.mobile.console.domain.entity.LicenseBundle;
import br.com.navita.mobile.console.domain.entity.StaticConnector;
import br.com.navita.mobile.console.domain.entity.StaticOperation;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.service.BaseConnectorService;
import br.com.navita.mobile.console.service.LicenseService;
import br.com.navita.mobile.console.service.OperationService;
import br.com.navita.mobile.console.view.rawdata.StaticOperationRaw;

@Transactional
public class StaticOperationService implements OperationService<StaticOperation, StaticOperationRaw> {
	private OperationRepository<StaticOperation> staticOperationRepository;
	private BaseConnectorService<Connector> baseConnectorService;
	private LicenseService licenseService;

	public void setBaseConnectorService(
			BaseConnectorService<Connector> baseConnectorService) {
		this.baseConnectorService = baseConnectorService;
	}
	
	public void setLicenseService(LicenseService licenseService) {
		this.licenseService = licenseService;
	}

	public void setStaticOperationRepository(
			OperationRepository<StaticOperation> staticOperationRepository) {
		this.staticOperationRepository = staticOperationRepository;
	}

	@Override
	public void create(StaticOperationRaw raw) throws EntityNotFoundException {
		StaticOperation oper = new StaticOperation();
		if(raw.getLicenseBundleId() != null){
			LicenseBundle bundle = licenseService.getBundle(raw.getLicenseBundleId());
			oper.setLicenseBundle(bundle);
		}
		StaticConnector connector = (StaticConnector) baseConnectorService.findById(raw.getConnectorId());
		oper.setConnector(connector);
		oper.setLicenseKey(raw.getLicenseKey());
		oper.setList(raw.getList());
		oper.setMessage(raw.getMessage());
		oper.setName(raw.getName());
		oper.setObject(raw.getObject());
		oper.setResultCode(raw.getResultCode());
		oper.setToken(raw.getToken());
		oper.setTag(raw.getTag());
		staticOperationRepository.persist(oper);
		

	}

	@Override
	public List<StaticOperation> getConnectorOperations(String connectorId) {
		return staticOperationRepository.listConnectorOperations(connectorId);
	}

	@Override
	public void remove(String id) throws EntityNotFoundException {
		staticOperationRepository.remove(staticOperationRepository.findById(id));

	}

	@Override
	public void update(StaticOperationRaw oprationRaw) {


	}

	

}
