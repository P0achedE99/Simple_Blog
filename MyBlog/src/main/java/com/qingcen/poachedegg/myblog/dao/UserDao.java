package com.qingcen.poachedegg.myblog.dao;

import com.qingcen.poachedegg.myblog.pojo.User;

import java.util.List;

public interface UserDao {
    public User Userlogin(User user);
    public List<User> UserRegister(User user);
    public Boolean AddUser(User user);
}
