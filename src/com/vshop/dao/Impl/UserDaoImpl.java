package com.vshop.dao.Impl;

import com.vshop.dao.IUserDao;
import com.vshop.entity.User;
import com.vshop.util.db.IResultSetUtil;
import com.vshop.util.db.JdbcUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

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

    /**
    * @Author Wangyw
    * @Description 根据用户账号获取用户信息
    * @Date 2019/5/29 0029
    * @Param [user_id]
    * @Return com.vshop.entity.User
    **/
    @Override
    public User getUserById(String user_id) {
        String sql = "select user_creator,user_name,birthday,password,user_faq,user_answer,city,user_level,left_num,right_num,id from tuser where user_id =  ?";
        return (User)jdbcUtil.executeQuery(sql, new IResultSetUtil() {
            @Override
            public Object doHandler(ResultSet rs) throws SQLException {
                if(rs.next()){
                    User user = new User();
                    user.setUser_creator(rs.getString(1));
                    user.setUser_name(rs.getString(2));
                    user.setUser_birthday(rs.getString(3));
                    user.setUser_pass(rs.getString(4));
                    user.setUser_faq(rs.getInt(5));
                    user.setUser_answer(rs.getString(6));
                    user.setUser_city(rs.getString(7));
                    user.setLeft_num(rs.getInt(8));
                    user.setRight_num(rs.getInt(9));
                    user.setId(rs.getInt(10));

                    user.setUser_id(user_id);

                    return user;
                }
                return null;
            }
        }, user_id);

    }

    /**
    * @Author Wangyw
    * @Description 保存用户信息
    * @Date 2019/5/29 0029
    * @Param [ueser_id]
    * @Return boolean
    **/
    @Override
    public boolean saveUserInfo(User user) {
        String sql = "update tuser set user_name = ?,birthday = ?,user_faq = ?,user_answer = ?,city = ?,user_level = ?,left_num = ?,right_num = ? where user_id =  ?";
        return jdbcUtil.executeUpdate(sql,user.getUser_name(),user.getUser_birthday(),user.getUser_faq(),user.getUser_answer(),user.getUser_city(),user.getLevel(),user.getLeft_num(),user.getRight_num(),user.getUser_id()) > 0;

    }

    //
    @Override
    public boolean addUser(User user) {
        String sql = "INSERT INTO TUSER(USER_ID,USER_NAME,BIRTHDAY,CITY,PASSWORD,USER_CREATOR,CREATETIME,LEFT_NUM,RIGHT_NUM) VALUES (?,?,?,?,?,?,?,?,?)";
        return jdbcUtil.executeUpdate(sql,user.getUser_id(),user.getUser_name(),user.getUser_birthday(),user.getUser_city(),user.getUser_pass(),user.getUser_creator(),user.getCreate_time(),user.getLeft_num(),user.getRight_num())>0;

    }


    @Override
    public boolean updateLeft_num(int right_num,int id) {
        String sql = "update tuser set LEFT_NUM = left_num+2 where left_num >= ? AND ID <> ?";
        return jdbcUtil.executeUpdate(sql,right_num,id)>0;
    }

    @Override
    public boolean updateRight_num(int left_num,int id) {
        String sql = "update tuser set right_num = right_num+2 where right_num >= ? AND ID <> ?";
        return jdbcUtil.executeUpdate(sql,left_num,id)>0;
    }
}
