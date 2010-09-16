package br.com.navita.mobile.console.operator.sap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sap.mw.jco.JCO;
import com.sap.mw.jco.JCO.Function;
import com.sap.mw.jco.JCO.ParameterList;
import com.sap.mw.jco.JCO.Table;

import br.com.navita.mobile.console.domain.Operation;
import br.com.navita.mobile.console.domain.SapFunctionOperation;
import br.com.navita.mobile.console.domain.SapParameter;
import br.com.navita.mobile.console.domain.SapRow;
import br.com.navita.mobile.console.domain.SapTable;
import br.com.navita.mobile.console.exception.SapGatewayException;
import br.com.navita.mobile.console.operator.Operator;
import br.com.navita.mobile.console.util.NavitaMobileParamsUtil;
import br.com.navita.mobile.domain.MobileBean;

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
						Object param = params.get(value.substring(1));
						if(null == param){
							value= " ";
						}else{
							value = param.toString();
						}						
					}				
					paramInList.setValue(value, sapParam.getName());				
				}
			}
			ParameterList tList = function.getTableParameterList();

			if(sapFunctionOperation.getInputTables() !=null){
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
	private String extractFirstParam(Object object) {
		if(object instanceof String){
			return (String) object;
		}else if(object instanceof String[]){
			return ((String[])object)[0];
		}
		
		return object.toString();
		
		
	}


}

