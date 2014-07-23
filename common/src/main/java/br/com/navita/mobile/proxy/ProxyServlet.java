/*
 * Copyright 2014 Navita Tecnologia.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.navita.mobile.proxy;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import br.com.navita.mobile.domain.MobileBean;

public abstract class ProxyServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		resp.setContentType("application/json; charset=UTF-8");
		Map<String, Object> params = fromProxyParams(req);
		MobileBean result = proccessParameters(params);
		JSON json = JSONSerializer.toJSON(result);
		String parseJson = new String(json.toString().getBytes(), "UTF-8");
		resp.getWriter().print(parseJson);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		doPost(req, resp);
	}

	protected abstract MobileBean proccessParameters(Map<?, ?> params);

	private Map<String, Object> fromProxyParams(HttpServletRequest req) throws UnsupportedEncodingException {
		Map<String, Object> map = new HashMap<String, Object>();
		for(Enumeration<?>  names = req.getParameterNames();names.hasMoreElements();){
			String keyName =  names.nextElement().toString();
			map.put(keyName,URLDecoder.decode(req.getParameter(keyName),"utf-8"));
		}		
		return map;	
	}	
	
}
