package com.yumoxuan.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yumoxuan.user.entity.User;
import com.yumoxuan.user.mapper.UserMapper;
import com.yumoxuan.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> queryUser(String id) {
        System.out.println(1);
        return userMapper.queryUser();
    }

    @Override
    public User queryById(String id) {
        return this.getById(id);
    }
}
