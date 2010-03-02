package br.com.navita.mobile.ps;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NameAlreadyBoundException;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class LoadListener implements ServletContextListener{

	private static final Logger log = Logger.getLogger(LoadListener.class.getName());
	private static final String contextName = "com/navita/mobile/ps";
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		try {
			InitialContext initialContext = new InitialContext();
			initialContext.unbind(contextName + "/psLogin");
			log.log(Level.INFO, "JNDI unbinded");
		} catch (NamingException e) {
			log.log(Level.SEVERE,"Erro ao executar o unbind de " + contextName, e);
		}
		

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		String currentName = "";
		InitialContext initialContext;
		try {
			initialContext = new InitialContext();

			for(String subName:contextName.split("/")){
				currentName =  currentName == "" ? subName : currentName+"/"+subName;
				
				try {
					initialContext.createSubcontext(currentName);
					log.log(Level.INFO,currentName + " created");
				}catch (NameAlreadyBoundException e) {
					// do nothing
				}
				
			}

			try {
				initialContext.unbind(contextName + "/psLogin");			
			} catch (NamingException e) {
				//do nothing too
			}

			initialContext.bind(contextName + "/psLogin", LoginPeopleSoft.class);
			log.log(Level.INFO,contextName + "/psLogin" + " BINDED");
		} catch (NamingException e1) {
			log.log(Level.SEVERE,"Erro ao executar o bind de " + contextName, e1);
		}
	}

}
