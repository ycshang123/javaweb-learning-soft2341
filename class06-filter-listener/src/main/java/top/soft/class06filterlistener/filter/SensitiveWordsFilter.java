package top.soft.class06filterlistener.filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ycshang
 * @description: TODO
 * @date 2024-10-22 下午1:52
 */

@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {

    //     敏感词集合
    private final List<String> list = new ArrayList<>();

//    执行的方法命
    private final String methodName = "getParameter";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            ServletContext servletContext = filterConfig.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(realPath), StandardCharsets.UTF_8);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html;charset=utf-8");
//        通过代理 增强 getParameter 方法
        ServletRequest proxyReq = (ServletRequest) Proxy.newProxyInstance(servletRequest.getClass().getClassLoader(), servletRequest.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(methodName.equals(method.getName())){
                    String value = (String)method.invoke(servletRequest, args);
                    if(value != null){
                        for (String s : list){
                            if (value.contains(s)){
                                value = value.replaceAll(s,"****");
                            }

                        }
                    }
                    return value;
                }
                return method.invoke(servletRequest,args);
            }
        });
//        资源放行
        filterChain.doFilter(proxyReq,servletResponse);


    }
}
