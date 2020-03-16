package service.impl;

import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import domain.Student;
import service.StudentService;

public class StudentServiceImpl implements StudentService {

    private StudentDao dao = new StudentDaoImpl();

    @Override
    public boolean login(Student student) {
        if(student == null){
            return false;
        }
        return  dao.findStudent(student.getName(),student.getPassword());
    }

    @Override
    public boolean register(Student student) {
        if(student == null){
            return false;
        }
        return dao.addStudent(student);
    }

    @Override
    public Student findStudentByName(String name) {
        return dao.findStudentByName(name);
    }

    @Override
    public boolean update(Student student) {
        return dao.updateStudent(student);
    }

    @Override
    public boolean updatePass(String id, String newPass) {
        return dao.updatePass(id,newPass);
    }

    @Override
    public void delStudent(String name) {
        Student student = new Student();
        student = findStudentByName(name);
        dao.del(student);
    }
}
