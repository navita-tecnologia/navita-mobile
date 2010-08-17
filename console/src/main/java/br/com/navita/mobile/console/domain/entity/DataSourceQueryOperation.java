package br.com.navita.mobile.console.domain.entity;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jndi.JndiObjectFactoryBean;

import br.com.navita.mobile.domain.MobileBean;

@Entity
public class DataSourceQueryOperation extends Operation {

	@Column
	private String query;
	
	
	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	@SuppressWarnings("unchecked")
	@Override
	public MobileBean process(Map<?, ?> params) throws Exception{
		MobileBean bean = new MobileBean();
		JndiObjectFactoryBean jndiBean = new JndiObjectFactoryBean();
		DataSource ds = (DataSource)jndiBean.getJndiTemplate().lookup(((DataSourceConnector) getConnector()).getDataSource());
		NamedParameterJdbcTemplate  tp = new NamedParameterJdbcTemplate (ds);		
		SqlParameterSource args = new MapSqlParameterSource((Map<String, ?>) params);
		List<?> result = tp.queryForList(query, args);		
		bean.setList(result);		
		return bean;
		
	}

	
}
