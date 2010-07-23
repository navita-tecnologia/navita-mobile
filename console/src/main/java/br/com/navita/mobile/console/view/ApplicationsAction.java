package br.com.navita.mobile.console.view;

import java.util.List;

import org.apache.struts2.dispatcher.DefaultActionSupport;

import br.com.navita.mobile.console.bizz.LicenseService;
import br.com.navita.mobile.console.dao.LdapConfigDAO;
import br.com.navita.mobile.console.dao.MobileApplicationDAO;
import br.com.navita.mobile.console.domain.LdapConfig;
import br.com.navita.mobile.console.domain.LicenseBundle;
import br.com.navita.mobile.console.domain.MobileApplication;
import br.com.navita.mobile.console.domain.MobileApplicationExecutor;

public class ApplicationsAction extends DefaultActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<MobileApplication> applications;
	private MobileApplicationDAO mobileApplicationDAO;
	private LdapConfigDAO ldapConfigDAO;
	private MobileApplication mobileApplication;
	private String id;
	private List<LdapConfig> ldapConfig;
	private LicenseService licenseService;
	private MobileApplicationExecutor executor;
	
	
	public void setLicenseService(LicenseService licenseService) {
		this.licenseService = licenseService;
	}
	
	
	public List<LicenseBundle> getLicenseBundles(){
		return licenseService.listBundle(null);
	}
	
	public MobileApplicationExecutor getExecutor() {
		return executor;
	}

	public void setExecutor(MobileApplicationExecutor executor) {
		this.executor = executor;
	}

	public List<LdapConfig> getLdapConfig() {
		return ldapConfig;
	}
	
	public void setLdapConfigDAO(LdapConfigDAO ldapConfigDAO) {
		this.ldapConfigDAO = ldapConfigDAO;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public MobileApplication getMobileApplication() {
		return mobileApplication;
	}
	
	public void setMobileApplication(MobileApplication mobileApplication) {
		this.mobileApplication = mobileApplication;
	}
	
	public void setMobileApplicationDAO(
			MobileApplicationDAO mobileApplicationDAO) {
		this.mobileApplicationDAO = mobileApplicationDAO;
	}
	
	
	public List<MobileApplication> getApplications() {
		return applications;
	}
	
	@Override
	public String execute() throws Exception {
		applications = mobileApplicationDAO.listAll();
		return super.execute();
	}
	
	public String edit(){
		mobileApplication = mobileApplicationDAO.findById(id);
		ldapConfig = ldapConfigDAO.listServices();
		return INPUT;
	}
	
	public String save(){
		mobileApplicationDAO.save(mobileApplication);
		addActionMessage("Salvo com sucesso");
		return edit();
	}
	
	public String prepareCreate(){
		ldapConfig = ldapConfigDAO.listServices();
		return "prepareCreate";
	}
	
	public String create() throws Exception{
		if(mobileApplicationDAO.findById(mobileApplication.getId())!=null){
			addActionMessage(mobileApplication.getId()+" existente!");
			return prepareCreate();
		}
		mobileApplicationDAO.create(mobileApplication);
		addActionMessage("Criado com sucesso");
		return execute();
	}
	
	public String remove() throws Exception{
		mobileApplicationDAO.delete(mobileApplication);
		addActionMessage("Removido com sucesso");
		return execute();
	}
	
	public String createExtension() throws Exception{
		mobileApplicationDAO.appendExecutor(executor.getName(), executor.getClassName(), executor.getConfiguration(), id);	
		return edit();
		
	}
	
	public String deleteExtension() throws Exception{
		mobileApplicationDAO.removeExecutor(executor.getName(),id);
		return edit();
	}
	
	public String saveExtension() throws Exception{
		mobileApplicationDAO.saveExecutor(executor.getName(), executor.getClassName(), executor.getConfiguration(), id);
		addActionMessage("Extensao salva com sucesso");
		return edit();
	}

}
