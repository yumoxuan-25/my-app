package com.yumoxuan.myapp.user.controller;

import com.yumoxuan.myapp.common.Result;
import com.yumoxuan.myapp.core.aspect.annotation.DistributedLock;
import com.yumoxuan.myapp.user.entity.MyAppUser;
import com.yumoxuan.myapp.user.service.IMyAppUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

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
	public Result<?> queryPageList(MyAppUser myAppUser,
	                               @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
	                               @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
	                               HttpServletRequest req) {

		return Result.ok();
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
	public Result<?> add(@RequestBody MyAppUser myAppUser, String userId) {
		log.info(Thread.currentThread().getId()+" "+new Date());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return Result.ok();
	}

	/**
	 *  编辑
	 *
	 * @param myAppUser
	 * @return
	 */
	@ApiOperation(value="my_app_user-编辑", notes="my_app_user-编辑")
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody MyAppUser myAppUser) {
		myAppUserService.updateById(myAppUser);
		return Result.ok();
	}

	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@ApiOperation(value="my_app_user-通过id删除", notes="my_app_user-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		myAppUserService.removeById(id);
		return Result.ok();
	}

	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */

	@ApiOperation(value="my_app_user-批量删除", notes="my_app_user-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.myAppUserService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.ok();
	}

	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@ApiOperation(value="my_app_user-通过id查询", notes="my_app_user-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		MyAppUser myAppUser = myAppUserService.getById(id);

		return Result.ok();
	}


}
