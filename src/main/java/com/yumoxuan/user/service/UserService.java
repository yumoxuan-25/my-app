package com.yumoxuan.user.service;

import com.yumoxuan.user.entity.User;

import java.util.List;

public interface UserService {
    public List<User> queryUser(String id);
}
