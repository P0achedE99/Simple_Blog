package com.qingcen.poachedegg.myblog.service;

import com.qingcen.poachedegg.myblog.pojo.User;

public interface UserService {
    public User login(String loginmsg);

    public Boolean register(String regmsg);
}
