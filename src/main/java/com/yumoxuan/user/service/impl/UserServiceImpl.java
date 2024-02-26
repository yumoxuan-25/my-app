package com.yumoxuan.user.service.impl;

import com.yumoxuan.user.entity.User;
import com.yumoxuan.user.mapper.UserMapper;
import com.yumoxuan.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> queryUser(String id) {
        return userMapper.queryUser();
    }
}
