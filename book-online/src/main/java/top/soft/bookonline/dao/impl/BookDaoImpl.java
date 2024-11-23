package top.soft.bookonline.dao.impl;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import top.soft.bookonline.dao.BookDao;
import top.soft.bookonline.entity.Book;
import top.soft.bookonline.util.JdbcUtil;

import java.util.List;

/**
 * @author ycshang
 * @description: 操作数据库中 book 表的类
 * @date 2024-09-19 上午10:19
 */
public class BookDaoImpl implements BookDao {

    /**
     * 声明JDBCTemplate对象
     */
    private final JdbcTemplate template = new JdbcTemplate(JdbcUtil.getDataSource());

    @Override
    public List<Book> selectAll() {
        String sql = "SELECT * FROM t_book ORDER BY id DESC";
        return template.query(sql, new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public Book getBookById(int id) {
        String sql = "SELECT * FROM t_book WHERE id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
    }
}
