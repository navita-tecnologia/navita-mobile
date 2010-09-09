package br.com.navita.mobile.console.push;

import java.io.IOException;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.commons.httpclient.NameValuePair;

import br.com.navita.mobile.console.domain.PushServer;
import br.com.navita.mobile.console.exception.EntityNotFoundException;
import br.com.navita.mobile.console.exception.PushException;
import br.com.navita.mobile.console.service.PushServerService;
import br.com.navita.mobile.console.util.HttpClientUtil;
import br.com.navita.mobile.console.util.NavitaAutowiringSupport;

@WebService(name="pushService",serviceName="push",portName="pushPort")
public class PushGatewayImpl extends NavitaAutowiringSupport implements PushGatewayService {
	
	public PushGatewayImpl() {
		initialize();
	}
	
	private PushServerService pushServerService;
	
	@WebMethod(exclude=true)
	public void setPushServerService(PushServerService pushServerService) {
		this.pushServerService = pushServerService;
	}
	
		
	@Override
	public PushResult execute(PushBean pushBean) throws PushException {			
		PushServer besServer;
		try {
			besServer = pushServerService.findById(pushBean.getApplicationId());
		} catch (EntityNotFoundException e1) {
			throw new PushException(e1);
		}		
		
		PushResult result = new PushResult();
		try {
			String pushResult = doPush(besServer.getUrl(), pushBean.getPin(), besServer.getPort(), new NameValuePair[]{
				new NameValuePair("rawData",pushBean.getRawData()),
				new NameValuePair("attributeCode",pushBean.getAttributeCode())
				});
			result.setMessage(pushResult);
			result.setResultCode(0);
		} catch (IOException e) {
			result.setMessage(e.getMessage());
			result.setResultCode(1);
		}		
		
		return result;
	}
	
	private String doPush(String mdsServerUri, String pin, String appPort, NameValuePair[] params) throws IOException{
		try {
			HttpClientUtil http = new HttpClientUtil();
			String result = http.post(
					mdsServerUri + "/push?DESTINATION="+pin+"&PORT="+appPort+"&REQUESTURI=/",
					params,
					new NameValuePair[]{
							new NameValuePair("Content-Location","http://"),
							new NameValuePair("Content-Type","text/html"),
							new NameValuePair("X-RIM-Push-Channel-ID","http://")//,
							//new NameValuePair("X-RIM-Push-Title","Title"),
							//new NameValuePair("X-RIM-Push-Type","Browser-Message")
					}	
			);
			
			if(http.getStatusCode() == 200 && "".equals(result)){
				result = "Pushed to "+pin+" over "+mdsServerUri;
			}else{
				throw new IOException(result);
			}
			
			return result;
		} catch (Exception e) {
			throw new IOException(e);
		}
	}

}
