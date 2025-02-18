package com.yumoxuan.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yumoxuan.core.aspect.annotation.DistributedLock;
import com.yumoxuan.user.entity.MyAppUser;
import com.yumoxuan.user.service.IMyAppUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Description: my_app_user
 * @Author: jeecg-boot
 * @Date:   2024-04-10
 * @Version: V1.0
 */
@Api(tags="用户模块")
@RestController
@RequestMapping("/myAppUser")
@Slf4j
public class  MyAppUserController {
	@Autowired
	private IMyAppUserService myAppUserService;

	/**
	 * 分页列表查询
	 *
	 * @param myAppUser
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@ApiOperation(value="my_app_user-分页列表查询", notes="my_app_user-分页列表查询")
	@GetMapping(value = "/list")
	public List<MyAppUser> queryPageList(MyAppUser myAppUser,
	                               @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
	                               @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
	                               HttpServletRequest req) {
		LambdaQueryWrapper<MyAppUser> queryWrapper=new LambdaQueryWrapper<>();
		List<MyAppUser> list = myAppUserService.list(queryWrapper);
		return list;
	}

	/**
	 *   添加
	 *
	 * @param myAppUser
	 * @return
	 */
	@ApiOperation(value="my_app_user-添加", notes="my_app_user-添加")
	@PostMapping(value = "/add")
	@DistributedLock(name = "添加分布式锁",key = {"userId"})
	public String add(@RequestBody MyAppUser myAppUser, String userId) {
		log.info(Thread.currentThread().getId()+" "+new Date());
		try {
			Thread.sleep(5000);
			myAppUserService.save(myAppUser);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *  编辑
	 *
	 * @param myAppUser
	 * @return
	 */
	@ApiOperation(value="my_app_user-编辑", notes="my_app_user-编辑")
	@PutMapping(value = "/edit")
	public String edit(@RequestBody MyAppUser myAppUser) {
		myAppUserService.updateById(myAppUser);
		return null;
	}

	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@ApiOperation(value="my_app_user-通过id删除", notes="my_app_user-通过id删除")
	@DeleteMapping(value = "/delete")
	public String delete(@RequestParam(name="id",required=true) String id) {
		myAppUserService.removeById(id);
		return null;
	}

	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */

	@ApiOperation(value="my_app_user-批量删除", notes="my_app_user-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public String deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.myAppUserService.removeByIds(Arrays.asList(ids.split(",")));
		return null;
	}

	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@ApiOperation(value="my_app_user-通过id查询", notes="my_app_user-通过id查询")
	@GetMapping(value = "/queryById")
	public String queryById(@RequestParam(name="id",required=true) String id) {
		MyAppUser myAppUser = myAppUserService.getById(id);

		return null;
	}

	@ApiOperation(value="测试事务扩散机制", notes="测试事务扩散机制")
	@GetMapping(value = "/testTransaction")
	public String testTransaction() {
		myAppUserService.testA();
		return "ok";
	}
	@ApiOperation(value="测试事务扩散机制", notes="测试事务扩散机制")
	@GetMapping(value = "/testTransaction1")
	public String testTransaction1() {
		myAppUserService.testB();
		return "ok";
	}
}
