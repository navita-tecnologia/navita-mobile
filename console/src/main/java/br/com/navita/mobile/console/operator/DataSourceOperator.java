/*
 * Copyright 2014 Navita Tecnologia.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.navita.mobile.console.operator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jndi.JndiObjectFactoryBean;

import br.com.navita.mobile.console.domain.DataSourceConnector;
import br.com.navita.mobile.console.domain.DataSourceQueryOperation;
import br.com.navita.mobile.console.domain.Operation;
import br.com.navita.mobile.domain.MobileBean;

public class DataSourceOperator implements Operator{

	@Override
	public MobileBean doOperation(Operation operation, Map<String, Object> params) throws NamingException {
		DataSourceQueryOperation queryOperation = (DataSourceQueryOperation) operation;
		DataSourceConnector connector = (DataSourceConnector) operation.getConnector();
		JndiObjectFactoryBean jndiBean = new JndiObjectFactoryBean();
		DataSource ds = (DataSource)jndiBean.getJndiTemplate().lookup(connector.getDataSource());
		NamedParameterJdbcTemplate  tp = new NamedParameterJdbcTemplate (ds);
		//FIXME: deve vir ja convertido em <String,String>
		Map<String,String> processedParams = prepareParameters(params);
		SqlParameterSource args = new MapSqlParameterSource(processedParams);
		MobileBean bean = new MobileBean();
		if(queryOperation.isReturnResultSet()){
			List<?> result = tp.queryForList(queryOperation.getQuery(), args);
			bean.setList(result);
		}else{
			int resultCode = tp.update(queryOperation.getQuery(), args);
			bean.setObject(resultCode);
		}
		
				
		return bean;
	}

	private Map<String, String> prepareParameters(Map<String, Object> params) {
		Map<String, String> ret = new HashMap<String, String>();
		for(String key: params.keySet()){
			Object value = params.get(key);
			if(value != null && value.getClass().isArray()){
				ret.put(key, ((Object[])value)[0].toString());
			}else{
				ret.put(key, value.toString());
			}
		}
		
		return ret;
	}
	
	

}
