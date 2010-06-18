package br.com.navita.mobile.proxy;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONSerializer;

import br.com.navita.mobile.domain.MobileBean;

public abstract class ProxyServlet extends HttpServlet {
	
	@Override
	protected final void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		resp.setContentType("application/json");
		MobileBean result = proccessParameters(prepareParameters(req));
		resp.getWriter().print(JSONSerializer.toJSON(result));
		
	}
	
	@Override
	protected final void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		doPost(req, resp);
	}

	protected abstract MobileBean proccessParameters(Map<?, ?> params);

	/**
	 * Fazer o override deste metodo caso seja necessaria alguma preparacao dos parametros passados ao servico
	 * @param req
	 * @return
	 */
	protected Map<?, ?> prepareParameters(HttpServletRequest req) {		
		return req.getParameterMap();
	}

}
