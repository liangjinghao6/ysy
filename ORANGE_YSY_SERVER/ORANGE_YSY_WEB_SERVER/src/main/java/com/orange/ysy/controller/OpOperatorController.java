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
import com.orange.ysy.entity.YsyOpOperator;
import com.orange.ysy.service.IOpOperatorService;
import com.orange.ysy.util.ResultUtil;

import io.swagger.annotations.Api;

@Controller
// @RestController
@RequestMapping("/opoperator")
@Api(description = "管理员信息维护")
public class OpOperatorController {
	private static Logger log = LoggerFactory.getLogger(OpOperatorController.class);

	@Resource
	private IOpOperatorService opoperatorService;

	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResultBean addOpOperator(@RequestBody YsyOpOperator opoperator) {
		try {
			opoperatorService.addOpOperator(opoperator);
			return ResultUtil.returnResult(opoperator, "增加管理员成功");
		} catch (Exception e) {
			log.error("增加管理员失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	// db_paramer delete
	@ResponseBody
	@RequestMapping(value = "/delete", method = {RequestMethod.GET})
	public ResultBean deleteById(String id) {
		try {
			int count = opoperatorService.deleteById(id);
			return ResultUtil.returnResult(count, "删除管理员成功");
		} catch (Exception e) {
			log.error("删除管理员失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResultBean updateOpOperator(@RequestBody YsyOpOperator opoperator) {
		try {
			int count = opoperatorService.updateOpOperator(opoperator);
			return ResultUtil.returnResult(count, "更新管理员成功");
		} catch (Exception e) {
			log.error("更新管理员失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean findOpOperator(@RequestParam(value = "page", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "limit", defaultValue = "10") Integer pageSize,
			@RequestParam(value = "q", defaultValue = "") String q) {
		log.debug("开始查询管理员" + q);
		try {
			PageBean<YsyOpOperator> opoperators = opoperatorService.findOpOperator(q, pageNum, pageSize);
			return ResultUtil.returnResult(opoperators, "查询管理员成功");
		} catch (Exception e) {
			log.error("查询管理员失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean findOpOperator(@PathVariable String id) {
		log.debug("开始查询管理员详情" + id);
		try {
			YsyOpOperator opoperators = opoperatorService.detailOpOperator(id);
			return ResultUtil.returnResult(opoperators, "查询管理员详情成功");
		} catch (Exception e) {
			log.error("查询管理员详情失败", e);
			return ResultUtil.returnResult(e);
		}
	}
}
