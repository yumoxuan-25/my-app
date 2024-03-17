package com.yumoxuan.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yumoxuan.user.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserMapper extends BaseMapper<User>{
    List<User> queryUser();

    User queryById(@Param("id") String id);
}
