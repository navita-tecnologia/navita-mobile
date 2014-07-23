package br.com.navita.mobile.console.operator;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;

import br.com.navita.mobile.console.domain.Connector;
import br.com.navita.mobile.console.domain.ProxyConnector;
import br.com.navita.mobile.console.util.HttpClientUtil;
import br.com.navita.mobile.domain.MobileBean;

public class ProxyOperator implements ConnectorOperator{
	
	private HttpClientUtil httpClient;
	
	public void setHttpClient(HttpClientUtil httpClient) {
		this.httpClient = httpClient;
	}

	@Override
	public MobileBean doConnectorOperation(Connector connector,	Map<String, Object> processedParams) throws HttpException, IOException {
		ProxyConnector proxyConnector = (ProxyConnector) connector;
		List<NameValuePair> params = new ArrayList<NameValuePair>();		
		for(String key: processedParams.keySet()){
			params.add(new NameValuePair(key, extractFirstParam(processedParams.get(key))));
		}
		
		//compat com proxy antigos
		if(processedParams.get("operation") == null){
			params.add(new NameValuePair("operation",extractFirstParam(processedParams.get("operationTag"))));
		}
		if(processedParams.get("app") == null){
			params.add(new NameValuePair("app",extractFirstParam(processedParams.get("connectorTag"))));
		}
		
		String url = proxyConnector.getUrl();
		if(!url.endsWith("/")){
			url += "/";
		}
		String json = httpClient.post(url,  params.toArray(new NameValuePair[params.size()]), null);
		JSONObject jsonObject = JSONObject.fromObject( json );
		MobileBean bean = new MobileBean();
		
		bean.setMessage(jsonObject.getString("message"));
		bean.setResultCode(jsonObject.getInt("resultCode"));		
		bean.setObject(jsonObject.getJSONObject("object"));		
		bean.setList(jsonObject.getJSONArray("list"));
		bean.setToken(jsonObject.getString("token"));

		return bean;
	}

	private String extractFirstParam(Object object) throws UnsupportedEncodingException {
		if(object instanceof String){
			return (String) object;
		}else if(object instanceof String[]){
			String value = ((String[])object)[0];
			value = URLEncoder.encode(value, "utf-8");
			return value;
		}
		
		return object.toString();
		
		
	}

	
}
