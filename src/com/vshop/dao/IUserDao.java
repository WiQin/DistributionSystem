package com.vshop.dao;

import com.vshop.entity.User;

import java.util.List;

public interface IUserDao {
    /**
    * @Author Wangyw
    * @Description 用户接口
    * @Date 2019/5/21 0021
    * @Param 
    * @Return 
    **/

    public String login(String user_id,String user_pass);

    public User getUserByUserId(String user_id);

    public boolean saveUserInfo(User user);

    public boolean addUser(User user);

    //更新左下标
    public boolean updateLeft_num(int right_num,int id);

    //更新右下标
    public boolean updateRight_num(int left_num,int id);

    //根据用户账号查询该用户所在的属性结构的层级数
    public int getUserLevelByUserId(String user_id);

    //根据用户账号更新用户层级数
    public boolean updateUser_level(int user_level,String user_id);

    //查询当前用户下的子节点集合
    public List<User> getList(int left_num,int right_num,int user_level);
}
