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

@WebServlet("/delStudentServlet")
public class DelStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        StudentService service = new StudentServiceImpl();
        service.delStudent(name);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("该账户已删除！2秒后跳转到登录页面");
        // response.sendRedirect(request.getContextPath()+"/login.jsp");
        response.setHeader("refresh", "2;url=" + request.getContextPath()+ "/login.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
