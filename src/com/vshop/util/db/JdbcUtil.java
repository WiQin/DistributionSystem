package com.vshop.util.db;

import java.sql.*;
import java.util.Properties;

/**
 * @ClassName JdbcUtil
 * @Description  数据库操作
 * @Author Wangyw
 */
public class JdbcUtil {
    private static JdbcUtil instance = null;

    //数据库连接信息
    private static String driver = "";
    private static String url = "";
    private static String userName = "";
    private static String passWord = "";

    //数据库连接对象
    private Connection conn = null;
    //PreparedStatement对象
    private PreparedStatement ps = null;
    //结果集对象
    private ResultSet rs = null;

    public static JdbcUtil getInstance(){
        if(instance == null){
            instance = new JdbcUtil();
        }
        return instance;
    }

    private JdbcUtil(){
        Properties properties = new Properties();

        try {
            properties.load(JdbcUtil.class.getResourceAsStream("/property.properties"));

            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            userName = properties.getProperty("userName");
            passWord = properties.getProperty("passWord");

            //加载驱动
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //建立连接
    public Connection getConnection(){
        try {
            conn = DriverManager.getConnection(url,userName,passWord);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //关闭资源
    public void close(){
        try{
            if(rs != null){
                rs.close();
            }
            if(ps != null){
                ps.close();
            }
            if(conn != null){
                conn.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 增删改的通用方法
     *
     * @param sql
     * @param objects
     * @return
     */
    public int executeUpdate(String sql, Object... objects) {
        int result = 0;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            if (objects != null) {
                for (int i = 0; i < objects.length; i++) {
                    ps.setObject(i + 1, objects[i]); // 下标从1开始的
                }
            }
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return result;
    }

    /**
     * 查询通用的方法
     *
     * @param sql
     * @param rsHandler
     * @param objects
     * @return
     */
    public Object executeQuery(String sql, IResultSetUtil rsHandler,
                                      Object... objects) {

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            if (objects != null) {
                for (int i = 0; i < objects.length; i++) {
                    ps.setObject(i + 1, objects[i]);

                }
            }
            rs = ps.executeQuery();

            return rsHandler.doHandler(rs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    /**
     * 查询单个字段值通用的方法
     *
     * @param sql
     * @param objects
     * @return
     */
    public Object executeQuery(String sql, Object... objects) {
        return executeQuery(sql, new IResultSetUtil() {
            @Override
            public Object doHandler(ResultSet rs) throws SQLException {
                Object object = null;
                if (rs.next()) {
                    object = rs.getObject(1);
                }
                return object;
            }
        }, objects);
    }

}
