package top.soft.bookonline.service.impl;


import top.soft.bookonline.dao.BookDao;
import top.soft.bookonline.dao.impl.BookDaoImpl;
import top.soft.bookonline.entity.Book;
import top.soft.bookonline.service.BookService;

import java.util.List;

/**
 * @author ycshang
 * @description: 图书实现类
 * @date 2024-09-19 上午10:30
 */
public class BookServiceImpl implements BookService {
    private final BookDao bookDao = new BookDaoImpl();

    /**
     * 获取图书列表
     *
     * @return
     */
    @Override
    public List<Book> getBooks() {
        return bookDao.selectAll();
    }

    /**
     * 根据id 获取图书信息
     *
     * @param id id
     * @return
     */
    @Override
    public Book getBookById(int id) {
        return bookDao.getBookById(id);
    }
}
