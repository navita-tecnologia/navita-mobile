package br.com.navita.mobile.console.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.navita.mobile.domain.MobileBean;

@Entity
public class StaticOperation extends Operation {

	@Column(nullable = true)
	private String list;
	
	@Column(nullable = true)
	private int resultCode;
	
	@Column(nullable = true)
	private String object;
	
	@Column(nullable = true)
	private String message;
	
	@Column(nullable = true)
	private String token;
	
	public String getList() {
		return list;
	}

	public void setList(String list) {
		this.list = list;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	@Override
	public MobileBean process(Map<?, ?> params) throws JSONException {
		MobileBean bean = new MobileBean();
		
		bean.setMessage(message);
		bean.setToken(token);
		bean.setResultCode(resultCode);
		
		bean.setList(null);
		if(object != null && ! object.isEmpty()){
			JSONObject obj = new JSONObject(object);
			bean.setObject(obj.toString());
		}
		
		if(list != null){
			JSONArray array = new JSONArray(list);
			List<Object> listArray = new ArrayList<Object>();
			bean.setList(listArray);
			for(int i = 0;i<array.length();i++){
				listArray.add(array.get(i));
			}
			bean.setList(listArray);
		}
		
		
		
		return bean;
	}
	
}
