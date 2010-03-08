package br.com.navita.mobile.duke.automidia;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import br.com.navita.mobile.AppResources;
import br.com.navita.mobile.util.HttpClientUtil;
import br.com.navita.mobile.xparse.Node;
import br.com.navita.mobile.xparse.Xparse;

public class TokenGeneratorAutomidia implements AppResources {
	public String geToken(String login, String passwd) throws HttpException, IOException {
		String fakePasswd = "fakePasswd";
		String rawXML = new HttpClientUtil().get(AUTOMIDIA_WS + "GetToken?type=1&pwd=" + fakePasswd + "&login=" + login, null);
		Xparse xp = new Xparse();
		Node root = xp.parse(rawXML);
		Node tokenNode=root.find("string", new int[]{1});
		return tokenNode.getCharacters();
	}
}
