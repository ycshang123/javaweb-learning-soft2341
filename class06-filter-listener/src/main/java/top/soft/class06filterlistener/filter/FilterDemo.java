package top.soft.class06filterlistener.filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * @author ycshang
 * @description: filter 快速入门
 * @date 2024-10-22 下午1:36
 */

@WebFilter("/*")
public class FilterDemo  implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化");

    }

    @Override
    public void destroy() {
        System.out.println("销毁");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FilterDemo 执行");
//        放行请求资源
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("FilterDemo 资源访问后经过拦截器");
    }
}
