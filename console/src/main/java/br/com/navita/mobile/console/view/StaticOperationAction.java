package br.com.navita.mobile.console.view;

import br.com.navita.mobile.console.view.rawdata.StaticOperationRaw;

public class StaticOperationAction extends OperationRawActionSupport implements StaticOperationRaw {

	private String list;
	private String message;
	private String object;
	private int resultCode;
	private String token;
	
	@Override
	public String getList() {
		return list;
	}
	public void setList(String list) {
		this.list = list;
	}
	@Override
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	@Override
	public int getResultCode() {
		return resultCode;
	}
	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}
	@Override
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	

	
	
}
