package com.vshop.entity;

/**
 * @ClassName User
 * @Description
 * @Author Wangyw
 */
public class User {
    private int id;
    private String user_id;
    private String user_pass;
    private int level;
    private int left_num;
    private int right_num;
    private String user_name;
    private String user_birthday;
    private int user_faq;
    private String user_answer;
    private String user_city;
    private String user_creator;
    private long create_time;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLeft_num() {
        return left_num;
    }

    public void setLeft_num(int left_num) {
        this.left_num = left_num;
    }

    public int getRight_num() {
        return right_num;
    }

    public void setRight_num(int right_num) {
        this.right_num = right_num;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(String user_birthday) {
        this.user_birthday = user_birthday;
    }

    public int getUser_faq() {
        return user_faq;
    }

    public void setUser_faq(int user_faq) {
        this.user_faq = user_faq;
    }

    public String getUser_answer() {
        return user_answer;
    }

    public void setUser_answer(String user_answer) {
        this.user_answer = user_answer;
    }

    public String getUser_city() {
        return user_city;
    }

    public void setUser_city(String user_city) {
        this.user_city = user_city;
    }

    public String getUser_creator() {
        return user_creator;
    }

    public void setUser_creator(String user_creator) {
        this.user_creator = user_creator;
    }

    public long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }
}
