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

    public boolean addUser(User user);

    //更新左下标
    public boolean updateLeft_num(int right_num,int id);

    //更新右下标
    public boolean updateRight_num(int left_num,int id);
}
