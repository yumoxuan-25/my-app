package com.yumoxuan.user.service.impl;

import com.yumoxuan.user.entity.MyAppUser;
import com.yumoxuan.user.mapper.MyAppUserMapper;
import com.yumoxuan.user.service.IMyAppUserService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: my_app_user
 * @Author: jeecg-boot
 * @Date:   2024-04-10
 * @Version: V1.0
 */
@Service
public class MyAppUserServiceImpl extends ServiceImpl<MyAppUserMapper, MyAppUser> implements IMyAppUserService {

}
