package top.soft.bookonline.dao.impl;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import top.soft.bookonline.dao.BookDao;
import top.soft.bookonline.entity.Book;
import top.soft.bookonline.util.JdbcUtil;

import java.util.List;

/**
 * @author ycshang
 * @description: 操作数据库中 book 实现类
 * @date 2024-09-04 下午3:31
 */
public class BookDaoImpl implements BookDao {

    /**
     * 声明 JDBCTemplate 对象
     */
    private final  JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtil.getDataSource());


    /**
     * 获取所有图书
     * @return List<Book>
     */
    @Override
    public List<Book> selectAll() {
        try{
            String sql = "SELECT * FROM t_book ORDER BY id DESC";
            return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Book.class));
        } catch (DataAccessException e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Book getBookById(Integer id) {
       try{
           String sql = "SELECT * FROM t_book WHERE id = ?";
           return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Book.class),id);
       } catch (DataAccessException e){
           e.printStackTrace();
           return null;
       }
    }
}
