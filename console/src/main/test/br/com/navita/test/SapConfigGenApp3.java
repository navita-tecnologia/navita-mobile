package br.com.navita.test;

import java.util.ArrayList;
import java.util.List;

import br.com.navita.mobile.console.processor.sap.SapExecutionConfig;
import br.com.navita.mobile.console.processor.sap.wrap.SapParameter;
import br.com.navita.mobile.console.processor.sap.wrap.SapRow;
import br.com.navita.mobile.console.processor.sap.wrap.SapTable;

import com.thoughtworks.xstream.XStream;

public class SapConfigGenApp3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SapExecutionConfig config = new SapExecutionConfig();
		config.setFunctionName("SAP_WAPI_WORKITEM_DESCRIPTION");
		List<SapParameter> importParams = new ArrayList<SapParameter>();
		importParams.add(new SapParameter("WORKITEM_ID",":workItem"));
		importParams.add(new SapParameter("LINE_WIDTH","075"));
		 
		config.setInputParameterList(importParams);
		
				
		
		
		List<SapTable> outputTableList = new ArrayList<SapTable>();
		SapTable table = new SapTable();
		table.setTableName("TEXT_LINES");
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
