package br.com.navita.mobile.console.operator.sap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import br.com.navita.mobile.console.domain.Operation;
import br.com.navita.mobile.console.domain.SapFunctionOperation;
import br.com.navita.mobile.console.domain.SapParameter;
import br.com.navita.mobile.console.domain.SapRow;
import br.com.navita.mobile.console.domain.SapTable;
import br.com.navita.mobile.console.exception.SapGatewayException;
import br.com.navita.mobile.console.operator.Operator;
import br.com.navita.mobile.console.util.NavitaMobileParamsUtil;
import br.com.navita.mobile.domain.MobileBean;

import com.sap.mw.jco.JCO;
import com.sap.mw.jco.JCO.Field;
import com.sap.mw.jco.JCO.Function;
import com.sap.mw.jco.JCO.ParameterList;
import com.sap.mw.jco.JCO.Table;
import com.sap.mw.jco.JCO.Structure;

public class SapOperator implements Operator{



	@Override
	public MobileBean  doOperation(Operation operation, Map<String, Object> params) throws SapGatewayException  {
		String token = NavitaMobileParamsUtil.extractFirstParam(params.get("token"));		
		JCO.Client client = null;		
		SapFunctionOperation sapFunctionOperation = (SapFunctionOperation) operation;
		MobileBean bean = new MobileBean();
		try{
			client = JCO.getClient(token);

			String fName = sapFunctionOperation.getFunctionName();
			Function function = PoolManager.createFunction(fName, token);

			ParameterList paramInList = function.getImportParameterList();
			if(paramInList != null){
				for(SapParameter sapParam : sapFunctionOperation.getInputParameters()){			
					String value = sapParam.getValue();
					if(value.startsWith("$") || value.startsWith(":")){
						value = extractFirstParam( params.get(value.substring(1)));					
					}				
					paramInList.setValue(value, sapParam.getName());				
				}
			}
			
			ParameterList paramOutList = function.getExportParameterList();
			if(paramOutList != null){
				for(SapParameter sapParam : sapFunctionOperation.getOutputParameters()){			
					String value = null;//sapParam.getValue();
//					if(value.startsWith("$") || value.startsWith(":")){
//						value = extractFirstParam( params.get(value.substring(1)));					
//					}				
					paramOutList.setValue(value, sapParam.getName());				
				}
			}			
			
			
			ParameterList tList = function.getTableParameterList();

			if(sapFunctionOperation.getInputTables() !=null){
				//inclui tabelas estaticas definidas pela configuracao
				for(SapTable paramTable: sapFunctionOperation.getInputTables()){
					Table table = tList.getTable(paramTable.getName());
					int paramIndex = 0;
					for(SapRow row : paramTable.getSapRows()){
						table.appendRow();
						table.setRow(paramIndex++);
						for(SapParameter param : row.getAttributes()){	
							String value = param.getValue();
							if(value.startsWith("$") || value.startsWith(":")){
								value = extractFirstParam( params.get(value.substring(1)));
							}	
							table.setValue(value, param.getName());
						}
					}
				}				
				//inclui tabelas dinamicas vindas como parametro
				List<br.com.navita.mobile.console.operator.sap.wrap.SapTable> paramTables = extractParamTables(params);
				if(paramTables != null){
					for(br.com.navita.mobile.console.operator.sap.wrap.SapTable pTable : paramTables){
						Table table = tList.getTable(pTable.getTableName());
						int paramIndex = 0;
						for(br.com.navita.mobile.console.operator.sap.wrap.SapRow row:pTable.getRows()){
							table.appendRow();
							table.setRow(paramIndex++);
							for(br.com.navita.mobile.console.operator.sap.wrap.SapParameter param : row.getRowEnvelop()){	
								table.setValue(param.getValue(), param.getName());
							}
						}
					}
				}

			}
			client.execute(function);

			List<br.com.navita.mobile.console.operator.sap.wrap.SapTable> outTables = new ArrayList<br.com.navita.mobile.console.operator.sap.wrap.SapTable>();
			for(SapTable st : sapFunctionOperation.getOutputTables()){	
				br.com.navita.mobile.console.operator.sap.wrap.SapTable wrapTable = new br.com.navita.mobile.console.operator.sap.wrap.SapTable();
				wrapTable.setTableName(st.getName());
				Table sapTable = tList.getTable(st.getName());				
				for(int row =0;row < sapTable.getNumRows();row++){
					sapTable.setRow(row);
					br.com.navita.mobile.console.operator.sap.wrap.SapRow mapRow = new br.com.navita.mobile.console.operator.sap.wrap.SapRow();

					for(int field = 0;field < sapTable.getFieldCount();field++){						
						mapRow.add(new br.com.navita.mobile.console.operator.sap.wrap.SapParameter(sapTable.getField(field).getName(), sapTable.getString(field)));
					}				
					wrapTable.add(mapRow);
				}
				outTables.add(wrapTable);
			}
			
			//Retorna como tabelas
			List<br.com.navita.mobile.console.operator.sap.wrap.SapParameter> outParams = new ArrayList<br.com.navita.mobile.console.operator.sap.wrap.SapParameter>();
			for(SapParameter sp : sapFunctionOperation.getOutputParameters()){
				Field field = paramOutList.getField(sp.getName());
				if (field.getType() == JCO.TYPE_STRUCTURE){
					br.com.navita.mobile.console.operator.sap.wrap.SapTable wrapTable = new br.com.navita.mobile.console.operator.sap.wrap.SapTable();
					wrapTable.setTableName(field.getName());
					Structure sapStructure = field.getStructure();
					
					br.com.navita.mobile.console.operator.sap.wrap.SapRow mapRow = new br.com.navita.mobile.console.operator.sap.wrap.SapRow();
					for(int row =0;row < sapStructure.getNumFields();row++){
						Field sapField = sapStructure.getField(row);
						mapRow.add(new br.com.navita.mobile.console.operator.sap.wrap.SapParameter(sapField.getName(), sapField.getString()));
					}
					wrapTable.add(mapRow);
					outTables.add(wrapTable);
				} else {
					br.com.navita.mobile.console.operator.sap.wrap.SapParameter paramOut = new br.com.navita.mobile.console.operator.sap.wrap.SapParameter(field.getName(), field.getString());
					outParams.add(paramOut);
				}
			}
			if (!outParams.isEmpty()){
				bean.setObject(outParams);
			}
			
			bean.setList(outTables);
			bean.setMessage("");
			bean.setResultCode(0);
		}finally{		
			try{
				JCO.releaseClient(client);
			}catch (Throwable e) {
				//engole a exception pois nao ha nada o que fazer...
			}
		}

		return bean;
	}
	private List<br.com.navita.mobile.console.operator.sap.wrap.SapTable> extractParamTables(Map<String, Object> params) {
		String json = extractFirstParam(params.get("tables"));
		if(json == null || json.isEmpty() || ! json.startsWith("[")){
			return null;
		}
		//exemplo de json que deve vir do device,
		//de preferencia usar as classes de wrap deste projeto
		//[{"rows":[{"rowEnvelop":[{"name":"P1","value":"v1"},{"name":"P2","value":"v2"}]}],"tableName":"TB_01"}]
		
		List<br.com.navita.mobile.console.operator.sap.wrap.SapTable> ret = new ArrayList<br.com.navita.mobile.console.operator.sap.wrap.SapTable>();
		
		JSONArray array = (JSONArray) JSONSerializer.toJSON(json);
		for(int i = 0; i < array.size(); i++){
			JSONObject obj = array.getJSONObject(i);			
			br.com.navita.mobile.console.operator.sap.wrap.SapTable table = new br.com.navita.mobile.console.operator.sap.wrap.SapTable();
			table.setTableName(obj.getString("tableName"));
			JSONArray rows = obj.getJSONArray("rows");
			for(int j = 0; j < rows.size(); j++){
				JSONArray values = rows.getJSONObject(j).getJSONArray("rowEnvelop");
				br.com.navita.mobile.console.operator.sap.wrap.SapRow row = new br.com.navita.mobile.console.operator.sap.wrap.SapRow();
				for(int k = 0; k < values.size();k++){
					JSONObject item = values.getJSONObject(k);
					row.add(new br.com.navita.mobile.console.operator.sap.wrap.SapParameter(item.getString("name"), item.getString("value")));					
				}				
				table.add(row);
			}
			ret.add(table);
		}
		return ret;
	}
	
	
	
	private String extractFirstParam(Object object) {
		if (object == null){
			return " ";
		}
		if(object instanceof String){
			return (String) object;
		}else if(object instanceof String[]){
			return ((String[])object)[0];
		}

		return object.toString();


	}


}

