package web.servlet;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //post提交  设置编码
        request.setCharacterEncoding("utf-8");
        //1.获取数据
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
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        /*BeanUtils.populate( Object bean, Map properties )，
        这个方法会遍历map<key, value>中的key，如果bean中有这个属性，就把这个key对应的value值赋给bean的属性。*/
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        //3.调用Service查询
        UserService userService = new UserServiceImpl();
        User loginUser = userService.login(user);
        //4.判断是否登录成功
        if(loginUser != null){
            session.setAttribute("user",loginUser);
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else {
            request.setAttribute("login_msg","用户名或密码！");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
