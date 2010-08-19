package br.com.navita.mobile.console.legacy.processor.sap.exec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.navita.mobile.domain.MobileBean;
import br.com.navita.mobile.console.exception.SapGatewayException;
import br.com.navita.mobile.console.legacy.processor.sap.PoolManager;
import br.com.navita.mobile.console.legacy.processor.sap.SapExecution;

import com.sap.mw.jco.JCO;
import com.sap.mw.jco.JCO.Client;
import com.sap.mw.jco.JCO.Function;
import com.sap.mw.jco.JCO.ParameterList;
import com.sap.mw.jco.JCO.Table;


public class ZgasoaGetUserInbox extends SapExecution {

	@Override
	protected MobileBean execute(Map<String, Object> params) throws SapGatewayException {
		String token = (String) params.get("token");
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		MobileBean bean = new MobileBean();
		JCO.Client client = null;
		try{
			client = JCO.getClient(token);

			JCO.Function func = PoolManager.createFunction("ZGASOA_GET_USER_INBOX", token);
			JCO.Function funcDet = PoolManager.createFunction("ZGASOA_GET_SIMPLE_BOR_ATTRIB", token);
			ParameterList tables = func.getTableParameterList();		
			Table inboxView = tables.getTable("INBOX_VIEW");
			inboxView.appendRow();
			inboxView.setValue("US", "OTYPE");
			inboxView.setValue(params.get("userId").toString().toUpperCase(), "OBJID");
			Table taskFilter = tables.getTable("TASK_FILTER");
			taskFilter.appendRow();
			taskFilter.setValue("TS00008267", "OBJECT");
			taskFilter.appendRow();
			taskFilter.setRow(1);
			taskFilter.setValue("WS90100037", "OBJECT");

			client.execute(func);
			Table wiHead = tables.getTable("WI_HEAD");


			for(int i=0;i<wiHead.getNumRows();i++){
				wiHead.setRow(i);	
				String wiId = wiHead.getString("WI_ID");
				Map<String, Object> listItem = getDetail(wiId, funcDet,client);
				listItem.put("WI_ID",wiId);
				list.add(listItem);

			}	
			bean.setMessage("");
			bean.setResultCode(0);
			bean.setList(list);
		}finally{
			JCO.releaseClient(client);
		}

		return bean;

	}

	private static final String[] ELEMENTS = new String[]{
		"CabNumPessoal","CabNome","CabEmpresa", "CabLocal", "CabCentroCusto", 
		"RotDataIni", "RotDataFim", "RotMotivo", "RotLocal", "RotPais", 
		"RotTpViagEmpr", "RotAtividade", "TotMontante", "DetNumDocumento","DetTipoDespesa", 
		"DetDescDespesa", "DetMontante", "DetMoeda", "DetDataDocumento","CabNumViagem"

	};

	@SuppressWarnings("unchecked")
	protected Map<String, Object> getDetail(String wiId, Function funcDet, Client client) {		
		Map<String, Object> ret = new HashMap<String, Object>();
		funcDet.getImportParameterList().setValue(wiId, "WI_ID");
		ParameterList tables = funcDet.getTableParameterList();
		Table attributes = tables.getTable("OBJATTRIBUTES");
		attributes.deleteAllRows();
		attributes.appendRows(ELEMENTS.length);

		for(int i=0;i<ELEMENTS.length;i++){
			attributes.setRow(i);
			attributes.setValue(ELEMENTS[i], "ELEMENT");
		}

		client.execute(funcDet);


		for(int i=0;i<attributes.getNumRows();i++){
			attributes.setRow(i);
			int index = attributes.getInt("TAB_INDEX");
			String attrib = attributes.getString("ELEMENT");

			if(index == 0){
				ret.put(attrib,  attributes.getString("VALUE"));
			}else{
				List<String> subList =   (List<String>) ret.get(attrib);
				if(subList==null){
					subList = new ArrayList<String>();
					ret.put(attrib, subList);
				}
				subList.add(attributes.getString("VALUE"));
			}

		}

		return ret;


	}

}
