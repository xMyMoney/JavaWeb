package web.servlet;

import service.StudentService;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/updatePassServlet")
public class UpdatePassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("utf-8");
            String id = request.getParameter("id");
            String newPass = request.getParameter("newPass2");
            StudentService service = new StudentServiceImpl();
            if(service.updatePass(id,newPass)){
                //response.setContentType("text/html;charset=utf-8");
               // response.getWriter().write("密码已修改，请重新登录！2秒后跳转到登录页面");
               // response.setHeader("refresh", "2;url=" + request.getContextPath()+ "/login.jsp");
                PrintWriter out = response.getWriter();
//                out.println("<html>");
//                out.println("<script>");
//                out.println("window.open ('login.jsp','_top')");
//                out.println("</script>");
//                out.println("</html>");
                out.write("<script>window.parent.location.href='" + request.getContextPath() + "/login.jsp';</script>");
            }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
