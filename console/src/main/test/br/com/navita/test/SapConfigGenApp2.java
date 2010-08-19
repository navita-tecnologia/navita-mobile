package br.com.navita.test;

import java.util.ArrayList;
import java.util.List;

import br.com.navita.mobile.console.legacy.processor.sap.SapExecutionConfig;
import br.com.navita.mobile.console.legacy.processor.sap.wrap.SapParameter;
import br.com.navita.mobile.console.legacy.processor.sap.wrap.SapRow;
import br.com.navita.mobile.console.legacy.processor.sap.wrap.SapTable;

import com.thoughtworks.xstream.XStream;

public class SapConfigGenApp2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SapExecutionConfig config = new SapExecutionConfig();
		config.setFunctionName("SAP_WAPI_CREATE_WORKLIST");
		List<SapParameter> importParams = new ArrayList<SapParameter>();
		importParams.add(new SapParameter("LANGUAGE","PT"));
		importParams.add(new SapParameter("USER","MGUEDES"));
		
		config.setInputParameterList(importParams);
		
		List<SapTable> inputTableList = new ArrayList<SapTable>();
		SapTable inTable = new SapTable();
		inTable.setTableName("IM_TASK_FILTER");		
		SapRow row = new SapRow();
		row.add(new SapParameter("WI_RH_TASK", "TS90000025"));
		inTable.add(row);
		
		SapRow row1 = new SapRow();
		row1.add(new SapParameter("WI_RH_TASK", "TS20000131"));
		inTable.add(row1);
		
		inputTableList.add(inTable);
		
		config.setInputTableList(inputTableList);
		
		
		
		List<SapTable> outputTableList = new ArrayList<SapTable>();
		SapTable table = new SapTable();
		table.setTableName("WORKLIST");
		outputTableList.add(table);
		config.setOutputTableList(outputTableList);
		
		
		
		
		
		XStream xs  = new XStream();
		xs.alias("sapExec", SapExecutionConfig.class);
		xs.alias("sapParam", SapParameter.class);
		xs.alias("table", SapTable.class);
		xs.alias("row", SapRow.class);
		
		System.out.println(xs.toXML(config));
		

	}

}
