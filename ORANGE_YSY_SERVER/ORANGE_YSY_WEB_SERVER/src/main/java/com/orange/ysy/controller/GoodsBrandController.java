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
import com.orange.ysy.entity.YsyGoodsBrand;
import com.orange.ysy.service.IGoodsBrandService;
import com.orange.ysy.util.ResultUtil;

import io.swagger.annotations.Api;

@Controller
// @RestController
@RequestMapping("/goodsbrand")
@Api(description = "商品品牌信息维护")
public class GoodsBrandController {
	private static Logger log = LoggerFactory.getLogger(GoodsBrandController.class);

	@Resource
	private IGoodsBrandService goodsbrandService;

	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResultBean addGoodsBrand(@RequestBody YsyGoodsBrand goodsbrand) {
		try {
			goodsbrandService.addGoodsBrand(goodsbrand);
			return ResultUtil.returnResult(goodsbrand, "增加商品品牌成功");
		} catch (Exception e) {
			log.error("增加商品品牌失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	// db_paramer delete
	@ResponseBody
	@RequestMapping(value = "/delete", method = {RequestMethod.GET})
	public ResultBean deleteById(String id) {
		try {
			int count = goodsbrandService.deleteById(id);
			return ResultUtil.returnResult(count, "删除商品品牌成功");
		} catch (Exception e) {
			log.error("删除商品品牌失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResultBean updateGoodsBrand(@RequestBody YsyGoodsBrand goodsbrand) {
		try {
			int count = goodsbrandService.updateGoodsBrand(goodsbrand);
			return ResultUtil.returnResult(count, "更新商品品牌成功");
		} catch (Exception e) {
			log.error("更新商品品牌失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean findGoodsBrand(@RequestParam(value = "page", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "limit", defaultValue = "10") Integer pageSize,
			@RequestParam(value = "q", defaultValue = "") String q) {
		log.debug("开始查询商品品牌" + q);
		try {
			PageBean<YsyGoodsBrand> goodsbrands = goodsbrandService.findGoodsBrand(q, pageNum, pageSize);
			return ResultUtil.returnResult(goodsbrands, "查询商品品牌成功");
		} catch (Exception e) {
			log.error("查询商品品牌失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean findGoodsBrand(@PathVariable String id) {
		log.debug("开始查询商品品牌详情" + id);
		try {
			YsyGoodsBrand goodsbrands = goodsbrandService.detailGoodsBrand(id);
			return ResultUtil.returnResult(goodsbrands, "查询商品品牌详情成功");
		} catch (Exception e) {
			log.error("查询商品品牌详情失败", e);
			return ResultUtil.returnResult(e);
		}
	}
}
