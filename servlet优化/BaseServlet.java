package web.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class BaseServlet
 */
@WebServlet("/baseServlet")
public class BaseServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("method");
		if(name == null || name.isEmpty()) {
			throw new RuntimeException("没有传递method参数!");
		}
		Class c = this.getClass();
		Method method = null;
		try {
			method = c.getMethod(name, HttpServletRequest.class,HttpServletResponse.class);
		}catch(Exception e) {
			throw new RuntimeException("没有找到"+name+"方法");
		}
		try {
			method.invoke(this, request,response);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}
