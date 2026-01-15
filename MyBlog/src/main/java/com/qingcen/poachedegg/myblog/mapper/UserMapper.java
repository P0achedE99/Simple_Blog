package com.qingcen.poachedegg.myblog.mapper;

import com.qingcen.poachedegg.myblog.pojo.User;

import java.util.List;

public interface UserMapper {
    /**
     * 是否存在匹配项
     * @param user
     * @return true&false
     */
    public User isExistence(User user);

    /**
     * 添加用户
     * @param user
     */
    public void addUser(User user);

    /**
     * 检查用户名或账号是否重复
     * @param user
     * @return
     */
    public List<User> IsDuplicateUser(User user);

}
