package com.ksy.batchspring.batch.job.api;

import com.ksy.batchspring.batch.domain.ProductVO;
import com.ksy.batchspring.batch.rowmapper.ProductRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryGenerator {

    public static ProductVO[] getProductList(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<ProductVO> productVOList = jdbcTemplate.query("select type from product group by type", new ProductRowMapper(){
            @Override
            public ProductVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                return ProductVO.builder().type(rs.getString("type")).build();
            }
        });
        return productVOList.toArray(new ProductVO[]{});
    }

    public static Map<String, Object> getParameterForQuery(String param, String value) {
        HashMap<String,Object> parameters = new HashMap<>();
        parameters.put(param, value);
        return parameters;
    }
}
