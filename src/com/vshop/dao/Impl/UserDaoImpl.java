package com.vshop.dao.Impl;

import com.vshop.dao.IUserDao;
import com.vshop.util.db.JdbcUtil;

/**
 * @ClassName UserDaoImpl
 * @Description
 * @Author Wangyw
 */
public class UserDaoImpl implements IUserDao {

    private JdbcUtil jdbcUtil;

    public UserDaoImpl(JdbcUtil jdbcUtil) {
        this.jdbcUtil = jdbcUtil;
    }

    @Override
    public String login(String user_id,String user_pass) {

        String sql = "select password from tuser where user_id = ?";
        Object o = jdbcUtil.executeQuery(sql, user_id);

        if( o== null){
            return "1";//用户名错误
        }else{
            if(o.toString().equals(user_pass)){
                return "3";//正确
            }else{
                return "2";//密码错误
            }
        }

    }
}
