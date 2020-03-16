package dao.util;

import domain.Student;
import org.junit.Test;

import java.sql.*;

public class JDBCUtil {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接对象
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql:///Students","root","zhuweixi99");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 释放资源
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void close(ResultSet resultSet, Statement statement, Connection connection){
        if( resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if( statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if( connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 封装Student对象
     * @param rs
     */
    public static Student EnObject(ResultSet rs) throws SQLException {
        Student student = new Student();
        while (rs.next()) {
            student.setId(rs.getString("id"));
            student.setName(rs.getString("name"));
            student.setAge(Integer.parseInt(rs.getString("age")));
            student.setGender(rs.getString("gender"));
            student.setAddress(rs.getString("address"));
            student.setPassword(rs.getString("password"));
        }
        return student;
    }

}
