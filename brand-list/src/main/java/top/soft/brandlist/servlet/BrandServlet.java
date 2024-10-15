package top.soft.brandlist.servlet;


import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.soft.brandlist.entity.Brand;

import java.io.IOException;
import java.util.List;

/**
 * @author ycshang
 * @description: 处理前端请求，返回品牌列表 JSON 数据
 * @date 2024-10-14 下午3:15
 */
@WebServlet("/brand")
public class BrandServlet extends HttpServlet {
    private List<Brand> getBrandList() {
        return List.of(
                Brand.builder().id(101).companyName("apple").brandName("iPhone16").description("苹果-iPhone16").ordered(1).build(),
                Brand.builder().id(102).companyName("huawei").brandName("mate60").description("华为-mate60").ordered(2).build(),
                Brand.builder().id(103).companyName("benz").brandName("mercedes").description("奔驰-梅赛德斯").ordered(3).build());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        将 brandList 转成 JSON 串返回给客户端
        resp.setContentType("application/json;charset=utf-8");
        // 获取 Servlet 上下文中的 "brands" 属性
        Object brandsList = req.getServletContext().getAttribute("brands");

// 检查是否为 null，并进行类型转换
        List<Brand> brands = null;
        if (brandsList instanceof List) {
            brands = (List<Brand>) brandsList;
        }

        brands = brands == null ? getBrandList() : brands;

        String jsonString = JSON.toJSONString(brands);
        req.getServletContext().setAttribute("brands", brands);

        resp.getWriter().write(jsonString);
    }
}
