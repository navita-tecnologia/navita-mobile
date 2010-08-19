package br.com.navita.mobile.console.legacy.processor;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jndi.JndiObjectFactoryBean;

import br.com.navita.mobile.console.BaseMobileAppProcessor;
import br.com.navita.mobile.console.domain.MobileApplication;
import br.com.navita.mobile.console.domain.MobileApplicationExecutor;
import br.com.navita.mobile.domain.MobileBean;

public class DataSourceAppProcessor extends BaseMobileAppProcessor  {
	@Override
	public MobileBean processApplication(MobileApplication mobApp,	String operation, Map<String, Object> processedParams)
			throws Exception {
		
		MobileBean bean = new MobileBean();
		MobileApplicationExecutor exec = findOperationExecutor(mobApp, operation);
		if(exec == null){
			return bean;
		}
		
		resolveProperties(mobApp);
		
		String dsName = mappedName;
		
		JndiObjectFactoryBean jndiBean = new JndiObjectFactoryBean();
		DataSource ds = (DataSource)jndiBean.getJndiTemplate().lookup(dsName);
		NamedParameterJdbcTemplate  tp = new NamedParameterJdbcTemplate (ds);		
		SqlParameterSource args = new MapSqlParameterSource(processedParams);
		List<?> result = tp.queryForList(exec.getConfiguration(), args);		
		bean.setList(result);		
		return bean;
	}

	@Override
	protected String getProcessorUrlPrefix() {		
		return "ds";
	}

}
