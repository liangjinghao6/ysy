package com.orange.ysy.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orange.ysy.entity.ResultBean;
import com.orange.ysy.entity.YsyOpOperator;
import com.orange.ysy.service.ICommonService;
import com.orange.ysy.util.ResultUtil;

import io.swagger.annotations.Api;

@Controller
@RestController
@RequestMapping("/")
@Api(description = "通用接口")
public class CommonController {
	private static Logger log = LoggerFactory.getLogger(CommonController.class);

	@Resource
	private ICommonService commonService;
	
	@RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
	public ResultBean login(String account, String password, String validateCode, HttpSession session) {
		try {
			YsyOpOperator operator = commonService.login(account, password, validateCode, session);
			return ResultUtil.returnResult(operator, "登录成功");
		} catch (Exception e) {
			log.error("登录失败");
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping(value = "/token/login", method = {RequestMethod.GET, RequestMethod.POST})
	public ResultBean loginByToken(String token) {
		try {
			YsyOpOperator operator = commonService.loginByToken(token);
			return ResultUtil.returnResult(operator, "登录成功");
		} catch (Exception e) {
			log.error("登录失败");
			return ResultUtil.returnResult(e);
		}
	}
}
