package com.orange.ysy.controller;

import java.util.List;

import javax.annotation.Resource;

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
import com.orange.ysy.entity.YsyGoods;
import com.orange.ysy.entity.mvo.YsyGoodsMvo;
import com.orange.ysy.service.IGoodsService;
import com.orange.ysy.util.ResultUtil;

import io.swagger.annotations.Api;

@Controller
// @RestController
@RequestMapping("/goods")
@Api(description = "商品信息维护")
public class GoodsController {
	private static Logger log = LoggerFactory.getLogger(GoodsController.class);

	@Resource
	private IGoodsService goodsService;
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean findGoods(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
			@RequestParam(value = "q", defaultValue = "") String q) {
		log.debug("开始查询商品" + q);
		try {
			PageBean<YsyGoods> goodss = goodsService.findGoods(q, pageNum, pageSize);
			return ResultUtil.returnResult(goodss, "查询商品成功");
		} catch (Exception e) {
			log.error("查询商品失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean findGoods(@PathVariable String id) {
		log.debug("开始查询商品详情" + id);
		try {
			YsyGoodsMvo goodss = goodsService.detailGoods(id);
			return ResultUtil.returnResult(goodss, "查询商品详情成功");
		} catch (Exception e) {
			log.error("查询商品详情失败", e);
			return ResultUtil.returnResult(e);
		}
	}
}
