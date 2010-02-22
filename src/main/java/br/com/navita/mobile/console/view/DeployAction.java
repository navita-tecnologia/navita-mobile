package br.com.navita.mobile.console.view;

import java.io.File;
import java.io.FileFilter;
import java.util.logging.Level;
import java.util.logging.Logger;


import org.apache.struts2.dispatcher.DefaultActionSupport;

import br.com.navita.mobile.console.deployable.DeployPathBean;
import br.com.navita.mobile.console.deployable.DynamicExecutorLookupServiceImpl;

public class DeployAction extends DefaultActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = Logger.getLogger(DeployAction.class.getName());
	
	private DeployPathBean deployPathBean;
	private String fileName;
	private File file;
	private String fileContentType;
	private String fileFileName;
	
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	
	public File getFile() {
		return file;
	}
	
	public void setFile(File file) {
		this.file = file;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	
	public void setDeployPathBean(DeployPathBean deployPathBean) {
		this.deployPathBean = deployPathBean;
	}
	
	public FileDecorator[] getDeploys() {
		return decorateFiles( new File(deployPathBean.getDeployPath()).listFiles(new FileFilter(){
			@Override
			public boolean accept(File pathname) {				
				return pathname.getName().toLowerCase().endsWith("jar");
			}
		}));
	}
	
	
	
	
	@Override
	public String execute() throws Exception {
		
		return super.execute();
	}
	
	public String remove() throws Exception{
		if(new File(fileName).delete()){		
			flushClassCache(fileName);
			addActionMessage(fileName + " excluido com sucesso!");
		}else{
			addActionMessage("Falha ao excluir " + fileName);
		}
		return SUCCESS;
	}
	
	public String deploy() throws Exception{	
		String name = deployPathBean.getDeployPath() + File.separator + fileFileName;
		if(new File(name).exists()){
			boolean deleted = new File(name).delete();
			if(!deleted){
				addActionError("Falha ao excluir " + name);
				return INPUT;
			}
			flushClassCache(name);
			
		}
		file.renameTo(new File(deployPathBean.getDeployPath() + File.separator + fileFileName));
		return SUCCESS;
	}

	private void flushClassCache(String name) {
		for(String key : DynamicExecutorLookupServiceImpl.DEPLOY_MAP.keySet() ){
			if(key.startsWith(name.replace("\\", "/"))){
				LOG.log(Level.WARNING,"Removing cache " + key);
				DynamicExecutorLookupServiceImpl.DEPLOY_MAP.remove(key);
			}
		}
		
	}
	private FileDecorator[] decorateFiles(File[] listFiles) {
		if(listFiles == null){
			return null;
		}
		FileDecorator[] dec = new FileDecorator[listFiles.length];
		int n = 0;
		for(File f:listFiles){
			dec[n++] = new FileDecorator(f);
		}
		return dec;
	}
	
}
