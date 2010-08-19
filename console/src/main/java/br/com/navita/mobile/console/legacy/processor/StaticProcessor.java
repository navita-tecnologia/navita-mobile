package br.com.navita.mobile.console.legacy.processor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.navita.mobile.console.BaseMobileAppProcessor;
import br.com.navita.mobile.domain.MobileBean;
import br.com.navita.mobile.console.domain.MobileApplication;
import br.com.navita.mobile.console.domain.MobileApplicationExecutor;

public class StaticProcessor extends BaseMobileAppProcessor {

	@Override
	public MobileBean processApplication(MobileApplication mobApp,
			String operation, Map<String, Object> processedParams)	throws JSONException {
		MobileBean bean = new MobileBean();
		MobileApplicationExecutor exec = findOperationExecutor(mobApp, operation);
		if(exec == null){
			bean.setMessage("Empty xecution for operation " + operation);
			bean.setResultCode(1);
			return bean;
		}		
		JSONObject j = new JSONObject(exec.getConfiguration());
		if(! j.isNull("message")){
			bean.setMessage(j.getString("message"));
		}
		if(! j.isNull("token")){
			bean.setToken(j.getString("token"));
		}
		if(! j.isNull("resultCode")){
			bean.setResultCode(j.getInt("resultCode"));
		}
		if(! j.isNull("object")){
			bean.setObject(j.get("object").toString());
		}
		if(! j.isNull("list")){
			JSONArray array = j.getJSONArray("list");
			List<Object> list = new ArrayList<Object>();
			bean.setList(list);
			for(int i = 0;i<array.length();i++){
				list.add(array.get(i).toString());
			}
		}

		return bean;


	}

	@Override
	protected String getProcessorUrlPrefix() {
		
		return "static";
	}	

}
