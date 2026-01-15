package com.qingcen.poachedegg.myblog.service.impl;

import com.qingcen.poachedegg.myblog.dao.UserDao;
import com.qingcen.poachedegg.myblog.pojo.User;
import com.qingcen.poachedegg.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User login(String loginmsg) {
        System.out.println("===== 进入Service层 =====");
        ObjectMapper mapper = new ObjectMapper();
        // 解析为Message对象
        User user = mapper.readValue(loginmsg, User.class);
        System.out.println("解析成功:");
        System.out.println("用户账号: " + user.getUserAccount());
        System.out.println("用户密码: " + user.getUserPassword());
        return userDao.Userlogin(user);
    }

    @Override
    public Boolean register(String regmsg) {
        System.out.println("===== 进入Service层 =====");
        ObjectMapper mapper = new ObjectMapper();
        // 解析为Message对象
        User user = mapper.readValue(regmsg, User.class);
        System.out.println("解析成功:");
        System.out.println("用户名称: " + user.getUserName());
        System.out.println("用户账号: " + user.getUserAccount());
        System.out.println("用户密码: " + user.getUserPassword());
        List<User> users = userDao.UserRegister(user);

        if (users.isEmpty()){
            System.out.println("用户不存在,通过注册");
            if (userDao.AddUser(user)){
                System.out.println("用户添加成功");
                return true;
            }else {
                System.out.println("用户添加失败");
                return false;
            }
        }else {
            System.out.println("用户存在,注册失败");
            return false;
        }
    }
}
