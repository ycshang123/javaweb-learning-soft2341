package top.soft.bookonline.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.soft.bookonline.entity.Book;
import top.soft.bookonline.service.BookService;
import top.soft.bookonline.service.impl.BookServiceImpl;

import java.io.IOException;
import java.util.List;

/**
 * @author ycshang
 * @description: TODO
 * @date 2024-09-19 上午10:49
 */

@WebServlet(urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookService bookService = new BookServiceImpl();
        //   取得全局应用对象的变量
        List<Book> bookList = bookService.getBooks();
        //    存入request
        req.setAttribute("bookList", bookList);
        //    通过服务器端转发，将数据带过去，保持地址栏不变
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}