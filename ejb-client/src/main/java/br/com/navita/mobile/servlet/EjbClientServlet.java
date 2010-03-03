package br.com.navita.mobile.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Permission;
import java.util.HashMap;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.navita.mobile.exception.ServiceNotFoundException;
import br.com.navita.mobile.remote.EjbServiceFactory;
import br.com.navita.mobile.remote.MobileService;

public class EjbClientServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private EjbServiceFactory ejbServiceFactory;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {

		try {
			SecurityManager oldSecurityManager = System.getSecurityManager();

			System.setSecurityManager(new SecurityManager(){			
				public void checkPermission(Permission perm) {}
				public void checkPermission(Permission perm, Object context) {} 
			});
			try{
				MobileService service = ejbServiceFactory.getServiceByName("fake");
				PrintWriter out = resp.getWriter();
				Object[] obj = (Object[]) service.execute(new HashMap<String, Object>()).getObject();
 				out.print(obj[0]);
			}finally{
				System.setSecurityManager(oldSecurityManager);
			}
		} catch (ServiceNotFoundException e) {

		}

		
	}

}
