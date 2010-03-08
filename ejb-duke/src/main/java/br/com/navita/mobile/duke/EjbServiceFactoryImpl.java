package br.com.navita.mobile.duke;

import java.io.Serializable;

import javax.ejb.Stateless;

import br.com.navita.mobile.duke.automidia.AprovaChamadoAutomidia;
import br.com.navita.mobile.duke.automidia.DetalhaChamadoAutomidia;
import br.com.navita.mobile.duke.automidia.ListaChamadosAutomidia;
import br.com.navita.mobile.duke.ps.PeopleServiceTest;
import br.com.navita.mobile.exception.ServiceNotFoundException;
import br.com.navita.mobile.remote.EjbServiceFactory;
import br.com.navita.mobile.remote.EjbServiceFactoryLocal;
import br.com.navita.mobile.remote.MobileService;

@Stateless(mappedName="ejb/DukeEnergyFactory")
public class EjbServiceFactoryImpl implements EjbServiceFactory, EjbServiceFactoryLocal, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public MobileService getServiceByName(String name)	throws ServiceNotFoundException {

		if("getToken".equals(name)){
			return new LoginIntegradoService();
		}

		if("automidia.listaChamados".equals(name)){
			return new ListaChamadosAutomidia();
		}

		if("automidia.detalhaChamado".equals(name)){
			return new DetalhaChamadoAutomidia();
		}
		
		if("automidia.aprovaChamado".equals(name)){
			return new AprovaChamadoAutomidia();
		}

		if("ps.teste".equals(name)){
			return new PeopleServiceTest();
		}
		
		if("ps.xxx".equals(name)){
			//return operation xxx
		}


		throw new ServiceNotFoundException(name + " nao existe neste servico");

	}

}
