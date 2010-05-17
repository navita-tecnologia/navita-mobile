package br.com.navita.mobile.console.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import br.com.navita.mobile.console.domain.LicenseBundle;

public class LicenseDAOImpl implements LicenseDAO{
	
	private JdbcTemplate jdbcTemplate;	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void deleteBundle(LicenseBundle bundle) {
		jdbcTemplate.update("delete from licenseBundle where id = ?", new Object[]{bundle.getId()});
		
	}

	@Override
	public LicenseBundle getBundle(LicenseBundle bundle) {
		
		return (LicenseBundle) jdbcTemplate.queryForObject("select * from licenseBundle where id = ?",new Object[]{bundle.getId()},getBundleMapper());
	}

	@Override
	public LicenseBundle insertBundle(final LicenseBundle bundle) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update("insert into licenseBundle (name, typeId, enabled, defaultPeriodInDays) " +
				"values(?,?,?,?)", new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bundle.getName());
				ps.setInt(2, bundle.getTypeId());
				ps.setBoolean(3, bundle.isEnabled());
				ps.setInt(4, bundle.getDefaultPeriodInDays());				
				
			}
		});
		
		bundle.setId(keyHolder.getKey().intValue());
		return bundle;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LicenseBundle> listBundle(LicenseBundle bundle) {
		
		return jdbcTemplate.queryForList("select * from licenseBundle");
	}

	@Override
	public void updateBundle(LicenseBundle bundle) {
		
		
	}
	
	private RowMapper getBundleMapper(){
	return new RowMapper() {
		
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			LicenseBundle bundle = new LicenseBundle();
			bundle.setDefaultPeriodInDays(rs.getInt("defaultPeriodInDays"));
			bundle.setEnabled(rs.getBoolean("enabled"));
			bundle.setId(rs.getInt("id"));
			bundle.setName(rs.getString("name"));
			bundle.setTypeId(rs.getInt("typeId"));
			return bundle;
		}
	};
		
	}

}
