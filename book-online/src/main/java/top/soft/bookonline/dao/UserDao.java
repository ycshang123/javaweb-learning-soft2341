package top.soft.bookonline.dao;

import top.soft.bookonline.entity.User;

public interface UserDao {

    /**
     * 新增用户
     * @param user 入参对象
     * @return 受影响的记录行数
     */
    int insertUser(User user);

    /**
     * 根据条件查找用户
     * @param userDto 条件封装对象
     * @return 用户对象
     */
    User findUser(User userDto);
}
