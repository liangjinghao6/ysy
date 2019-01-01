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
import com.orange.ysy.entity.YsyGoodsCategory;
import com.orange.ysy.service.IGoodsCategoryService;
import com.orange.ysy.util.ResultUtil;

import io.swagger.annotations.Api;

@Controller
// @RestController
@RequestMapping("/goodscategory")
@Api(description = "信息维护")
public class GoodsCategoryController {
	private static Logger log = LoggerFactory.getLogger(GoodsCategoryController.class);

	@Resource
	private IGoodsCategoryService goodscategoryService;

	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResultBean addGoodsCategory(@RequestBody YsyGoodsCategory goodscategory) {
		try {
			goodscategoryService.addGoodsCategory(goodscategory);
			return ResultUtil.returnResult(goodscategory, "增加成功");
		} catch (Exception e) {
			log.error("增加失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	// db_paramer delete
	@ResponseBody
	@RequestMapping(value = "/delete", method = {RequestMethod.GET})
	public ResultBean deleteById(String id) {
		try {
			int count = goodscategoryService.deleteById(id);
			return ResultUtil.returnResult(count, "删除成功");
		} catch (Exception e) {
			log.error("删除失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResultBean updateGoodsCategory(@RequestBody YsyGoodsCategory goodscategory) {
		try {
			int count = goodscategoryService.updateGoodsCategory(goodscategory);
			return ResultUtil.returnResult(count, "更新成功");
		} catch (Exception e) {
			log.error("更新失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean findGoodsCategory(@RequestParam(value = "page", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "limit", defaultValue = "10") Integer pageSize,
			@RequestParam(value = "q", defaultValue = "") String q) {
		log.debug("开始查询" + q);
		try {
			PageBean<YsyGoodsCategory> goodscategorys = goodscategoryService.findGoodsCategory(q, pageNum, pageSize);
			return ResultUtil.returnResult(goodscategorys, "查询成功");
		} catch (Exception e) {
			log.error("查询失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean findGoodsCategory(@PathVariable String id) {
		log.debug("开始查询详情" + id);
		try {
			YsyGoodsCategory goodscategorys = goodscategoryService.detailGoodsCategory(id);
			return ResultUtil.returnResult(goodscategorys, "查询详情成功");
		} catch (Exception e) {
			log.error("查询详情失败", e);
			return ResultUtil.returnResult(e);
		}
	}
}
