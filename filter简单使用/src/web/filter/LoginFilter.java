package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 注解
 * 拦截路径配置
 * 具体资源路径：/index.jsp  ==> 只有访问index.jsp资源时，过滤器才会被执行
 * 拦截目录：/user/*  ==> 访问/user下的所有资源时，过滤器都会被执行
 * 后缀名拦截：*.jsp  ==> 访问所有后缀名访问jsp资源时，过滤器都会被执行
 * 拦截所有资源：/*  ==> 访问任何资源，过滤器都会被执行
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    /**
     * 拦截请求
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        String uri = request.getRequestURI();

        //放行登录资源
        if(uri.contains("/login.jsp") || uri.contains("/loginServlet")){
            chain.doFilter(req, resp);
        }else {
            Object user = request.getSession().getAttribute("username");
            if(user != null){
                //已登录 放行
                chain.doFilter(req, resp);
            }else {
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
