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
import com.orange.ysy.entity.YsyLnkGoodsClass;
import com.orange.ysy.service.ILnkGoodsClassService;
import com.orange.ysy.util.ResultUtil;

import io.swagger.annotations.Api;

@Controller
// @RestController
@RequestMapping("/lnkgoodsclass")
@Api(description = "{替换一下加注解}信息维护")
public class LnkGoodsClassController {
	private static Logger log = LoggerFactory.getLogger(LnkGoodsClassController.class);

	@Resource
	private ILnkGoodsClassService lnkgoodsclassService;

	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResultBean addLnkGoodsClass(@RequestBody YsyLnkGoodsClass lnkgoodsclass) {
		try {
			lnkgoodsclassService.addLnkGoodsClass(lnkgoodsclass);
			return ResultUtil.returnResult(lnkgoodsclass, "增加{替换一下加注解}成功");
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
			int count = lnkgoodsclassService.deleteById(id);
			return ResultUtil.returnResult(count, "删除{替换一下加注解}成功");
		} catch (Exception e) {
			log.error("删除{替换一下加注解}失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResultBean updateLnkGoodsClass(@RequestBody YsyLnkGoodsClass lnkgoodsclass) {
		try {
			int count = lnkgoodsclassService.updateLnkGoodsClass(lnkgoodsclass);
			return ResultUtil.returnResult(count, "更新{替换一下加注解}成功");
		} catch (Exception e) {
			log.error("更新{替换一下加注解}失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean findLnkGoodsClass(@RequestParam(value = "page", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "limit", defaultValue = "10") Integer pageSize,
			@RequestParam(value = "q", defaultValue = "") String q) {
		log.debug("开始查询{替换一下加注解}" + q);
		try {
			PageBean<YsyLnkGoodsClass> lnkgoodsclasss = lnkgoodsclassService.findLnkGoodsClass(q, pageNum, pageSize);
			return ResultUtil.returnResult(lnkgoodsclasss, "查询{替换一下加注解}成功");
		} catch (Exception e) {
			log.error("查询{替换一下加注解}失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean findLnkGoodsClass(@PathVariable String id) {
		log.debug("开始查询{替换一下加注解}详情" + id);
		try {
			YsyLnkGoodsClass lnkgoodsclasss = lnkgoodsclassService.detailLnkGoodsClass(id);
			return ResultUtil.returnResult(lnkgoodsclasss, "查询{替换一下加注解}详情成功");
		} catch (Exception e) {
			log.error("查询{替换一下加注解}详情失败", e);
			return ResultUtil.returnResult(e);
		}
	}
}
