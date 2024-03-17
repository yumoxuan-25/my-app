package com.yumoxuan.user.controller;

import com.yumoxuan.user.entity.User;
import com.yumoxuan.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api(tags = "用户模块")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * test connect to mysql
     *
     * @param id
     * @return
     */
    @GetMapping("/queryUser")
    public List<User> queryUser(String id){
        return userService.queryUser(id);
    }

    @ApiOperation(value = "查询用户详情", notes = "查询用户详情")
    @GetMapping("/queryById")
    public User queryById(@ApiParam(value = "id") String id){
        return userService.queryById(id);
    }
}
