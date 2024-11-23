package top.soft.class05ajaxaxios;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author ycshang
 * @description: axios Servlet 初体验
 * @date 2024-10-15 下午2:29
 */
@WebServlet("/axiosServlet")
public class AxiosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1、接收请求参数
        String username = req.getParameter("username");
        System.out.println("username"+username);
//        2、响应结果
        resp.getWriter().write("Hello" + username);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        System.out.println("username"+username);
        this.doGet(req,resp);
    }
}
