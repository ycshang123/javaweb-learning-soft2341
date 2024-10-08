package top.soft.class04cookiesession;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author ycshang
 * @description: TODO
 * @date 2024-09-30 下午3:10
 */

@WebServlet("/cookieDemo01")
public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        发送 Cookie
//        1、创建 Cookie 对象
//        resp.setContentType("text/html;charset=UTF-8");
//        resp.setCharacterEncoding("UTF-8");
        Cookie cookie = new Cookie("username","zs");
//        2、对 cookie 持久化
//        cookie.setMaxAge(60);
//        3、通过 response 发送 cookie
         resp.addCookie(cookie);
    }
}
