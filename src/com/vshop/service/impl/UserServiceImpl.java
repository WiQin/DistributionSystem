package com.vshop.service.impl;

import com.vshop.dao.IUserDao;
import com.vshop.dao.Impl.UserDaoImpl;
import com.vshop.entity.User;
import com.vshop.service.IUserService;
import com.vshop.util.db.JdbcUtil;

/**
 * @ClassName UserServiceImpl
 * @Description
 * @Author Wangyw
 */
public class UserServiceImpl implements IUserService {

    IUserDao iUserDao;

    @Override
    public String login(String user_id, String user_pass) {
        iUserDao = new UserDaoImpl(JdbcUtil.getInstance());
        return iUserDao.login(user_id,user_pass);
    }

    @Override
    public User getUserById(String user_id) {
        iUserDao = new UserDaoImpl(JdbcUtil.getInstance());
        return iUserDao.getUserById(user_id);
    }

    @Override
    public boolean saveUserInfo(User user) {
        iUserDao = new UserDaoImpl(JdbcUtil.getInstance());
        return iUserDao.saveUserInfo(user);
    }

    @Override
    public boolean addUser(User user) {
        iUserDao = new UserDaoImpl(JdbcUtil.getInstance());
        return iUserDao.addUser(user);
    }

    @Override
    public boolean updateLeft_num(int right_num,int id) {
        iUserDao = new UserDaoImpl(JdbcUtil.getInstance());
        return iUserDao.updateLeft_num(right_num,id);
    }

    @Override
    public boolean updateRight_num(int left_num,int id) {
        iUserDao = new UserDaoImpl(JdbcUtil.getInstance());
        return iUserDao.updateRight_num(left_num,id);
    }
}
