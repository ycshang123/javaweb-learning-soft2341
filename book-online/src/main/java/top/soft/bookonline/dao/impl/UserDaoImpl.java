package top.soft.bookonline.dao.impl;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import top.soft.bookonline.dao.UserDao;
import top.soft.bookonline.entity.User;
import top.soft.bookonline.util.JdbcUtil;
import top.soft.bookonline.util.Md5Util;

/**
 * @author ycshang
 * @description: UserDaoImpl 实现类
 * @date 2024-09-19 上午10:10
 */
public class UserDaoImpl implements UserDao {

    /**
     * 声明 JDBCTemplate 对象
     */
    private final JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtil.getDataSource());

    @Override
    public int insertUser(User user) {
//        1、编写 SQL
        String sql = "INSERT INTO t_user(account,password,nickname,avatar) VALUES (?,?,?,?)";

        return jdbcTemplate.update(sql, user.getAccount(), Md5Util.crypt(user.getPassword()), user.getNickname(), user.getAvatar());
    }

    @Override
    public User findUser(User userDto) {
//        1、编写 SQL
        String sql = "SELECT * FROM t_user WHERE account = ? AND password = ?";
//        2、调用 query 方法，对比账号和加密后的密码
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), userDto.getAccount(), Md5Util.crypt(userDto.getPassword()));
    }
}
