package com.qingcen.poachedegg.myblog.service.impl;

import com.qingcen.poachedegg.myblog.dao.MessageDao;
import com.qingcen.poachedegg.myblog.mapper.UserMapper;
import com.qingcen.poachedegg.myblog.pojo.Message;
import com.qingcen.poachedegg.myblog.pojo.User;
import com.qingcen.poachedegg.myblog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;
    @Autowired
    private UserMapper userMapper;

    @Override
    public String submitMessage(String submitmsg) {
        System.out.println("===== 进入Service层 =====");
        ObjectMapper mapper = new ObjectMapper();
        // 解析为Message对象
        Message message = mapper.readValue(submitmsg, Message.class);
        System.out.println("解析成功:");
        System.out.println("用户账号: " + message.getUserAccount());
        System.out.println("用户密码: " + message.getUserPassword());
        System.out.println("用户名称: " + message.getUserName());
        System.out.println("用户消息: " + message.getMessage());
        System.out.println("----- 验证用户合法性 -----");
        User user = new User();
        user.setUserName(message.getUserName());
        user.setUserAccount(message.getUserAccount());
        user.setUserPassword(message.getUserPassword());
        User getUser = userMapper.isExistence(user);
        if (getUser == null){
            return "非法用户";
        }
        System.out.println("用户合法 准备进入DAO层");
        String str = messageDao.addMessage(message);
        System.out.println("===== DAO层处理完毕 返回添加结果 =====");
        return str;
    }

    @Override
    public List<Message> findAll() {
        ObjectMapper mapper = new ObjectMapper();
        List<Message> messages = messageDao.findAll();
        return messages;
    }

    @Override
    public List<Message> findUsers(String userInfo) {
        System.out.println("===== 进入Service层 =====");
        ObjectMapper mapper = new ObjectMapper();
        // 解析为Message对象
        Message message = mapper.readValue(userInfo, Message.class);
        System.out.println("解析成功:");
        System.out.println("用户账号: " + message.getUserAccount());
        System.out.println("用户密码: " + message.getUserPassword());
        System.out.println("用户名称: " + message.getUserName());
        System.out.println("----- 验证用户合法性 -----");
        User user = new User();
        user.setUserName(message.getUserName());
        user.setUserAccount(message.getUserAccount());
        user.setUserPassword(message.getUserPassword());
        User getUser = userMapper.isExistence(user);
        System.out.println("用户权限组为:"+getUser.getPermission());
        if (getUser.getPermission() == 1){
            System.out.println("--- 管理员获取 ---");
            List<Message> allUsersMessages = messageDao.findAll();
            System.out.println("--- 返回所有留言 ---");
            return allUsersMessages;
        }
        if (getUser == null){
            return null;
        }
        System.out.println("用户合法 准备进入DAO层");
        List<Message> usersMessages = messageDao.findUsers(message);
        System.out.println(usersMessages);
        System.out.println("===== DAO层处理完毕 返回添加结果 =====");
        return usersMessages;
    }

    @Override
    public String deleteById(String userMsg) {
        System.out.println("===== 进入Service层 =====");
        ObjectMapper mapper = new ObjectMapper();
        // 解析为Message对象
        Message message = mapper.readValue(userMsg, Message.class);
        System.out.println("解析成功:");
        System.out.println("用户账号: " + message.getUserAccount());
        System.out.println("用户密码: " + message.getUserPassword());
        System.out.println("用户名称: " + message.getUserName());
        System.out.println("----- 验证用户合法性 -----");
        User user = new User();
        user.setUserName(message.getUserName());
        user.setUserAccount(message.getUserAccount());
        user.setUserPassword(message.getUserPassword());
        User getUser = userMapper.isExistence(user);
        if (getUser == null){
            return null;
        }
        System.out.println("用户合法 准备进入DAO层");
        String str = messageDao.deleteById(message.getId());
        System.out.println(str);
        System.out.println("===== DAO层处理完毕 返回删除结果 =====");
        return str;
    }

    @Override
    public String updateById(String userMsg) {
        System.out.println("===== 进入Service层 =====");
        ObjectMapper mapper = new ObjectMapper();
        // 解析为Message对象
        Message message = mapper.readValue(userMsg, Message.class);
        System.out.println("解析成功:");
        System.out.println("用户账号: " + message.getUserAccount());
        System.out.println("用户密码: " + message.getUserPassword());
        System.out.println("用户名称: " + message.getUserName());
        System.out.println("----- 验证用户合法性 -----");
        User user = new User();
        user.setUserName(message.getUserName());
        user.setUserAccount(message.getUserAccount());
        user.setUserPassword(message.getUserPassword());
        User getUser = userMapper.isExistence(user);
        if (getUser == null){
            return null;
        }
        System.out.println("用户合法 准备进入DAO层");
        String str = messageDao.updateById(message.getId(),message.getMessage());
        System.out.println("===== DAO层处理完毕 返回修改结果 =====");
        return str;
    }
}
