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
import com.orange.ysy.entity.YsyOrder;
import com.orange.ysy.service.IOrderService;
import com.orange.ysy.util.ResultUtil;

import io.swagger.annotations.Api;

@Controller
// @RestController
@RequestMapping("/order")
@Api(description = "订单信息维护")
public class OrderController {
	private static Logger log = LoggerFactory.getLogger(OrderController.class);

	@Resource
	private IOrderService orderService;

	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResultBean addOrder(@RequestBody YsyOrder order) {
		try {
			orderService.addOrder(order);
			return ResultUtil.returnResult(order, "增加订单成功");
		} catch (Exception e) {
			log.error("增加订单失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	// db_paramer delete
	@ResponseBody
	@RequestMapping(value = "/delete", method = {RequestMethod.GET})
	public ResultBean deleteById(String id) {
		try {
			int count = orderService.deleteById(id);
			return ResultUtil.returnResult(count, "删除订单成功");
		} catch (Exception e) {
			log.error("删除订单失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResultBean updateOrder(@RequestBody YsyOrder order) {
		try {
			int count = orderService.updateOrder(order);
			return ResultUtil.returnResult(count, "更新订单成功");
		} catch (Exception e) {
			log.error("更新订单失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean findOrder(@RequestParam(value = "page", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "limit", defaultValue = "10") Integer pageSize,
			@RequestParam(value = "q", defaultValue = "") String q) {
		log.debug("开始查询订单" + q);
		try {
			PageBean<YsyOrder> orders = orderService.findOrder(q, pageNum, pageSize);
			return ResultUtil.returnResult(orders, "查询订单成功");
		} catch (Exception e) {
			log.error("查询订单失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean findOrder(@PathVariable String id) {
		log.debug("开始查询订单详情" + id);
		try {
			YsyOrder orders = orderService.detailOrder(id);
			return ResultUtil.returnResult(orders, "查询订单详情成功");
		} catch (Exception e) {
			log.error("查询订单详情失败", e);
			return ResultUtil.returnResult(e);
		}
	}
}
