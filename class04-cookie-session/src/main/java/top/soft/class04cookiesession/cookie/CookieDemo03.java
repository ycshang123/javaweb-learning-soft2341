package top.soft.class04cookiesession.cookie;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author ycshang
 * @description: Cookie 的基本使用
 * @date 2024-10-08 下午1:46
 */

@WebServlet("/cookieDemo03")
public class CookieDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       1、创建 Cookie 对象
        String value =" 张三";
        Cookie cookie = new Cookie("username", URLEncoder.encode(value, StandardCharsets.UTF_8));
//       2、通过 response 发送 Cookie
        resp.addCookie(cookie);
//        3、cookie存活时间
        cookie.setMaxAge(60 * 60 * 24 * 7);
    }
}
