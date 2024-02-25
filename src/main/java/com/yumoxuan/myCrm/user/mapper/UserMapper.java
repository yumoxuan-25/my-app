package com.yumoxuan.myCrm.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yumoxuan.myCrm.user.entity.User;

import java.util.List;


public interface UserMapper extends BaseMapper<User> {
    List<User> queryUser();
}
