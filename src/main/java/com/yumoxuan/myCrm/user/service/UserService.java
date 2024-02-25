package com.yumoxuan.myCrm.user.service;

import com.yumoxuan.myCrm.user.entity.User;

import java.util.List;

public interface UserService {
    public List<User> queryUser(String id);
}
