package dao;

import domain.User;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 查询总记录数
     * @return
     */
    public int findTotalCount(){
        String sql = "select count(*) from test";
        return template.queryForObject(sql,Integer.class);
    }

    public List<User> findByPage(int start, int pageSize){
        String sql = "select * from test limit ? , ?";
        return template.query(sql,new BeanPropertyRowMapper<User>(User.class),start,pageSize);
    }
}
