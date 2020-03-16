package service;

import domain.Student;

public interface StudentService {

    /**
     * 登陆验证
     * @param student
     */
    boolean login(Student student);

    /**
     * 学生注册
     * @param student
     * @return
     */
    boolean register(Student student);

    /**
     * 通过用户名查找学生
     * @param name
     * @return
     */
    Student findStudentByName(String name);

    /**
     * 更新学生信息
     * @param student
     * @return
     */
    boolean update(Student student);

    /**
     * 修改密码
     * @param id
     * @param newPass
     * @return
     */
    boolean updatePass(String id, String newPass);

    /**
     * 删除学生
     * @param name
     */
    void delStudent(String name);
}
