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
import java.util.Map;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();

        Student student = new Student();
        student.setName(map.get("name")[0].toString());
        student.setAge(Integer.parseInt(map.get("age")[0].toString()));
        student.setGender(map.get("gender")[0].toString());
        student.setAddress(map.get("address")[0].toString());
        student.setPassword(map.get("password2")[0].toString());


        StudentService service = new StudentServiceImpl();
        if(service.register(student)){
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("注册成功！2秒后跳转到登录页面");
           // response.sendRedirect(request.getContextPath()+"/login.jsp");
            response.setHeader("refresh", "2;url=" + request.getContextPath()+ "/login.jsp");
        }else{
            request.getRequestDispatcher(request.getContextPath()+"/login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
