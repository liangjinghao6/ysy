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
import com.orange.ysy.entity.YsyGoodsFeature;
import com.orange.ysy.service.IGoodsFeatureService;
import com.orange.ysy.util.ResultUtil;

import io.swagger.annotations.Api;

@Controller
// @RestController
@RequestMapping("/goodsfeature")
@Api(description = "商品特征信息维护")
public class GoodsFeatureController {
	private static Logger log = LoggerFactory.getLogger(GoodsFeatureController.class);

	@Resource
	private IGoodsFeatureService goodsfeatureService;

	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResultBean addGoodsFeature(@RequestBody YsyGoodsFeature goodsfeature) {
		try {
			goodsfeatureService.addGoodsFeature(goodsfeature);
			return ResultUtil.returnResult(goodsfeature, "增加商品特征成功");
		} catch (Exception e) {
			log.error("增加商品特征失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	// db_paramer delete
	@ResponseBody
	@RequestMapping(value = "/delete", method = {RequestMethod.GET})
	public ResultBean deleteById(String id) {
		try {
			int count = goodsfeatureService.deleteById(id);
			return ResultUtil.returnResult(count, "删除商品特征成功");
		} catch (Exception e) {
			log.error("删除商品特征失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResultBean updateGoodsFeature(@RequestBody YsyGoodsFeature goodsfeature) {
		try {
			int count = goodsfeatureService.updateGoodsFeature(goodsfeature);
			return ResultUtil.returnResult(count, "更新商品特征成功");
		} catch (Exception e) {
			log.error("更新商品特征失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean findGoodsFeature(@RequestParam(value = "page", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "limit", defaultValue = "10") Integer pageSize,
			@RequestParam(value = "q", defaultValue = "") String q) {
		log.debug("开始查询商品特征" + q);
		try {
			PageBean<YsyGoodsFeature> goodsfeatures = goodsfeatureService.findGoodsFeature(q, pageNum, pageSize);
			return ResultUtil.returnResult(goodsfeatures, "查询商品特征成功");
		} catch (Exception e) {
			log.error("查询商品特征失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean findGoodsFeature(@PathVariable String id) {
		log.debug("开始查询商品特征详情" + id);
		try {
			YsyGoodsFeature goodsfeatures = goodsfeatureService.detailGoodsFeature(id);
			return ResultUtil.returnResult(goodsfeatures, "查询商品特征详情成功");
		} catch (Exception e) {
			log.error("查询商品特征详情失败", e);
			return ResultUtil.returnResult(e);
		}
	}
}
