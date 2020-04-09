import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findNameServlet")
public class FindNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        Map<String ,Object> map = new HashMap<String ,Object>();

        //简单判断而已 没有dao操作
        if("张三".equals(username)){
            map.put("flag",true);
            map.put("msg","该用户已存在！");
        }else {
            map.put("flag",false);
            map.put("msg","可！");
        }

        //将map转为json
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(map);
        mapper.writeValue(response.getWriter(),map);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
