package com.vshop.service;

import com.vshop.entity.User;

public interface IUserService {
    public String login(String user_id,String user_pass);
    public User getUserByUserId(String user_id);
    public boolean saveUserInfo(User user);
    public boolean addUser(User user);

    //更新左下标
    public boolean updateLeft_num(int right_num,int id);

    //更新右下标
    public boolean updateRight_num(int left_num,int id);
}
