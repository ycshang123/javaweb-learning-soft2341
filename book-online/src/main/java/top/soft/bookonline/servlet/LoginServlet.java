package top.soft.bookonline.servlet;


import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import top.soft.bookonline.entity.User;
import top.soft.bookonline.service.UserService;
import top.soft.bookonline.service.impl.UserServiceImpl;

import java.io.IOException;

/**
 * @author ycshang
 * @description: 拦截 /login 请求，获得表单传递的参数，进行登录功能验证
 * @date 2024-09-19 上午10:41
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       获取表单数据
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");

//        调用登录功能
        User user = userService.signIn(account, password);
        if (user != null) {
//            登录成功，将用户对象记入 session
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            if (remember != null) {
                Cookie usernameCookie = new Cookie("account", account);
                Cookie passwordCookie = new Cookie("password", password);
                usernameCookie.setMaxAge(60 * 60 * 24 * 7);
                passwordCookie.setMaxAge(60 * 60 * 24 * 7);
                resp.addCookie(usernameCookie);
                resp.addCookie(passwordCookie);
            }
//            重定向回到 /index,进入 IndexServlet
            resp.sendRedirect("/index");


        } else {
//            登录失败，设置好响应对象字符集和响应类型
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write("<script>alert('账号或密码错误');location.href='/';</script>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
