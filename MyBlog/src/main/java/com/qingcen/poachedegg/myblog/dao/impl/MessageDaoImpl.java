package com.qingcen.poachedegg.myblog.dao.impl;

import com.qingcen.poachedegg.myblog.dao.MessageDao;
import com.qingcen.poachedegg.myblog.mapper.MessageMapper;
import com.qingcen.poachedegg.myblog.mapper.UserMapper;
import com.qingcen.poachedegg.myblog.pojo.Message;
import com.qingcen.poachedegg.myblog.pojo.User;
import com.qingcen.poachedegg.myblog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageDaoImpl implements MessageDao {


    @Autowired
    private MessageMapper messageMapper;

    @Override
    public String addMessage(Message message) {
        System.out.println("===== DAO留言添加 =====");
        System.out.println(message);
        Integer result = messageMapper.addMessage(message);
        if (result == null) {
            return "添加失败";
        } else {
            return "添加成功";
        }
    }

    @Override
    public List<Message> findAll() {
        List<Message> lists = messageMapper.findAll();
        return lists;
    }

    @Override
    public List<Message> findUsers(Message message) {
        List<Message> lists = messageMapper.findUsers(message);
        return lists;
    }

    @Override
    public String deleteById(Integer id) {
        Integer result = messageMapper.deleteById(id);
        if (result == null) {
            return "删除失败";
        } else {
            return "删除成功";
        }
    }

    @Override
    public String updateById(Integer id, String message) {
        Integer result = messageMapper.updateById(id,message);
        if (result == null) {
            return "修改失败";
        } else {
            return "修改成功";
        }
    }
}
