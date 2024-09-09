package top.soft.bookonline.dao;

import org.junit.jupiter.api.Test;
import top.soft.bookonline.dao.impl.UserDaoImpl;
import top.soft.bookonline.entity.User;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    @Test
    void insertUser() {
        User user = new User().builder().account("1212@qq.com").address("江苏南京").password("123456").nickname("ycshang").avatar("xxx.png").build();
        UserDao userDao = new UserDaoImpl();
        int i = userDao.insertUser(user);
    }

    @Test
    void findUser() {
    }
}