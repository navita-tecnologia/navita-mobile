package br.com.navita.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.navita.mobile.console.sap.PoolManager;
import br.com.navita.mobile.console.sap.SapExecutionConfig;
import br.com.navita.mobile.console.sap.SapSession;
import br.com.navita.mobile.console.sap.wrap.SapParameter;
import br.com.navita.mobile.console.sap.wrap.SapRow;
import br.com.navita.mobile.console.sap.wrap.SapTable;

import com.sap.mw.jco.JCO;
import com.sap.mw.jco.JCO.Client;
import com.sap.mw.jco.JCO.Function;
import com.sap.mw.jco.JCO.ParameterList;
import com.sap.mw.jco.JCO.Table;
import com.thoughtworks.xstream.XStream;

public class XmlConfigExecApApp {

	/**
	 * @param args
	 * @throws Throwable 
	 */
	public static void main(String[] args) throws Throwable {
		XStream xs = new XStream();
		xs.alias("sapExec", SapExecutionConfig.class);
		xs.alias("sapParam", SapParameter.class);
		xs.alias("table", SapTable.class);
		xs.alias("row", SapRow.class);
		SapExecutionConfig config =	(SapExecutionConfig) xs.fromXML(XmlConfigExecApApp.class.getResourceAsStream("/tbg.xml"));
		//SapExecutionConfig config =	(SapExecutionConfig) xs.fromXML(XmlConfigExecApApp.class.getResourceAsStream("/aprova-item-orc.xml"));

		String cli = "100", sysnr="D01";
		Map<String, String> params = new HashMap<String, String>();
		//params.put("usuario", "NAVITA");
		//params.put("centro", "0051");		
		/*params.put("exercicio", "2007");
		params.put("cdOrcamento", "1234");
		params.put("grGastos", "NENHUM");*/

//sap://172.16.18.145?client=100&sysnr=D01

		SapSession session = PoolManager.createSession("mguedes", "navita","sap://172.16.18.145?client="+cli+"&sysnr="+sysnr+"&lang=PT_BR");

		String token = session.getToken();
		Client client = JCO.getClient(token);
		String fName = config.getFunctionName();
		Function function = PoolManager.createFunction(fName, token);


		ParameterList paramInList = function.getImportParameterList();
		if(paramInList != null){
			for(SapParameter sapParam:config.getInputParameterList()){			
				String value = sapParam.getValue();
				if(value.startsWith("$")){
					value = params.get(value.substring(1));
				}				
				paramInList.setValue(value, sapParam.getName());				
			}
		}
		ParameterList tList = function.getTableParameterList();

		if(config.getInputTableList()!=null){
			for(SapTable paramTable: config.getInputTableList()){
				tList.getTable(0);
				Table table = tList.getTable(paramTable.getTableName());
				int paramIndex = 0;
				for(SapRow row:paramTable.getRows()){
					table.appendRow();
					table.setRow(paramIndex++);
					for(SapParameter param:row.getSapParameters()){	
						String value = param.getValue();
						if(value.startsWith("$")){
							value = params.get(value.substring(1));
						}	
						table.setValue(value, param.getName());
					}
				}
			}
		}
		client.execute(function);

		List<SapTable> tables = new ArrayList<SapTable>();
		for(SapTable st : config.getOutputTableList()){
			Table sapTable = tList.getTable(st.getTableName());						
			
			for(int row =0;row < sapTable.getNumRows();row++){
				sapTable.setRow(row);
				SapRow mapRow = new SapRow();
				for(int field = 0;field < sapTable.getFieldCount();field++){
					mapRow.add(new SapParameter(sapTable.getField(field).getName(), sapTable.getString(field)));
				}				
				st.add(mapRow);
			}
			tables.add(st);
		}
		System.out.println(tables);
//		MobileBean bean = new MobileBean();
//		bean.setList(tables);
//		System.out.println(new JSONObject(bean));
	}

}
