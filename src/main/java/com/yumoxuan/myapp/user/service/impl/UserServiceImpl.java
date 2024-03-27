package com.yumoxuan.myapp.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yumoxuan.myapp.user.entity.User;
import com.yumoxuan.myapp.user.mapper.UserMapper;
import com.yumoxuan.myapp.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(rollbackFor = Exception.class)
    public User queryById(String id) {
        save1();
        return this.getById(id);
    }
    private void save1(){
        User user=new User();
        user.setName("123456");
        user.setAge(50);

        this.save(user);
        User user1=new User();
        user1.setAge(80);
        user1.setName("lalla");

        this.save(user1);
    }
}
