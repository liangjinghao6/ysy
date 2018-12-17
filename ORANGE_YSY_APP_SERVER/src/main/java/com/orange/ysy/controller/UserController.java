package com.orange.ysy.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.orange.ysy.entity.PageBean;
import com.orange.ysy.entity.ResultBean;
import com.orange.ysy.entity.YsyUser;
import com.orange.ysy.service.IUserService;
import com.orange.ysy.util.ResultUtil;

import io.swagger.annotations.Api;

@Controller
// @RestController
@RequestMapping("/user")
@Api(description = "用户信息维护")
public class UserController {
	private static Logger log = LoggerFactory.getLogger(UserController.class);

	@Resource
	private IUserService userService;

	// db_paramer delete
	@ResponseBody
	@RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public ResultBean deleteById(String id) {
		try {
			int count = userService.deleteById(id);
			return ResultUtil.returnResult(count, "删除用户成功");
		} catch (Exception e) {
			log.error("删除用户失败");
			return ResultUtil.returnResult(e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResultBean updateUser(String account, String name, String id, HttpSession session) {
		try {
			int count = userService.updateUser(account, name, id, (String) session.getAttribute("user"));
			return ResultUtil.returnResult(count, "更新用户成功");
		} catch (Exception e) {
			log.error("更新用户失败");
			return ResultUtil.returnResult(e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResultBean addUser(@RequestParam YsyUser user) {
		try {
			userService.addUser(user);
			return ResultUtil.returnResult(user, "增加用户成功");
		} catch (Exception e) {
			log.error("增加用户失败");
			return ResultUtil.returnResult(e);
		}
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean findUser(@RequestParam(value = "page", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "limit", defaultValue = "10") Integer pageSize,
			@RequestParam(value = "q", defaultValue = "") String q) {
		log.debug("开始查询用户" + q);
		try {
			PageBean<YsyUser> users = userService.findUser(q, pageNum, pageSize);
			return ResultUtil.returnResult(users, "查询用户成功");
		} catch (Exception e) {
			log.error("查询用户失败");
			return ResultUtil.returnResult(e);
		}

	}
}
