package top.soft.bookonline.service;

import top.soft.bookonline.entity.Book;

import java.util.List;

public interface BookService {

    /**
     * 查询所有图书
     *
     * @return 图书列表
     */
    List<Book> getBooks();

    /**
     * 根据 id 查询图书
     *
     * @param id id
     * @return 图书信息
     */
    Book getBookById(int id);
}
