package web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �ڴ�д��෽��
 */
@WebServlet("/studentServlet")
public class StudentServlet extends BaseServlet {

	
	public void login(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("��¼����");
	}
	
	public void loginOut(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("�˳�����");
	}
	
}
