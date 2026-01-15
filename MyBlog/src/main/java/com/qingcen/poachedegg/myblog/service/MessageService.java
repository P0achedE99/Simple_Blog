package com.qingcen.poachedegg.myblog.service;

import com.qingcen.poachedegg.myblog.pojo.Message;

import java.util.List;

public interface MessageService {
     String submitMessage(String submitmsg);

     List<Message> findAll();

     List<Message> findUsers(String userInfo);

     String deleteById(String userMsg);

     String updateById(String userMsg);

}
