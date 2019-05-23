package com.vshop.service.impl;

import com.vshop.dao.IUserDao;
import com.vshop.dao.Impl.UserDaoImpl;
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
}
