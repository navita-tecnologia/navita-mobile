package br.com.navita.test;

import java.util.ArrayList;
import java.util.List;

import br.com.navita.mobile.console.processor.sap.SapExecutionConfig;
import br.com.navita.mobile.console.processor.sap.wrap.SapParameter;
import br.com.navita.mobile.console.processor.sap.wrap.SapRow;
import br.com.navita.mobile.console.processor.sap.wrap.SapTable;

import com.thoughtworks.xstream.XStream;

public class SapConfigGenApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SapExecutionConfig config = new SapExecutionConfig();
		config.setFunctionName("YYPCL_LISTAR_CC_EXERC");
		List<SapParameter> importParams = new ArrayList<SapParameter>();
		importParams.add(new SapParameter("USUARIO","{1}"));
		importParams.add(new SapParameter("CENTRO","{2}"));
		importParams.add(new SapParameter("EXERCICIO","{3}"));
		config.setInputParameterList(importParams);
		
		List<SapTable> inputTableList = new ArrayList<SapTable>();
		SapTable inTable = new SapTable();
		inTable.setTableName("T_CENTRO_APR");		
		SapRow row = new SapRow();
		row.add(new SapParameter("USUARIO", "{1}"));
		inTable.add(row);
		inputTableList.add(inTable);
		
		config.setInputTableList(inputTableList);
		
		
		
		List<SapTable> outputTableList = new ArrayList<SapTable>();
		SapTable table = new SapTable();
		table.setTableName("T_CENTROS");
		SapTable table2 = new SapTable();
		table2.setTableName("T_EXERC");
		outputTableList.add(table);
		outputTableList.add(table2);
		config.setOutputTableList(outputTableList);
		
		
		
		
		
		XStream xs  = new XStream();
		xs.alias("sapExec", SapExecutionConfig.class);
		xs.alias("sapParam", SapParameter.class);
		xs.alias("table", SapTable.class);
		xs.alias("row", SapRow.class);
		
		System.out.println(xs.toXML(config));
		

	}

}
