package web.servlet;

import domain.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //post提交  设置编码
        request.setCharacterEncoding("utf-8");
        //1.获取验证码
        String verifycode = request.getParameter("verifycode");

        //验证码校验
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");  //删除session  保证验证码一次性

        if(!checkcode_server.equalsIgnoreCase(verifycode)){
            request.setAttribute("login_msg","验证码错误！");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }

        //2.封装User对象
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        Student student = new Student();
        student.setName(name);
        student.setPassword(password);

        StudentService service = new StudentServiceImpl();
        if(service.login(student)){
            request.getSession().setAttribute("student",student);
            response.sendRedirect(request.getContextPath()+"/studentMain.jsp");
        }else{
            request.setAttribute("login_msg","用户名或密码！");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
