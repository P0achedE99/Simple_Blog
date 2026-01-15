package com.qingcen.poachedegg.myblog.controller;

import com.qingcen.poachedegg.myblog.pojo.Message;
import com.qingcen.poachedegg.myblog.service.MessageService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/submitMessage")
    public String submitMessage(@RequestBody String rawBody, HttpServletRequest request){
        System.out.println("===== 用户提交留言 =====");
        System.out.println("发起请求的IP: " + request.getRemoteAddr());
        System.out.println("请求方法: " + request.getMethod());
        System.out.println("--- 请求体（原始） ---");
        System.out.println(rawBody);
        String str = messageService.submitMessage(rawBody);
        System.out.println(str);
        System.out.println("===== 添加请求结束 返回数据 =====");
        if (str.equals("非法用户")){
            return "illegalUser";
        } else if (str.equals("添加成功")) {
            return "submitSuccess";
        } else{
            return "submitFailed";
        }
    }

    @GetMapping("/getMessage")
    public List<Message> getAllMessage(){
        List<Message> messageList = messageService.findAll();
        return messageList;
    }

    @PostMapping("/getUsersMessage")
    public List<Message> getUsersMessage(@RequestBody String rawBody, HttpServletRequest request){
        System.out.println("===== 用户申请留言 =====");
        System.out.println("发起请求的IP: " + request.getRemoteAddr());
        System.out.println("请求方法: " + request.getMethod());
        System.out.println("--- 请求体（原始） ---");
        System.out.println(rawBody);
        List<Message> messageList = messageService.findUsers(rawBody);
        System.out.println("===== 添加请求结束 返回数据 =====");
        return messageList;
    }

    @PostMapping("/deleteMessage")
    public String deleteMessage(@RequestBody String rawBody, HttpServletRequest request){
        System.out.println("===== 用户删除留言 =====");
        System.out.println("发起请求的IP: " + request.getRemoteAddr());
        System.out.println("请求方法: " + request.getMethod());
        System.out.println("--- 请求体（原始） ---");
        System.out.println(rawBody);
        String str = messageService.deleteById(rawBody);
        System.out.println("===== 添加请求结束 返回数据 =====");
        if (str == null){
            return "illegalUser";
        } else if (str.equals("删除成功")) {
            return "deleteSuccess";
        } else{
            return "deleteFailed";
        }
    }

    @PostMapping("/updateMessage")
    public String updateMessage(@RequestBody String rawBody, HttpServletRequest request){
        System.out.println("===== 用户修改留言 =====");
        System.out.println("发起请求的IP: " + request.getRemoteAddr());
        System.out.println("请求方法: " + request.getMethod());
        System.out.println("--- 请求体（原始） ---");
        System.out.println(rawBody);
        String str = messageService.updateById(rawBody);
        System.out.println("===== 修改请求结束 返回数据 =====");
        if (str == null){
            return "illegalUser";
        } else if (str.equals("修改成功")) {
            return "updateSuccess";
        } else{
            return "updateFailed";
        }
    }
}
