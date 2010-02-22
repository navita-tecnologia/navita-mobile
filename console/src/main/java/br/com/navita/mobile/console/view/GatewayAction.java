package br.com.navita.mobile.console.view;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import net.sf.json.JSONSerializer;

import org.apache.struts2.dispatcher.DefaultActionSupport;
import org.apache.struts2.interceptor.ParameterAware;

import br.com.navita.mobile.console.NavitaMobileDispatcher;
import br.com.navita.mobile.console.domain.MobileBean;
import br.com.navita.mobile.console.exception.UnresolvedReturnTypeException;

public class GatewayAction extends DefaultActionSupport implements ParameterAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private InputStream inStream;	
	private String retType;
	private NavitaMobileDispatcher gatewayDispatcher;
	private Map<?,?> params;



	@Override
	public String execute() throws Exception {
		byte[] buff = null;		
		MobileBean obj = gatewayDispatcher.dispatch(params);
		if(obj == null){
			throw new UnresolvedReturnTypeException();
		}
		buff = JSONSerializer.toJSON(obj).toString().getBytes();		
		setInStream(new ByteArrayInputStream(buff));
		
		return "json";
	}

	public InputStream getInStream() {
		return inStream;
	}

	public void setInStream(InputStream inStream) {
		this.inStream = inStream;
	}

	public String getRetType() {
		return retType;
	}

	public void setRetType(String retType) {
		this.retType = retType;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setParameters(Map params) {
		this.params = params;

	}

	public void setGatewayDispatcher(NavitaMobileDispatcher gatewayDispatcher) {
		this.gatewayDispatcher = gatewayDispatcher;
	}


}
