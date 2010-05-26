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
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import br.com.navita.mobile.console.domain.LicenseBundle;
import br.com.navita.mobile.console.domain.LicenseBundleType;
import br.com.navita.mobile.console.domain.LicenseUse;

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
		LicenseBundle bd = (LicenseBundle) jdbcTemplate.queryForObject(sql + " and b.id = ?",new Object[]{bundle.getId()},getBundleMapper());
		populateNumber(bd);
		return bd;
	}
	
	private void populateNumber(LicenseBundle bundle){
		int usageNumber = jdbcTemplate.queryForInt("select count(0) from licenseuse where bundleId = ?",new Object[]{bundle.getId()});
		bundle.setUsageNumber(usageNumber);
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
		List<LicenseBundle> list = jdbcTemplate.query(sql,getBundleMapper());
		for(LicenseBundle bd: list){
			populateNumber(bd);
		}
		return list;
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



	@Override
	public Page<LicenseUse> listLicenseUses(LicenseBundle bundle, int pageNumber) {
		String sqlFetchRows = "select * from ( " +
				"select (select count(*) from licenseuse t2, devicedata d1 " +
				"where t2.id <= t1.id and t2.pin = d1.pin and bundleid = ?) as rownum, " +
				"activationdate,periodindays,t1.pin as pin, " +
				"email,licensekey,bundleId,id,brand,model,lastCarrier " +
				"from licenseuse t1, devicedata d2 " +
				"where t1.pin =  d2.pin and bundleid = ? " +
				") resultset " +
				"where rownum >= ? and rownum < ? order by id asc";

		String sqlCountRows = "select count(*) " +
		"from licenseuse u " +
		"where bundleId = ?";

		PaginationHelper<LicenseUse> ph = new PaginationHelper<LicenseUse>();	
		int firstRow = ((pageNumber - 1) * 30) + 1;
		int lastRow = ((pageNumber - 1) * 30) + 31;
		
		
		return ph.fetchPage(
				jdbcTemplate,
				sqlCountRows,new Object[]{bundle.getId()}, 
				sqlFetchRows, new Object[]{bundle.getId(),bundle.getId(),firstRow,lastRow}, 
				pageNumber, 30, getLicenseUseMapper());
	}


	private ParameterizedRowMapper<LicenseUse> getLicenseUseMapper(){
		return new ParameterizedRowMapper<LicenseUse>() {			
			@Override
			public LicenseUse mapRow(ResultSet rs, int rowNum) throws SQLException {				
				LicenseUse use = new LicenseUse();
				use.setActivationDate(rs.getTimestamp("activationdate"));
				use.setPeriodInDays(rs.getInt("periodindays"));
				use.setPin(rs.getString("pin"));
				use.setEmail(rs.getString("email"));
				use.setDeviceBrand(rs.getString("brand"));
				use.setDeviceModel(rs.getString("model"));
				use.setCarrier(rs.getString("lastCarrier"));
				use.setLicenseKey(rs.getString("licenseKey"));
				use.setId(rs.getInt("id"));
				use.setBundleId(rs.getInt("bundleId"));
				return use;
			}
		};
	}



}
