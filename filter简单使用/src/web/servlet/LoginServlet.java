package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //简单操作一下
        if("张三".equals(username) && "123123".equals(password)){
            //登录成功 进入主页
            request.getSession().setAttribute("username",username);
            request.getRequestDispatcher(request.getContextPath()+"index.jsp").forward(request,response);
            //response.sendRedirect(request.getContextPath()+"index.jsp");
        }else {
            response.sendRedirect(request.getContextPath()+"login.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
