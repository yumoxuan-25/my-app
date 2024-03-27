package com.yumoxuan.myapp.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yumoxuan.myapp.user.entity.User;

import java.util.List;

public interface UserService extends IService<User>{
    List<User> queryUser(String id);

    User queryById(String id);
}
