package br.com.navita.mobile.console.operator;

import java.io.IOException;
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
			params.add(new NameValuePair(key,processedParams.get(key).toString()));
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
		bean.setObject(jsonObject.get("object"));
		bean.setList(jsonObject.getJSONArray("list"));
		bean.setToken(jsonObject.getString("token"));

		return bean;
	}

	
}
