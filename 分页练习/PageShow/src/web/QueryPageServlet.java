package web;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.PageBean;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.PageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/queryPageServlet")
public class QueryPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //当前页码
        String currentPageStr = request.getParameter("currentPage");
        //每页显示条数
       // String pageSizeStr = request.getParameter("pageSize");

        int currentPage = 0;
        if(currentPageStr != null && currentPageStr.length() > 0){
            currentPage = Integer.parseInt(currentPageStr);
        }else {
            currentPage = 1;
        }

        /*
        int pageSize = 0;
        if(pageSizeStr != null && pageSizeStr.length() > 0){
            pageSize = Integer.parseInt(pageSizeStr);
        }else {
            pageSize = 5;
        }*/
        //默认每页5条数据
        int pageSize = 5;


        Map<String, String[]> wd = request.getParameterMap();

        PageService service = new PageService();
        PageBean<User> pb = service.queryPage(currentPage,pageSize,wd);

        System.out.println(currentPage);
        System.out.println(wd);

        //将数据序列化为json
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),pb);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
