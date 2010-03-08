package br.com.navita.mobile.duke.automidia;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;


import br.com.navita.mobile.domain.MobileBean;
import br.com.navita.mobile.util.HttpClientUtil;
import br.com.navita.mobile.xparse.Node;
import br.com.navita.mobile.xparse.Xparse;

public class AprovaChamadoAutomidia extends BaseAutomidiaProcessor {
	
	
	private static final long serialVersionUID = 1L;

	@Override
	public MobileBean execute(Map<String, Object> params) {
	
		MobileBean bean = new MobileBean();		
		String urlToCall = AUTOMIDIA_WS;
		if (params.get("aprovar").toString().equalsIgnoreCase("true")){
			urlToCall += "ApproveRequest";
		} else {
			urlToCall += "ReproveRequest";
		}

		HttpClientUtil http = new HttpClientUtil();

		NameValuePair[] pairs = new NameValuePair[]{
				new NameValuePair("Token",params.get("token").toString()),
				new NameValuePair("Descript",params.get("parecer").toString()),
				new NameValuePair("Request",params.get("numeroChamado").toString())
		};

		String retorno = "";
		try {
			retorno = http.post(urlToCall, pairs, null);
		} catch (HttpException e) {
			return getFailBean(1, e);
		} catch (IOException e) {
			return getFailBean(1, e);
		}

		if(http.getStatusCode()!=200){
			return getFailBean(1, http.getStatusCode()+": "+retorno);			
		}
		String hasErrorResult = assertNotOnError(retorno);
		if(hasErrorResult != null){
			return getFailBean(1, hasErrorResult);			
		}
		
		
		Xparse xparse = new Xparse();
		Node root = xparse.parse(retorno);
		Node transaction = root.find("Transaction", new int[]{1});
		Node resultNode = transaction.find("Result", new int[]{1});
		Node messageNode = transaction.find("Message", new int[]{1});
		
		String result = resultNode.getCharacters();
		String message = messageNode.getCharacters();				

		if ("true".equalsIgnoreCase(result.trim())){
			bean.setResultCode(0);
			bean.setMessage(message);						
		} else {
			bean.setResultCode(1);
			bean.setMessage(message);						
		}
		
		return bean;

	}

	

	

}