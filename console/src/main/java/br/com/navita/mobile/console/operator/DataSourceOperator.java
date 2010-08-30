package br.com.navita.mobile.console.operator;

import java.util.List;
import java.util.Map;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jndi.JndiObjectFactoryBean;

import br.com.navita.mobile.console.domain.entity.DataSourceConnector;
import br.com.navita.mobile.console.domain.entity.DataSourceQueryOperation;
import br.com.navita.mobile.console.domain.entity.Operation;
import br.com.navita.mobile.domain.MobileBean;

public class DataSourceOperator implements Operator{

	@Override
	public MobileBean doOperation(Operation operation, Map<String, Object> params) throws NamingException {
		DataSourceQueryOperation queryOperation = (DataSourceQueryOperation) operation;
		DataSourceConnector connector = (DataSourceConnector) operation.getConnector();
		JndiObjectFactoryBean jndiBean = new JndiObjectFactoryBean();
		DataSource ds = (DataSource)jndiBean.getJndiTemplate().lookup(connector.getDataSource());
		NamedParameterJdbcTemplate  tp = new NamedParameterJdbcTemplate (ds);		
		SqlParameterSource args = new MapSqlParameterSource(params);
		List<?> result = tp.queryForList(queryOperation.getQuery(), args);
		MobileBean bean = new MobileBean();
		bean.setList(result);		
		return bean;
	}

}
