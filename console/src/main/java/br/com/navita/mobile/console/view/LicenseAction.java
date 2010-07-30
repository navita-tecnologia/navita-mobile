package br.com.navita.mobile.console.view;

import java.util.List;

import org.apache.struts2.dispatcher.DefaultActionSupport;

import br.com.navita.mobile.console.bizz.LicenseService;
import br.com.navita.mobile.console.model.LicenseBundle;
import br.com.navita.mobile.console.model.LicenseBundleType;
import br.com.navita.mobile.console.model.LicenseActivation;


public class LicenseAction extends DefaultActionSupport {
	
	private LicenseBundle bundle = new LicenseBundle();
	private LicenseActivation licenceUse;
	private List<LicenseBundle> bundles;
	private LicenseService licenseService;
	private String acao;
	private int pageNumber = 1;
	
	
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
	
	
	public LicenseBundle getBundle() {
		return bundle;
	}

	public void setBundle(LicenseBundle bundle) {
		this.bundle = bundle;
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
		bundle = licenseService.getBundle(bundle.getId());	
		acao = "save";
		return INPUT;		
	}
	
	public String saveBundle() throws Exception{
		licenseService.updateBundle(bundle);
		addActionMessage("Pacote salvo com sucesso");
		return viewBundle();
	}
	
	public String removeBundle() throws Exception{
		licenseService.deleteBundle(bundle);
		addActionMessage("Pacote excluido com sucesso");
		return this.execute();
	}
	
	public String createBundlePrepare() throws Exception{
		bundle = new LicenseBundle();	
		acao = "create";
		return INPUT;		
	}
	
	public String createBundle() throws Exception{
		bundle = licenseService.insertBundle(bundle);		
		addActionMessage("Pacote criado com sucesso");
		acao = "save";
		return INPUT;		
	}
	
	public String viewLicenseBundleUse() throws Exception{
		bundle = licenseService.getBundle(bundle.getId());					
		return "usage";
	}

}
