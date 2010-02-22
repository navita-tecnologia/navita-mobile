package br.com.navita.mobile.console.view;

import java.io.File;
import java.io.FileFilter;


import org.apache.struts2.dispatcher.DefaultActionSupport;

import br.com.navita.mobile.console.deployable.DeployPathBean;

public class DeployAction extends DefaultActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
			addActionMessage(fileName + " excluido com sucesso!");
		}else{
			addActionMessage("Falha ao excluir " + fileName);
		}
		return SUCCESS;
	}
	
	public String deploy() throws Exception{	
		String name = deployPathBean.getDeployPath() + File.separator + fileFileName;
		if(new File(name).exists()){
			new File(name).delete();
		}
		file.renameTo(new File(deployPathBean.getDeployPath() + File.separator + fileFileName));
		return SUCCESS;
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
