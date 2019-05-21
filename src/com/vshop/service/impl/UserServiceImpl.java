package com.vshop.service.impl;

import com.vshop.dao.IUserDao;
import com.vshop.dao.Impl.UserDaoImpl;
import com.vshop.service.IUserService;

/**
 * @ClassName UserServiceImpl
 * @Description
 * @Author Wangyw
 */
public class UserServiceImpl implements IUserService {
    @Override
    public String login(String user_id, String user_pass) {
        IUserDao iUserDao = new UserDaoImpl();
        return iUserDao.login(user_id,user_pass);
    }
}
