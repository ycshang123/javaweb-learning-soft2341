package top.soft.request;


import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author ycshang
 * @description: 请求转发
 * @date 2024-09-10 下午4:42
 */
@WebServlet("/requestDemo06")
public class RequestDemo06 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("requestDemo06 被请求");
        resp.getWriter().write("RequestDemo06");
        req.setAttribute("msg","hello");

        ServletContext servletContext = req.getServletContext();
        servletContext.setAttribute("info","hello");


    }
}
