package dao.impl;

import dao.UserDao;
import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> findAll() {
        //使用JDBC操作数据库
        //1.定义sql
        String sql = "select * from student";
        /**
         * BeanPropertyRowMapper将查询结果转换为类对象
         * 注意:需要确保数据库表列名称与Java实体类属性名称相同
         */
        List<User> students = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return students;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {
            String sql = "select * from student where username = ? and password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void add(User user) {
        String sql = "insert into student values(null,?,?,?,?,?,?,null,null)";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail());
    }

    @Override
    public void delete(int id) {
        String sql="delete from student where id = ?";
        template.update(sql,id);
    }

    @Override
    public User findById(int id) {
        String sql = "select * from student where id = ?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),id);
    }

    @Override
    public void update(User user) {
        String sql = "update student set name = ?,gender = ? ,age = ? , address = ? , qq = ?, email = ? where id = ?";
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //1.定义sql模版
        String sql = "select count(*) from student where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            //排除分页
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            String value = condition.get(key)[0];
            if(value != null && !"".equals(value)){
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//加条件值
            }
        }

        sql=sb.toString();

        return template.queryForObject(sql,Integer.class,params.toArray());
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from student where 1 = 1 ";

        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            //排除分页
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            String value = condition.get(key)[0];
            if(value != null && !"".equals(value)){
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//加条件值
            }
        }

        sb.append(" limit ?,? ");
        params.add(start);
        params.add(rows);

        sql=sb.toString();

        return template.query(sql,new BeanPropertyRowMapper<User>(User.class),params.toArray());
    }
}
