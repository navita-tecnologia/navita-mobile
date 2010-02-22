package br.com.navita.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ResourceBundle;

public class TestApp {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		String ctxPath = 	ResourceBundle.getBundle("navita-mobile").getString("module.deploy.server.jetty.context.dir");
		File descriptor = new File(ctxPath + File.separator + "oglobo.xml");
		System.out.println(descriptor.getAbsolutePath());
		//PrintWriter pw = new PrintWriter(descriptor);
		//pw.print("<!--  -->");
		//pw.close();
		descriptor.setLastModified(System.currentTimeMillis());
	}

}
