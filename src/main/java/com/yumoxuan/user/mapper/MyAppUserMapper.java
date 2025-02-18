package com.yumoxuan.user.mapper;

import com.yumoxuan.user.entity.MyAppUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @Description: my_app_user
 * @Author: jeecg-boot
 * @Date:   2024-04-10
 * @Version: V1.0
 */
public interface MyAppUserMapper extends BaseMapper<MyAppUser> {
	List<MyAppUser> queryList();
}
