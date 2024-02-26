package com.yumoxuan.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yumoxuan.user.entity.User;

import java.util.List;


public interface UserMapper extends BaseMapper<User> {
    List<User> queryUser();
}
