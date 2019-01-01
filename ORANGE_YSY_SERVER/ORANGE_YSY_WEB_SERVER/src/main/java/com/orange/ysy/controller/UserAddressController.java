package com.orange.ysy.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.orange.ysy.entity.PageBean;
import com.orange.ysy.entity.ResultBean;
import com.orange.ysy.entity.YsyUserAddress;
import com.orange.ysy.service.IUserAddressService;
import com.orange.ysy.util.ResultUtil;

import io.swagger.annotations.Api;

@Controller
// @RestController
@RequestMapping("/useraddress")
@Api(description = "用户地址信息维护")
public class UserAddressController {
	private static Logger log = LoggerFactory.getLogger(UserAddressController.class);

	@Resource
	private IUserAddressService useraddressService;

	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResultBean addUserAddress(@RequestBody YsyUserAddress useraddress) {
		try {
			useraddressService.addUserAddress(useraddress);
			return ResultUtil.returnResult(useraddress, "增加用户地址成功");
		} catch (Exception e) {
			log.error("增加用户地址失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	// db_paramer delete
	@ResponseBody
	@RequestMapping(value = "/delete", method = {RequestMethod.GET})
	public ResultBean deleteById(String id) {
		try {
			int count = useraddressService.deleteById(id);
			return ResultUtil.returnResult(count, "删除用户地址成功");
		} catch (Exception e) {
			log.error("删除用户地址失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResultBean updateUserAddress(@RequestBody YsyUserAddress useraddress) {
		try {
			int count = useraddressService.updateUserAddress(useraddress);
			return ResultUtil.returnResult(count, "更新用户地址成功");
		} catch (Exception e) {
			log.error("更新用户地址失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean findUserAddress(@RequestParam(value = "page", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "limit", defaultValue = "10") Integer pageSize,
			@RequestParam(value = "q", defaultValue = "") String q) {
		log.debug("开始查询用户地址" + q);
		try {
			PageBean<YsyUserAddress> useraddresss = useraddressService.findUserAddress(q, pageNum, pageSize);
			return ResultUtil.returnResult(useraddresss, "查询用户地址成功");
		} catch (Exception e) {
			log.error("查询用户地址失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean findUserAddress(@PathVariable String id) {
		log.debug("开始查询用户地址详情" + id);
		try {
			YsyUserAddress useraddresss = useraddressService.detailUserAddress(id);
			return ResultUtil.returnResult(useraddresss, "查询用户地址详情成功");
		} catch (Exception e) {
			log.error("查询用户地址详情失败", e);
			return ResultUtil.returnResult(e);
		}
	}
}
