package br.com.navita.mobile.console.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import br.com.navita.mobile.console.domain.MobileApplication;
import br.com.navita.mobile.console.domain.MobileApplicationExecutor;

public class MobileApplicationDAOImpl implements MobileApplicationDAO {
	private JdbcTemplate jdbcTemplate;	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private final MobileApplication mapApplicationRow(ResultSet rs) throws SQLException {
		MobileApplication app = new MobileApplication();
		app.setEnabled(rs.getBoolean("enabled"));
		app.setId(rs.getString("id"));		
		app.setName(rs.getString("name"));
		app.setUrl(rs.getString("url"));
		app.setLoginServiceId(rs.getString("loginServiceId"));
		app.setUsingNativeLoginService(rs.getBoolean("usingNativeLoginService"));		
		app.setTokenGeneratorUrl(rs.getString("tokenGeneratorUrl"));		
		app.setLicenseActivationKey(rs.getString("licenseActivationKey"));
		app.setLicenseBundleId(rs.getString("licenseBundleId"));

		return app;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public MobileApplication findById(String id) {
		String sql = "select * from mobileapp where id = ?"; 
		MobileApplication ret = null;		

		try {
			ret = (MobileApplication) jdbcTemplate.queryForObject(sql,new String[]{id}, new RowMapper(){

				@Override
				public Object mapRow(ResultSet rs, int rowNum ) throws SQLException {
					return mapApplicationRow(rs);
				}
			});
			ret.setExecutors(listExecutors(id));
		} catch (DataAccessException e) {
			if(!(e instanceof EmptyResultDataAccessException)){
				throw e;
			}
		}

		return ret;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MobileApplication> listAll() {
		String sql = "select * from mobileapp";
		return jdbcTemplate.query(sql, new RowMapper(){
			@Override
			public MobileApplication mapRow(ResultSet rs, int rowNum) throws SQLException {				
				return mapApplicationRow(rs);
			}
		});
	}

	@Override
	public void create(MobileApplication mobileApplication) {
		final MobileApplication model = mobileApplication;
		final String mobileId = (model.getId() == null || model.getId().isEmpty()) ? UUID.randomUUID().toString() : model.getId();
		jdbcTemplate.update("insert into mobileapp" +
				"(id,name,enabled,url,usingNativeLoginService," +
				"loginServiceId,tokenGeneratorUrl," +
				"licenseBundleId,licenseActivationKey) values(" +
				"?,?,1,?,?,?,?,?,?)", new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement ps)
			throws SQLException {				
				ps.setString(1,mobileId);	
				ps.setString(2, model.getName());
				ps.setString(3, model.getUrl());
				ps.setBoolean(4, model.isUsingNativeLoginService());				
				ps.setString(5, model.getLoginServiceId());	

				ps.setString(6, model.getTokenGeneratorUrl());				
				ps.setString(7, model.getLicenseBundleId());
				ps.setString(8, model.getLicenseActivationKey());
			}
		});	

	}

	@Override
	public void save(MobileApplication mobileApplication) {
		final MobileApplication model = mobileApplication;
		jdbcTemplate.update("update mobileapp set " +
				"url = ?," +
				"name = ?," +
				"enabled = ?," +
				"usingNativeLoginService = ?," +
				"loginServiceId = ?, " +
				"tokenGeneratorUrl = ?," +				
				"licenseBundleId = ?," +
				"licenseActivationKey = ? " +
				"where id = ?", new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement ps)
			throws SQLException {
				ps.setString(1, model.getUrl());
				ps.setString(2, model.getName());
				ps.setBoolean(3, model.isEnabled());
				ps.setBoolean(4, model.isUsingNativeLoginService());
				ps.setString(5, model.getLoginServiceId());
				ps.setString(6, model.getTokenGeneratorUrl());								
				ps.setString(7, model.getLicenseBundleId());
				ps.setString(8, model.getLicenseActivationKey());
				ps.setString(9, model.getId());
			}
		});

	}

	@Override
	public void delete(MobileApplication mobileApplication) {
		final MobileApplication model = mobileApplication;
		jdbcTemplate.update("delete from mobileapp where id = ?", new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, model.getId());

			}
		});

	}

	@Override
	public void appendExecutor(final String name, final String className,final String configuration, final String mobileId) {
		jdbcTemplate.update("insert into mobileappexecutor values(" +
				"?,?,?,?)", new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement ps)
			throws SQLException {


				ps.setString(1, name);
				ps.setString(2, className);
				ps.setString(3, configuration);
				ps.setString(4, mobileId);				
			}
		});		

	}

	@Override
	public void removeExecutor(final String name, final String mobileId) {
		jdbcTemplate.update("delete from mobileappexecutor where name = ? and mobileid = ?", new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, name);
				ps.setString(2, mobileId);

			}
		});

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MobileApplicationExecutor> listExecutors(String mobileId) {
		String sql = "select * from mobileappexecutor where mobileid = ?";
		List<MobileApplicationExecutor> ret = null;
		try{
			ret = jdbcTemplate.query(sql, new String[]{mobileId},new RowMapper(){
				@Override
				public MobileApplicationExecutor mapRow(ResultSet rs, int rowNum) throws SQLException {	
					MobileApplicationExecutor exec = new MobileApplicationExecutor();
					exec.setClassName(rs.getString("classname"));
					exec.setName(rs.getString("name"));
					exec.setConfiguration(rs.getString("configuration"));
					return exec;
				}
			});
		} catch (DataAccessException e) {
			if(!(e instanceof EmptyResultDataAccessException)){
				throw e;
			}
		}

		return ret;

	}

	@Override
	public void saveExecutor(final String name, final String className,
			final String configuration, final String mobileId) {
		String sql = "update mobileappexecutor set classname = ?, configuration = ? where name = ? and mobileid = ?";
		jdbcTemplate.update(sql,new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, className);
				ps.setString(2, configuration);
				ps.setString(3, name);
				ps.setString(4, mobileId);

			}
		});

	}


}