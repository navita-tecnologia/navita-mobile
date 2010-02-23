package br.com.navita.test;

import javax.naming.NamingException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.navita.mobile.console.bizz.LdapService;
import br.com.navita.mobile.console.domain.LdapConfig;

public class LdapAdTestApp {

	/**
	 * @param args
	 * @throws NamingException 
	 */
	public static void main(String[] args) throws NamingException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		LdapService service = (LdapService) ctx.getBean("ldapService");
		//LdapConfigDAO ldapDAO = (LdapConfigDAO) ctx.getBean("ldapConfigDAO");
		//System.out.println(ldapDAO.listServiceIds());
		
		LdapConfig config = new LdapConfig();
		config.setAutoIp(true);
		config.setDomainName(args[0]);
		config.setSearchFilter(args[1]);
		config.setGroupAttribute(args[2]);
		config.setSearchBase(args[3]);
		
		config.setUser(args[4]);
		config.setPassword(args[5]);
					
		System.out.println(config);
		//config.s
		System.out.println(service.getUserGroups(args[6],config));
	}

}
