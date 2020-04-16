package dao;

import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public int findTotalCount(Map<String, String[]> wd ){
        String sql = "select count(*) from test where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);

        Set<String> keySets = wd.keySet();
        for (String key : keySets) {
            if("currentPage".equals(key)){
                continue;
            }
            String value = wd.get(key)[0];
            if(value != null && !"".equals(value)){
                sb.append(" and "+key+" like '%"+value+"%' ");
            }
        }
        sql = sb.toString();
        return template.queryForObject(sql,Integer.class);
    }

    public List<User> findByPage(int start, int pageSize){
        String sql = "select * from test limit ? , ?";
        return template.query(sql,new BeanPropertyRowMapper<User>(User.class),start,pageSize);
    }

    public List<User> findByPage(int start, int pageSize,Map<String, String[]> wd ){
        String sql = "select * from test where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);

        Set<String> keySets = wd.keySet();
        for (String key : keySets) {

            if("currentPage".equals(key)){
                continue;
            }
            String value = wd.get(key)[0];
            System.out.println(value);
            if(value != null && !"".equals(value)){
                sb.append(" and "+key+" like '%"+value+"%' ");
            }
        }
        sb.append(" limit ? , ?");
        sql = sb.toString();
        return template.query(sql,new BeanPropertyRowMapper<User>(User.class),start,pageSize);
    }
}
