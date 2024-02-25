package com.yumoxuan.myCrm.user.controller;

import com.yumoxuan.myCrm.user.entity.User;
import com.yumoxuan.myCrm.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @GetMapping("/queryUser")
    public User queryUser(String id){
        return userService.queryUser(id);
    }
}
