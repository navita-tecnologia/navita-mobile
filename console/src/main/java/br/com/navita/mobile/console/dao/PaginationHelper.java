package br.com.navita.mobile.console.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class PaginationHelper<E> {

    public Page<E> fetchPage(
            final JdbcTemplate jt,
            final String sqlCountRows,
            final Object countArgs[],
            final String sqlFetchRows,
            final Object fetchArgs[],
            final int pageNo,
            final int pageSize,
            final ParameterizedRowMapper<E> rowMapper) {

        // determine how many rows are available
        final int rowCount = jt.queryForInt(sqlCountRows, countArgs);

        // calculate the number of pages
        int pageCount = rowCount / pageSize;
        if (rowCount > pageSize * pageCount) {
            pageCount++;
        }

        // create the page object
        final Page<E> page = new Page<E>();
        page.setPageNumber(pageNo);
        page.setPagesAvailable(pageCount);

        // fetch a single page of results
       
        jt.query(
                sqlFetchRows,
                fetchArgs,
                new ResultSetExtractor() {
                    public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
                        final List<E> pageItems = page.getPageItems();
                        int currentRow = 0;
                        while (rs.next()) {                            
                           pageItems.add(rowMapper.mapRow(rs, currentRow));                            
                            currentRow++;
                        }
                        return page;
                    }
                });
        return page;
    }

}