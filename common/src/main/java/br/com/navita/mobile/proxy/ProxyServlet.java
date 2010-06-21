package br.com.navita.mobile.proxy;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONSerializer;

import br.com.navita.mobile.domain.MobileBean;

public abstract class ProxyServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		resp.setContentType("application/json");
		MobileBean result = proccessParameters(prepareParameters(req));
		resp.getWriter().print(JSONSerializer.toJSON(result));
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		doPost(req, resp);
	}

	protected abstract MobileBean proccessParameters(Map<?, ?> params);

	/**
	 * Fazer o override deste metodo caso seja necessaria alguma preparacao dos parametros passados ao servico
	 * @param req
	 * @return
	 */
	@SuppressWarnings("unchecked")	
	protected Map<String, Object> prepareParameters(HttpServletRequest req) {
		//FIXME: dar uma melhoradinha nisso
		Map<String, Object> map = new HashMap<String, Object>();
		for(Enumeration  names = req.getParameterNames();names.hasMoreElements();){
			String keyName =  names.nextElement().toString();
			map.put(keyName,req.getParameter(keyName));
		}		
		return map;	
	}	
	
}
