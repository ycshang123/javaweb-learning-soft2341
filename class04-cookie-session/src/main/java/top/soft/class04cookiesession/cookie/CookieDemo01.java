package top.soft.class04cookiesession.cookie;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author ycshang
 * @description: Cookie 的基本使用
 * @date 2024-10-08 下午1:46
 */

@WebServlet("/cookieDemo01")
public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       1、创建 Cookie 对象
        Cookie cookie = new Cookie("username", "zhangsan");
//       2、通过 response 发送 Cookie
        resp.addCookie(cookie);
//        3、cookie存活时间
        cookie.setMaxAge(60 * 60 * 24 * 7);
    }
}
