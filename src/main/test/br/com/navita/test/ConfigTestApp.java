package br.com.navita.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.navita.mobile.console.dao.LdapConfigDAO;
import br.com.navita.mobile.console.domain.LdapConfig;
import br.com.navita.mobile.exception.NavitaMobileError;



public class ConfigTestApp {

	/**
	 * @param args
	 * @throws NavitaMobileError 
	 */
	public static void main(String[] args) throws NavitaMobileError {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		LdapConfigDAO ldapDAO = (LdapConfigDAO) ctx.getBean("ldapConfigDAO");
		LdapConfig prop = new LdapConfig();
		prop.setAutoIp(true);
		prop.setGroupAttribute("memberOf");
		//prop.setIp("192.168.10.9");
		prop.setDomainName("NVT");
		prop.setName("Domínio NVT");
		prop.setPassword("navita");
		prop.setSearchBase("DC=navita,DC=corp");
		prop.setSearchFilter("(&(objectClass=user)(sAMAccountName={0}))");
		//prop.setUrl("ldap://192.168.10.9:389");
		prop.setUser("CN=ldap,OU=Contas de Serviços,OU=Usuários,OU=SP,OU=NAVITA,DC=navita,DC=corp");
		ldapDAO.saveService(prop, "0d67b458-d99c-4d07-bb8f-1c3888a52cfc");
		System.out.println(ldapDAO.getServiceProperties("0d67b458-d99c-4d07-bb8f-1c3888a52cfc"));
	}

}
