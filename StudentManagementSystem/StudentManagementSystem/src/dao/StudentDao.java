package dao;

import domain.Student;

public interface StudentDao {

    /**
     * 通过name 和password查找学生是否存在
     * @param name
     * @param password
     */
    boolean findStudent(String name,String password);

    /**
     * 添加学生
     * @param student
     * @return
     */
    boolean addStudent(Student student);

    /**
     * 查找学生
     * @param name
     * @return
     */
    Student findStudentByName(String name);

    /**
     * 更新学生信息
     * @param student
     * @return
     */
    boolean updateStudent(Student student);

    /**
     * 修改密码
     * @param id
     * @param newPass
     * @return
     */
    boolean updatePass(String id, String newPass);

    /**
     * 删除学生
     * @param student
     */
    void del(Student student);
}
