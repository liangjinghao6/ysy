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
import com.orange.ysy.entity.YsyOrderBack;
import com.orange.ysy.service.IOrderBackService;
import com.orange.ysy.util.ResultUtil;

import io.swagger.annotations.Api;

@Controller
// @RestController
@RequestMapping("/orderback")
@Api(description = "退货单信息维护")
public class OrderBackController {
	private static Logger log = LoggerFactory.getLogger(OrderBackController.class);

	@Resource
	private IOrderBackService orderbackService;

	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResultBean addOrderBack(@RequestBody YsyOrderBack orderback) {
		try {
			orderbackService.addOrderBack(orderback);
			return ResultUtil.returnResult(orderback, "增加退货单成功");
		} catch (Exception e) {
			log.error("增加退货单失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	// db_paramer delete
	@ResponseBody
	@RequestMapping(value = "/delete", method = {RequestMethod.GET})
	public ResultBean deleteById(String id) {
		try {
			int count = orderbackService.deleteById(id);
			return ResultUtil.returnResult(count, "删除退货单成功");
		} catch (Exception e) {
			log.error("删除退货单失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResultBean updateOrderBack(@RequestBody YsyOrderBack orderback) {
		try {
			int count = orderbackService.updateOrderBack(orderback);
			return ResultUtil.returnResult(count, "更新退货单成功");
		} catch (Exception e) {
			log.error("更新退货单失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean findOrderBack(@RequestParam(value = "page", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "limit", defaultValue = "10") Integer pageSize,
			@RequestParam(value = "q", defaultValue = "") String q) {
		log.debug("开始查询退货单" + q);
		try {
			PageBean<YsyOrderBack> orderbacks = orderbackService.findOrderBack(q, pageNum, pageSize);
			return ResultUtil.returnResult(orderbacks, "查询退货单成功");
		} catch (Exception e) {
			log.error("查询退货单失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean findOrderBack(@PathVariable String id) {
		log.debug("开始查询退货单详情" + id);
		try {
			YsyOrderBack orderbacks = orderbackService.detailOrderBack(id);
			return ResultUtil.returnResult(orderbacks, "查询退货单详情成功");
		} catch (Exception e) {
			log.error("查询退货单详情失败", e);
			return ResultUtil.returnResult(e);
		}
	}
}
