package com.vshop.dao;

import com.vshop.entity.User;

public interface IUserDao {
    /**
    * @Author Wangyw
    * @Description 用户接口
    * @Date 2019/5/21 0021
    * @Param 
    * @Return 
    **/

    public String login(String user_id,String user_pass);

    public User getUserById(String user_id);

    public boolean saveUserInfo(User user);
}
