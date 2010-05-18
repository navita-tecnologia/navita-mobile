package br.com.navita.mobile.console.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import br.com.navita.mobile.console.domain.LicenseBundle;
import br.com.navita.mobile.console.domain.LicenseBundleType;

public class LicenseDAOImpl implements LicenseDAO{

	private JdbcTemplate jdbcTemplate;	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private static final String sql = 
		"select b.name as bundleName, " +
		"b.typeId as bundleTypeId, " +
		"b.enabled as enabled, " +
		"b.defaultPeriodInDays as defaultPeriodInDays, " +
		"b.id as bundleId, " +
		"bt.name as bundleTypeName, " +
		"bt.id as bundleTypeId " +
		"from licenseBundle b, licenseBundleType bt " +
		"where b.typeId = bt.id ";

	private RowMapper getBundleMapper(){
		return new RowMapper() {		
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				LicenseBundle bundle = new LicenseBundle();
				LicenseBundleType licenseBundleType = new LicenseBundleType();
				bundle.setDefaultPeriodInDays(rs.getInt("defaultPeriodInDays"));
				bundle.setEnabled(rs.getBoolean("enabled"));
				bundle.setId(rs.getInt("bundleId"));
				bundle.setName(rs.getString("bundleName"));
				licenseBundleType.setId(rs.getInt("bundleTypeId"));
				licenseBundleType.setName(rs.getString("bundleTypeName"));
				bundle.setLicenseBundleType(licenseBundleType);			
				return bundle;
			}
		};

	}
	
	
	@Override
	public void deleteBundle(LicenseBundle bundle) {
		jdbcTemplate.update("delete from licenseBundle where id = ?", new Object[]{bundle.getId()});

	}

	@Override
	public LicenseBundle getBundle(LicenseBundle bundle) {

		return (LicenseBundle) jdbcTemplate.queryForObject(sql + " and b.id = ?",new Object[]{bundle.getId()},getBundleMapper());
	}

	@Override
	public LicenseBundle insertBundle(final LicenseBundle bundle) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		PreparedStatementCreator psc = new PreparedStatementCreator() {			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement ps = con.prepareStatement("insert into licenseBundle " +
						"(name, typeId, enabled, defaultPeriodInDays) " +
						"values(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, bundle.getName());
				ps.setInt(2, bundle.getLicenseBundleType().getId());
				ps.setBoolean(3, bundle.isEnabled());
				ps.setInt(4, bundle.getDefaultPeriodInDays());	
				return ps;
			}
		};
		jdbcTemplate.update(psc,keyHolder);

		bundle.setId(keyHolder.getKey().intValue());
		return bundle;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LicenseBundle> listBundle(LicenseBundle bundle) {

		return jdbcTemplate.query(sql,getBundleMapper());
	}

	@Override
	public void updateBundle(LicenseBundle bundle) {
		jdbcTemplate.update("update licenseBundle " +
				"set name = ?, " +
				"enabled = ?," +
				"typeId = ?, " +
				"defaultPeriodInDays = ?" +
				"where id = ?", new Object[]{
				bundle.getName(),
				bundle.isEnabled(),
				bundle.getLicenseBundleType().getId(),
				bundle.getDefaultPeriodInDays(),
				bundle.getId()
		});

	}


	@SuppressWarnings("unchecked")
	@Override
	public List<LicenseBundleType> listBundleTypes() {		
		return jdbcTemplate.query("select name, id from licenseBundleType order by name", new RowMapper(){
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				LicenseBundleType tp = new LicenseBundleType();
				tp.setName(rs.getString("name"));
				tp.setId(rs.getInt("id"));
				return tp;
			}
		});
	}

	

}
