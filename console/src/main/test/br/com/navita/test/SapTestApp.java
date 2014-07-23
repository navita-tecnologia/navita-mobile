package br.com.navita.test;

import br.com.navita.mobile.console.domain.SapConnector;
import br.com.navita.mobile.console.operator.sap.PoolManager;
import br.com.navita.mobile.console.operator.sap.SapSession;

import com.sap.mw.jco.JCO;

public class SapTestApp {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		SapConnector connector = new SapConnector();
		connector.setClient("???");
		connector.setSysnr("???");
		connector.setAsHost("???");
		connector.setLang("PT");

		SapSession session = PoolManager.createSession("???", "???", connector);


		JCO.Client client = null;
		client = JCO.getClient(session.getToken());
		JCO.Function func = PoolManager.createFunction("?????", session.getToken());

		func.getImportParameterList();//set
		client.execute(func);
		func.getExportParameterList();//get

	}

}
