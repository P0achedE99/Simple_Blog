package com.qingcen.poachedegg.myblog.mapper;


import com.qingcen.poachedegg.myblog.pojo.Message;

import java.util.List;

public interface MessageMapper {
    Integer addMessage(Message message);

    List<Message> findAll();

    List<Message> findUsers(Message message);

    Integer deleteById(Integer id);

    Integer updateById(Integer id,String message);
}
