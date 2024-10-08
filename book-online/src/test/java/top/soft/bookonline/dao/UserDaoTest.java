package top.soft.bookonline.dao;

import org.junit.jupiter.api.Test;
import top.soft.bookonline.dao.impl.UserDaoImpl;
import top.soft.bookonline.entity.User;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    @Test
    void insertUser() {
        UserDao userDao = new UserDaoImpl();
        User user = User.builder().nickname("syc").password("123456").address("江苏南京")
                .avatar("https://charging-zhzc.oss-cn-beijing.aliyuncs.com/chargingAdmin/672fbdbb-c38f-4936-800a-6993fadbeaf4.png").account("syc").build();
        userDao.insertUser(user);
    }
}