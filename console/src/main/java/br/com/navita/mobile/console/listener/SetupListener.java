package br.com.navita.mobile.console.listener;

import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.navita.mobile.console.bizz.SetupBusiness;

public class SetupListener implements ServletContextListener{
	private SetupBusiness setupBusiness;
	private static final Logger LOG = Logger.getLogger(SetupListener.class.getName());

	public SetupListener() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");		
		setSetupBusiness((SetupBusiness) context.getBean("setupBusiness"));
	}


	public void setSetupBusiness(SetupBusiness setupBusiness) {
		this.setupBusiness = setupBusiness;
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {


	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		if(!setupBusiness.usersExists()){
			LOG.warning("Criando tabela users...");
			setupBusiness.createUsers();
			LOG.warning("Tabela users criada");

		}

		if(!setupBusiness.authExists()){
			LOG.warning("Criando tabela authorities...");
			setupBusiness.createAuth();
			LOG.warning("Tabela authorities criada");			
		}

		//tenta criar o admin, se ja existe nao faz nada
		if(!setupBusiness.adminExists()){
			LOG.warning("Tentando criar admin");
			setupBusiness.insertAdmin();
			LOG.warning("Usuario admin criado com senha padrao");
		}
		
		if(!setupBusiness.appsExists()){
			LOG.warning("Tentando criar apps");
			setupBusiness.createApps();
			LOG.warning("Apps criado");
		}
		
		if(!setupBusiness.appsExecExists()){
			LOG.warning("Tentando criar appexec");
			setupBusiness.createAppsExec();
			LOG.warning("Appexec criado");
		}

		if(!setupBusiness.configExists()){
			setupBusiness.createConfig();
		}


	}

}
