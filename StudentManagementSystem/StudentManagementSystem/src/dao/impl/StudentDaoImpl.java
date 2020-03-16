package dao.impl;

import dao.StudentDao;
import dao.util.JDBCUtil;
import domain.Student;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDaoImpl implements StudentDao {

    private Connection conn = null;
    private Statement stmt =  null;
    private ResultSet rs = null;

    @Test
    @Override
    public boolean findStudent(String name,String password) {

        String sql="select * from student where name='"+name+"' and password='"+password+"'";
        //String sql="select * from student where name='朱伟熹' and password='123456'";
//        Connection conn = null;
//        Statement stmt =  null;
//        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,stmt,conn);
        }
         return false;
    }

    @Override
    public boolean addStudent(Student student) {
        String sql="INSERT INTO student(id,NAME,age,gender,address,PASSWORD) VALUES(NULL,'"+student.getName()+"',"+student.getAge()+",'"+student.getGender()+"','"+student.getAddress()+"','"+student.getPassword()+"')";

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.createStatement();
            stmt.execute(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,stmt,conn);
        }
        return false;
    }

    @Override
    public Student findStudentByName(String name) {
        String sql="select * from student where name='"+name+"'";
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            return JDBCUtil.EnObject(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,stmt,conn);
        }
        return null;
    }

    @Override
    public boolean updateStudent(Student student) {
        String sql="UPDATE student SET NAME='"+student.getName()+"' , age="+student.getAge()+" , gender='"+student.getGender()+"' , address='"+student.getAddress()+"' WHERE id="+student.getId()+"";
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.createStatement();
            stmt.execute(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,stmt,conn);
        }
        return false;
    }

    @Override
    public boolean updatePass(String id, String newPass) {
        String sql="UPDATE student SET password='"+newPass+"' WHERE id="+id+"";
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.createStatement();
            stmt.execute(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,stmt,conn);
        }
        return false;
    }

    @Override
    public void del(Student student) {
        String sql = "delete from student where id = "+student.getId()+"";
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,stmt,conn);
        }
    }
}
