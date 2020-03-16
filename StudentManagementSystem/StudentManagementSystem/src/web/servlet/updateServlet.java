package web.servlet;

import domain.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Student student = new Student();
        student.setId(request.getParameter("id"));
        student.setName(request.getParameter("name"));
        student.setAge(Integer.parseInt(request.getParameter("age")));
        student.setGender(request.getParameter("gender"));
        student.setAddress(request.getParameter("address"));

        StudentService service = new StudentServiceImpl();
        if(service.update(student)){
           // response.sendRedirect(request.getContextPath()+"/studentInfo.jsp");
            request.setAttribute("student",student);
            request.getRequestDispatcher(request.getContextPath()+"/studentInfo.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
