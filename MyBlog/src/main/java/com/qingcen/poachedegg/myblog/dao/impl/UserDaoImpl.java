package com.qingcen.poachedegg.myblog.dao.impl;

import com.qingcen.poachedegg.myblog.dao.UserDao;
import com.qingcen.poachedegg.myblog.mapper.UserMapper;
import com.qingcen.poachedegg.myblog.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User Userlogin(User user) {
        System.out.println("===== 进入DAO层 =====");
        System.out.println(user);
        User getUser = userMapper.isExistence(user);
        System.out.println(getUser);
        return getUser;
    }

    @Override
    public List<User> UserRegister(User user) {
        System.out.println("===== 进入DAO层 =====");
        System.out.println(user);
        List<User> users = userMapper.IsDuplicateUser(user);
        System.out.println(users);
        return users;
    }

    @Override
    public Boolean AddUser(User user) {
        System.out.println("===== DAO用户添加 =====");
        System.out.println(user);
        userMapper.addUser(user);
        Integer id = user.getId();
        if (id != null){
            return false;
        }else {
            return true;
        }
    }
}
