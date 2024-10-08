package top.soft.bookonline.service.impl;


import top.soft.bookonline.dao.UserDao;
import top.soft.bookonline.dao.impl.UserDaoImpl;
import top.soft.bookonline.entity.User;
import top.soft.bookonline.service.UserService;

/**
 * @author ycshang
 * @description: 用户业务逻辑类
 * @date 2024-09-19 上午10:26
 */
public class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDaoImpl();

    /**
     * 用户登录功能
     * @param account  账号
     * @param password 密码
     * @return
     */
    @Override
    public User signIn(String account, String password) {
        User user = User.builder().account(account).password(password).build();
        return userDao.findUser(user);
    }
}
