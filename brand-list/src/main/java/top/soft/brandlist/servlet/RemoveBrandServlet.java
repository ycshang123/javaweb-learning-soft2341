package top.soft.brandlist.servlet;


import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.soft.brandlist.entity.Brand;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ycshang
 * @description: 删除 品牌
 * @date 2024-10-14 下午3:40
 */
@WebServlet("/removeBrand")
public class RemoveBrandServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

//     2、将 JSON 字符串转为 Java 对象
        List<Brand> brands =new ArrayList<>((List<Brand>)req.getServletContext().getAttribute("brands"));

        brands.removeIf(brand -> brand.getId().equals(Integer.parseInt(id)));
        System.out.println(brands.size());

        req.getServletContext().setAttribute("brands",brands);

    }
}
