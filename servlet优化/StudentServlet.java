package web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 在此写诸多方法
 */
@WebServlet("/studentServlet")
public class StudentServlet extends BaseServlet {

	
	public void login(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("登录方法");
	}
	
	public void loginOut(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("退出方法");
	}
	
}
