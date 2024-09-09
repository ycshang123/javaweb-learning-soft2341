package top.soft.bookonline.controller;


import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import top.soft.bookonline.entity.User;
import top.soft.bookonline.service.UserService;
import top.soft.bookonline.service.impl.UserServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ycshang
 * @description: 拦截 /login 请求，获得表单传递的参数，进行登录功能验证
 * @date 2024-09-04 下午4:52
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        获取表单参数
        String account = req.getParameter("account");
        String password = req.getParameter("password");
//        调用登录功能
        User user = userService.signIn(account, password);
        if (user != null) {
//            登录成功，将用户对象记入 session
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
//            重定向到 /index，进入 IndexServlet
            resp.sendRedirect("/index");

        } else {
//            登录失败，设置响应对象记字符集和响应类型
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
//            获得 response 对象字符输出流
            PrintWriter out = resp.getWriter();
//           输出 js 脚本，弹出登录失败信息
            out.print("<script>alert('登录失败,账号或密码错误');window.location.href='/'</script>");

        }
    }
}
