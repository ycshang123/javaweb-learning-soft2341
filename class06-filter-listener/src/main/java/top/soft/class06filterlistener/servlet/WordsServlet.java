package top.soft.class06filterlistener.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ycshang
 * @description: TODO
 * @date 2024-10-22 下午2:20
 */
@WebServlet("/wordServlet")
public class WordsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String words = req.getParameter("words");
        PrintWriter writer = resp.getWriter();
        writer.write(words);
        writer.close();


    }
}
