package top.soft.request;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author ycshang
 * @description: 获取请求体数据
 * @date 2024-09-10 下午3:58
 */
@WebServlet("/requestDemo03")
public class RequestDemo03 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       获取请求体数据
//        1、获取字符流
        BufferedReader reader = req.getReader();
//        2、读取数据
        String line;
        while ((line = reader.readLine()) != null){
            System.out.println(line);
        }

    }
}
