package top.soft.bookonline.dao;

import top.soft.bookonline.entity.Book;

import java.util.List;

public interface BookDao {

    /**
     * 查询所有图书
     * @return List<Book>
     */
    List<Book> selectAll();


    /**
     * 根据 id 查询图书
     * @param id 图书id
     * @return Book
     */
    Book getBookById(Integer id);
}
