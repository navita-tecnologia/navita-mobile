package br.com.navita.mobile.console.util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NTCredentials;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Classe util para realizar chamadas HTTP.
 *
 *
 */
public class HttpClientUtil {
	private static final Log LOG=LogFactory.getLog(HttpClientUtil.class);
	private static HttpClient client;
	private int statusCode;
	
	private boolean auth=false;
	private String domainController = null;
	
	public HttpClientUtil(){
		client = new HttpClient(new MultiThreadedHttpConnectionManager());
		client.getHttpConnectionManager().getParams().setConnectionTimeout(30000);
		//  Verificar lista completa de parametros em
		//  http://jakarta.apache.org/commons/httpclient/preference-api.html#HTTP_client_parameters
		//  Guedes 21-12-2006 21:50
		client.getParams().setBooleanParameter("http.protocol.allow-circular-redirects", true);
		

	}



	/**
	 * Faz uma chamada http
	 *
	 * @param url
	 * @param params
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public  String post(String url, NameValuePair[] params, NameValuePair[] headers) throws HttpException, IOException {
		LOG.info("Remote POST: "+url);
		checkAuth();
		PostMethod method = new PostMethod(url);
		method.setRequestBody(params);
		method.setFollowRedirects(false);
		setHeaders(method, headers);
		client.executeMethod(method);
		setStatusCode(method.getStatusCode());
		return retrieveData(method);
	}



	private void checkAuth() {
		if(auth){
			Credentials defaultcreds=new NTCredentials("usu","senha","",domainController);
			client.getState().setCredentials(AuthScope.ANY, defaultcreds);
		}
	}

	private  void setHeaders(HttpMethod method, NameValuePair[] headers){
		if (headers!=null){
			for(int i=0;i<headers.length;i++){
				method.setRequestHeader(headers[i].getName(), headers[i].getValue());
			}
		}
	}

	/**
	 *
	 * @param url
	 * @return
	 * @throws IOException
	 * @throws HttpException
	 * @throws HttpException
	 * @throws IOException
	 */
	public  String get(String url,NameValuePair[] headers) throws HttpException, IOException {
		LOG.info("Remote GET: "+url);
		checkAuth();
		GetMethod method=new GetMethod(url);
		setHeaders(method, headers);
		client.executeMethod(method);
		setStatusCode(method.getStatusCode());
		return retrieveData(method);
	}



	/**
	 *
	 * @param method
	 * @return
	 * @throws IOException
	 */
	private  String retrieveData(HttpMethodBase method) throws IOException{
		StringBuffer buffer = new StringBuffer("");
		BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(),method.getResponseCharSet()));
		String bufferLine = "";
		while ((bufferLine = reader.readLine()) != null) {
			buffer.append(bufferLine).append('\n');
		}
		method.releaseConnection();
		String result=buffer.toString();
		if(result!=null){
			result=result.trim();
		}
		return result;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int resultCode) {
		this.statusCode = resultCode;
	}

}
