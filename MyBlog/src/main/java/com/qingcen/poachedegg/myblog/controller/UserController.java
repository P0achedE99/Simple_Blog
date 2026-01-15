package com.qingcen.poachedegg.myblog.controller;

import com.qingcen.poachedegg.myblog.pojo.User;
import com.qingcen.poachedegg.myblog.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public User UserLogin(@RequestBody String rawBody, HttpServletRequest request){
        System.out.println("===== 用户登录 =====");
        System.out.println("发起请求的IP: " + request.getRemoteAddr());
        System.out.println("请求方法: " + request.getMethod());
        System.out.println("--- 请求体（原始） ---");
        System.out.println(rawBody);
        User user = userService.login(rawBody);
        System.out.println("===== 登录请求结束 返回数据 =====");
        return user;
    }

    @PostMapping("/register")
    public String UserRegister(@RequestBody String rawBody, HttpServletRequest request){
        System.out.println("===== 用户注册 =====");
        System.out.println("发起请求的IP: " + request.getRemoteAddr());
        System.out.println("请求方法: " + request.getMethod());
        System.out.println("--- 请求体（原始） ---");
        System.out.println(rawBody);
        Boolean flag = userService.register(rawBody);
        System.out.println("===== 注册请求结束 返回数据 =====");
        if (flag){
            return "registerSuccess";
        }else {
            return "registerFailed";
        }
    }
}
