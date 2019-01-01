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
import com.orange.ysy.entity.YsyLnkBackGoods;
import com.orange.ysy.service.ILnkBackGoodsService;
import com.orange.ysy.util.ResultUtil;

import io.swagger.annotations.Api;

@Controller
// @RestController
@RequestMapping("/lnkbackgoods")
@Api(description = "{替换一下加注解}信息维护")
public class LnkBackGoodsController {
	private static Logger log = LoggerFactory.getLogger(LnkBackGoodsController.class);

	@Resource
	private ILnkBackGoodsService lnkbackgoodsService;

	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResultBean addLnkBackGoods(@RequestBody YsyLnkBackGoods lnkbackgoods) {
		try {
			lnkbackgoodsService.addLnkBackGoods(lnkbackgoods);
			return ResultUtil.returnResult(lnkbackgoods, "增加{替换一下加注解}成功");
		} catch (Exception e) {
			log.error("增加{替换一下加注解}失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	// db_paramer delete
	@ResponseBody
	@RequestMapping(value = "/delete", method = {RequestMethod.GET})
	public ResultBean deleteById(String id) {
		try {
			int count = lnkbackgoodsService.deleteById(id);
			return ResultUtil.returnResult(count, "删除{替换一下加注解}成功");
		} catch (Exception e) {
			log.error("删除{替换一下加注解}失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResultBean updateLnkBackGoods(@RequestBody YsyLnkBackGoods lnkbackgoods) {
		try {
			int count = lnkbackgoodsService.updateLnkBackGoods(lnkbackgoods);
			return ResultUtil.returnResult(count, "更新{替换一下加注解}成功");
		} catch (Exception e) {
			log.error("更新{替换一下加注解}失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean findLnkBackGoods(@RequestParam(value = "page", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "limit", defaultValue = "10") Integer pageSize,
			@RequestParam(value = "q", defaultValue = "") String q) {
		log.debug("开始查询{替换一下加注解}" + q);
		try {
			PageBean<YsyLnkBackGoods> lnkbackgoodss = lnkbackgoodsService.findLnkBackGoods(q, pageNum, pageSize);
			return ResultUtil.returnResult(lnkbackgoodss, "查询{替换一下加注解}成功");
		} catch (Exception e) {
			log.error("查询{替换一下加注解}失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean findLnkBackGoods(@PathVariable String id) {
		log.debug("开始查询{替换一下加注解}详情" + id);
		try {
			YsyLnkBackGoods lnkbackgoodss = lnkbackgoodsService.detailLnkBackGoods(id);
			return ResultUtil.returnResult(lnkbackgoodss, "查询{替换一下加注解}详情成功");
		} catch (Exception e) {
			log.error("查询{替换一下加注解}详情失败", e);
			return ResultUtil.returnResult(e);
		}
	}
}
