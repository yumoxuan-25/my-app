package com.yumoxuan.myCrm.user.service.impl;

import com.yumoxuan.myCrm.user.entity.User;
import com.yumoxuan.myCrm.user.mapper.UserMapper;
import com.yumoxuan.myCrm.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User queryUser(String id) {
        return userMapper.selectById(id);
    }
}
