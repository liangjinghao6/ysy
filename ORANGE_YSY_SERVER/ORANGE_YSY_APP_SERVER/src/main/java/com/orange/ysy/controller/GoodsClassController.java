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
import com.orange.ysy.entity.YsyGoodsClass;
import com.orange.ysy.service.IGoodsClassService;
import com.orange.ysy.util.ResultUtil;

import io.swagger.annotations.Api;

@Controller
// @RestController
@RequestMapping("/goodsclass")
@Api(description = "商品特征分类信息维护")
public class GoodsClassController {
	private static Logger log = LoggerFactory.getLogger(GoodsClassController.class);

	@Resource
	private IGoodsClassService goodsclassService;

	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResultBean addGoodsClass(@RequestBody YsyGoodsClass goodsclass) {
		try {
			goodsclassService.addGoodsClass(goodsclass);
			return ResultUtil.returnResult(goodsclass, "增加商品特征分类成功");
		} catch (Exception e) {
			log.error("增加商品特征分类失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	// db_paramer delete
	@ResponseBody
	@RequestMapping(value = "/delete", method = {RequestMethod.GET})
	public ResultBean deleteById(String id) {
		try {
			int count = goodsclassService.deleteById(id);
			return ResultUtil.returnResult(count, "删除商品特征分类成功");
		} catch (Exception e) {
			log.error("删除商品特征分类失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResultBean updateGoodsClass(@RequestBody YsyGoodsClass goodsclass) {
		try {
			int count = goodsclassService.updateGoodsClass(goodsclass);
			return ResultUtil.returnResult(count, "更新商品特征分类成功");
		} catch (Exception e) {
			log.error("更新商品特征分类失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean findGoodsClass(@RequestParam(value = "page", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "limit", defaultValue = "10") Integer pageSize,
			@RequestParam(value = "q", defaultValue = "") String q) {
		log.debug("开始查询商品特征分类" + q);
		try {
			PageBean<YsyGoodsClass> goodsclasss = goodsclassService.findGoodsClass(q, pageNum, pageSize);
			return ResultUtil.returnResult(goodsclasss, "查询商品特征分类成功");
		} catch (Exception e) {
			log.error("查询商品特征分类失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean findGoodsClass(@PathVariable String id) {
		log.debug("开始查询商品特征分类详情" + id);
		try {
			YsyGoodsClass goodsclasss = goodsclassService.detailGoodsClass(id);
			return ResultUtil.returnResult(goodsclasss, "查询商品特征分类详情成功");
		} catch (Exception e) {
			log.error("查询商品特征分类详情失败", e);
			return ResultUtil.returnResult(e);
		}
	}
}
