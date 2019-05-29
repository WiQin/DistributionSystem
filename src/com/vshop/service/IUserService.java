package com.vshop.service;

import com.vshop.entity.User;

public interface IUserService {
    public String login(String user_id,String user_pass);
    public User getUserById(String user_id);
    public boolean saveUserInfo(User user);
}
