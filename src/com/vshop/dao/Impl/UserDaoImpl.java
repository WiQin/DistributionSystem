package com.vshop.dao.Impl;

import com.vshop.dao.IUserDao;

/**
 * @ClassName UserDaoImpl
 * @Description
 * @Author Wangyw
 */
public class UserDaoImpl implements IUserDao {
    @Override
    public String login(String user_id,String user_pass) {

        String sql = "select user_pass from user where user_id = ?";

        if( sql== null){
            return "1";//用户名错误
        }else{
            if(sql.toString().equals(user_pass)){
                return "3";//正确
            }else{
                return "2";//密码错误
            }
        }

    }
}
