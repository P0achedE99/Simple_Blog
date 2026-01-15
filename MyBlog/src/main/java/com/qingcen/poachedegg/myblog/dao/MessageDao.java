package com.qingcen.poachedegg.myblog.dao;

import com.qingcen.poachedegg.myblog.pojo.Message;

import java.util.List;

public interface MessageDao {
    String addMessage(Message message);

    List<Message> findAll();

    List<Message> findUsers(Message message);

    String deleteById(Integer id);

    String updateById(Integer id,String message);
}
