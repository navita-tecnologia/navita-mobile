package br.com.navita.mobile.console.view;

import java.util.List;

import org.apache.struts2.dispatcher.DefaultActionSupport;

import br.com.navita.mobile.console.bizz.LicenseService;
import br.com.navita.mobile.console.model.LicenseBundle;
import br.com.navita.mobile.console.model.LicenseBundleType;
import br.com.navita.mobile.console.model.LicenseActivation;
import br.com.navita.mobile.console.view.rawdata.LicenseBundleRaw;


public class LicenseAction extends DefaultActionSupport implements LicenseBundleRaw{
	
	private LicenseBundle licenseBundle = new LicenseBundle();
	private LicenseActivation licenceUse;
	private List<LicenseBundle> bundles;
	private LicenseService licenseService;
	private String acao;
	private int pageNumber = 1;
	private String licenseBundleTypeId;
	private int period;
	private String name;
	private String id;
	private boolean enabled;
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	
	
	
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	public int getPageNumber() {
		return pageNumber;
	}
	
	
	
	
	public String getAcao() {
		return acao;
	}
	
	public void setAcao(String acao) {
		this.acao = acao;
	}
	
	public void setLicenseService(LicenseService licenseService) {
		this.licenseService = licenseService;
	}
	
	
	public LicenseBundle getLicenseBundle() {
		return licenseBundle;
	}

	public void setLicenseBundle(LicenseBundle bundle) {
		this.licenseBundle = bundle;
	}


	public LicenseActivation getLicenceUse() {
		return licenceUse;
	}


	public void setLicenceUse(LicenseActivation licenceUse) {
		this.licenceUse = licenceUse;
	}

	public void setBundles(List<LicenseBundle> bundles) {
		this.bundles = bundles;
	}
	public List<LicenseBundle> getBundles() {
		return bundles;
	}
	
	public List<LicenseBundleType> getLicenseBundleTypes() {
		return licenseService.listBundleTypes();
	}
	
	

	@Override
	public String execute() throws Exception {
		bundles = licenseService.listBundle();		
		return SUCCESS;
	}
	
	public String viewBundle() throws Exception{
		licenseBundle = licenseService.getBundle(this.getId());		
		acao = "save";
		return INPUT;		
	}
	
	public String saveBundle() throws Exception{
		licenseService.updateBundle(this);
		addActionMessage("Pacote salvo com sucesso");
		return viewBundle();
	}
	
	public String removeBundle() throws Exception{
		licenseService.deleteBundle(this);
		addActionMessage("Pacote excluido com sucesso");
		return this.execute();
	}
	
	public String createBundlePrepare() throws Exception{		
		acao = "create";
		return INPUT;		
	}
	
	public String createBundle() throws Exception{
		licenseBundle = licenseService.insertBundle(this);		
		addActionMessage("Pacote criado com sucesso");
		acao = "save";
		return INPUT;		
	}
	
	public String viewLicenseBundleUse() throws Exception{
		licenseBundle = licenseService.getBundle(licenseBundle.getId());					
		return "usage";
	}

	@Override
	public String getLicenseBundleTypeId() {		
		return licenseBundleTypeId;
	}
	
	public void setLicenseBundleTypeId(String licenseBundleTypeId) {
		this.licenseBundleTypeId = licenseBundleTypeId;
	}

	@Override
	public int getPeriod() {		
		return period;
	}
	
	public void setPeriod(int period) {
		this.period = period;
	}

	@Override
	public String getName() {		
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	

}
