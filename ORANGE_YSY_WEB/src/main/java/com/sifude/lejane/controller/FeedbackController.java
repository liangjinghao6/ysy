package com.sifude.lejane.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sifude.lejane.entity.SysFeedback;
import com.sifude.lejane.entity.mvo.SysFeedbackDMvo;
import com.sifude.lejane.entity.mvo.SysFeedbackSMvo;
import com.sifude.lejane.service.IFeedbackService;
import com.sifude.tool.util.entity.PageBean;
import com.sifude.tool.util.entity.ResultBean;
import com.sifude.tool.util.entity.ResultUtil;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @author 梁景皓
 * @version 创建时间：2016年3月24日 上午10:16:47
 * 类说明
 */
@RestController
@RequestMapping("fb")
public class FeedbackController {
private static Logger log = LogManager.getLogger(FeedbackController.class);
	
	@Resource(name = "feedbackService")
	private IFeedbackService feedbackService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}
	
	@RequestMapping("/page/{v}")
	@ApiOperation(value = "查询反馈列表", httpMethod = "POST", response = ResultBean.class)
	public ResultBean searchFeedbackList(@ApiParam("应用类型id") @RequestParam(required = false) Long ptId, 
			@ApiParam("添加开始时间") @RequestParam(required = false) Date beginTime, 
			@ApiParam("添加结束时间") @RequestParam(required = false) Date endTime, 
			@ApiParam("登录管理员所在机构id") @RequestParam(required = true) Long addCompId, 
			@RequestParam(defaultValue = "1") Integer pageIndex,
			@RequestParam(defaultValue = "20") Integer pageSize) {
		try {
			PageBean<SysFeedbackSMvo> feedback = feedbackService.searchFeedbackList(ptId, beginTime, endTime, addCompId, pageIndex, pageSize);
			return ResultUtil.returnResult(feedback, "查询反馈成功");
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	}

	@RequestMapping("/detail/{v}")
	@ApiOperation(value = "查询反馈详细信息", httpMethod = "POST", response = ResultBean.class)
	public ResultBean detailFeedback(
			@ApiParam("反馈id") @RequestParam(required = true) Long fbId) {
		try {
			SysFeedbackDMvo company = feedbackService.detailFeedback(fbId);
			return ResultUtil.returnResult(company, "查询反馈详情成功");
		}  catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	}
	

	@RequestMapping("/add/{v}")
	@ApiOperation(value = "添加反馈", httpMethod = "POST", response = ResultBean.class)
	public ResultBean addFeedback(@ModelAttribute SysFeedback feedback) {
		try {
			int count = feedbackService.addFeedback(feedback);
			return ResultUtil.returnResult(count, "保存反馈成功");
		}  catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping("/update/{v}")
	@ApiOperation(value = "更新反馈", httpMethod = "POST", response = ResultBean.class)
	public ResultBean updateFeedback(@ModelAttribute SysFeedback feedback) {
		
		try {
			int count = feedbackService.updateFeedback(feedback);
			return ResultUtil.returnResult(count, "更新反馈成功");
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	}
	

	@RequestMapping("/delete/{v}")
	@ApiOperation(value = "删除反馈", httpMethod = "POST", response = ResultBean.class)
	public ResultBean deleteFeedback(@ApiParam("反馈ids") @RequestParam(required = true) String fbIds) {
		
		try {
			int count = feedbackService.deleteFeedback(fbIds);
			return ResultUtil.returnResult(count, "删除反馈成功");
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	}
}
