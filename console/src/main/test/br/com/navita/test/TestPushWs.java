package br.com.navita.test;

import br.com.navita.mobile.push.ws.client.Push;
import br.com.navita.mobile.push.ws.client.PushBean;


public class TestPushWs {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		PushBean b = new PushBean();
		b.setApplicationId("push-simulator");
		b.setAttributeCode("O");
		b.setPin("2100000a");
		b.setRawData("1,2,3,4");
		System.out.println( new Push().getPushPort().execute(b).getMessage());

	}

}
