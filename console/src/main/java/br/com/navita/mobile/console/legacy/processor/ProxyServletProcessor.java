package br.com.navita.mobile.console.legacy.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.NameValuePair;

import br.com.navita.mobile.console.BaseMobileAppProcessor;
import br.com.navita.mobile.console.domain.MobileApplication;
import br.com.navita.mobile.console.util.HttpClientUtil;
import br.com.navita.mobile.domain.MobileBean;

public class ProxyServletProcessor  extends BaseMobileAppProcessor{

	private HttpClientUtil httpClient;
	public void setHttpClient(HttpClientUtil httpClient) {
		this.httpClient = httpClient;
	}

	@Override
	public MobileBean processApplication(MobileApplication mobApp, String operation, Map<String, Object> processedParams) throws Exception {
		this.resolveProperties(mobApp);		
		List<NameValuePair> params = new ArrayList<NameValuePair>();		
		for(String key: processedParams.keySet()){
			params.add(new NameValuePair(key,processedParams.get(key).toString()));
		}
		String json = httpClient.post(mappedName,  params.toArray(new NameValuePair[params.size()]), null);
		JSONObject jsonObject = JSONObject.fromObject( json );
		MobileBean bean = new MobileBean();
		bean.setMessage(jsonObject.getString("message"));
		bean.setResultCode(jsonObject.getInt("resultCode"));
		bean.setObject(jsonObject.get("object"));
		bean.setList(jsonObject.getJSONArray("list"));
		bean.setToken(jsonObject.getString("token"));

		return bean;
	}

	@Override
	protected String getProcessorUrlPrefix() {		
		return "proxy";
	}

}
