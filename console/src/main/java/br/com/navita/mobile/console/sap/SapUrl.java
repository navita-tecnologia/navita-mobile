package br.com.navita.mobile.console.sap;

public class SapUrl {

	private String asHost;
	private String sysNr;
	private String client;
	private String lang;
	
	public String getLang() {
		return lang;
	}


	public String getAsHost() {
		return asHost;
	}


	public String getSysNr() {
		return sysNr;
	}


	public String getClient() {
		return client;
	}


	private SapUrl(String ashost,String sysnr, String client, String parsedLang){
		this.asHost = ashost;
		this.sysNr = sysnr;
		this.client = client;
		this.lang = parsedLang;
	}
	
	
	public static SapUrl parse(String url) {
		if(!url.startsWith("sap://")){
			return null;
		}
		
		//sap:///H/200.32.97.5/H/172.16.1.57?client=800&sysnr=IDE
		String[] metade = url.split("\\?");
		if(metade.length != 2){
			return null;
		}
		
		String parsedHost = metade[0].substring("sap://".length());
		String parsedClient = "";
		String parsedSysnr = "";
		String parsedLang = "";
		String[] params = metade[1].split("&");
		if(params.length < 2){
			return null;
		}
		for(String pair:params){
			String[] nameValue = pair.split("=");
			if("client".equals(nameValue[0])){
				parsedClient = nameValue[1];
			}
			if("sysnr".equals(nameValue[0])){
				parsedSysnr = nameValue[1];
			}
			if("lang".equals(nameValue[0])){
				parsedLang = nameValue[1];
			}
			
		}
		
		if("".equals(parsedSysnr) || "".equals(parsedClient)){
			return null;
		}
		
		return new SapUrl(parsedHost,parsedSysnr,parsedClient,parsedLang);
	}

}
