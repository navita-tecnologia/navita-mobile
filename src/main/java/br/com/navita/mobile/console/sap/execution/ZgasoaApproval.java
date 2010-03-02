package br.com.navita.mobile.console.sap.execution;

import java.util.Map;

import br.com.navita.mobile.domain.MobileBean;
import br.com.navita.mobile.console.exception.SapGatewayException;
import br.com.navita.mobile.console.sap.PoolManager;
import br.com.navita.mobile.console.sap.SapExecution;

import com.sap.mw.jco.JCO;
import com.sap.mw.jco.JCO.ParameterList;
import com.sap.mw.jco.JCO.Table;

public class ZgasoaApproval extends SapExecution {

	@Override
	protected MobileBean execute(Map<String, Object> params) throws SapGatewayException {
		String token = (String) params.get("token");
		JCO.Client client = null;
		try{
			client = JCO.getClient(token);
			JCO.Function func = PoolManager.createFunction("ZGASOA_APPROVAL", token);
			ParameterList input = func.getImportParameterList();
			input.setValue(params.get("wiId"), "WI_ID");
			input.setValue(params.get("aproveFlag"), "APPROVEFLAG");
			Table message = func.getTableParameterList().getTable("MESSAGE");
			message.appendRow();
			message.setValue("TXTMOTIVO", "ELEMENT");
			message.setValue(params.get("message"), "VALUE");

			client.execute(func);
		}finally{
			JCO.releaseClient(client);
		}
		return new MobileBean();
	}

}
