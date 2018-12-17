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

import com.sifude.lejane.entity.SysInformation;
import com.sifude.lejane.entity.mvo.SysInformationDMvo;
import com.sifude.lejane.entity.mvo.SysInformationSMvo;
import com.sifude.lejane.service.IInformationService;
import com.sifude.tool.util.entity.PageBean;
import com.sifude.tool.util.entity.ResultBean;
import com.sifude.tool.util.entity.ResultUtil;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @author 梁景皓
 * @version 创建时间：2016年3月23日 下午1:55:10
 * 类说明
 */
@RestController
@RequestMapping("info")
public class InformationController {
	private static Logger log = LogManager.getLogger(InformationController.class);
	
	@Resource(name = "informationService")
	private IInformationService informationService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}
	
	@RequestMapping("/page/{v}")
	@ApiOperation(value = "查询资讯列表", httpMethod = "POST", response = ResultBean.class)
	public ResultBean searchInformationList(@ApiParam("标题") @RequestParam(required = false) String title,
			@ApiParam("应用类型") @RequestParam(required = false) String type, 
			@ApiParam("添加开始时间") @RequestParam(required = false) Date beginTime, 
			@ApiParam("添加结束时间") @RequestParam(required = false) Date endTime, 
			@ApiParam("审核状态") @RequestParam(required = true) Integer status, 
			@RequestParam(defaultValue = "1") Integer pageIndex,
			@RequestParam(defaultValue = "20") Integer pageSize) {
		try {
			PageBean<SysInformationSMvo> information = informationService.searchInformationList(title, type, beginTime, endTime, status, pageIndex, pageSize);
			return ResultUtil.returnResult(information, "查询资讯成功");
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	}

	@RequestMapping("/detail/{v}")
	@ApiOperation(value = "查询资讯详细信息", httpMethod = "POST", response = ResultBean.class)
	public ResultBean detailInformation(
			@ApiParam("资讯id") @RequestParam(required = true) Long infoId) {
		try {
			SysInformationDMvo information = informationService.detailInformation(infoId);
			return ResultUtil.returnResult(information, "查询资讯详情成功");
		}  catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping("/add/{v}")
	@ApiOperation(value = "添加问题", httpMethod = "POST", response = ResultBean.class)
	public ResultBean addInformation(@ModelAttribute SysInformation information,
			@ApiParam("审核用户id") @RequestParam(required = true) Long addOpId,
			@ApiParam("审核用户姓名") @RequestParam(required = true) String addOpName) {
		try {
			int count = informationService.addInformation(information, addOpId, addOpName);
			return ResultUtil.returnResult(count, "保存资讯成功");
		}  catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping("/check/{v}")
	@ApiOperation(value = "审核资讯", httpMethod = "POST", response = ResultBean.class)
	public ResultBean checkInformation(@ApiParam("资讯ids") @RequestParam(required = true) String infoIds,
			@ApiParam("审核状态") @RequestParam(required = true) Integer status,
			@ApiParam("审核用户id") @RequestParam(required = true) Long addOpId,
			@ApiParam("审核用户姓名") @RequestParam(required = true) String addOpName) {
		try {
			int count = informationService.checkInformation(infoIds, status, addOpId, addOpName);
			return ResultUtil.returnResult(count, "资讯审核成功");
		}  catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping("/delete/{v}")
	@ApiOperation(value = "审核资讯", httpMethod = "POST", response = ResultBean.class)
	public ResultBean deleteInformation(@ApiParam("资讯ids") @RequestParam(required = true) String infoIds,
			@ApiParam("审核用户id") @RequestParam(required = true) Long addOpId,
			@ApiParam("审核用户姓名") @RequestParam(required = true) String addOpName) {
		try {
			int count = informationService.deleteInformation(infoIds, addOpId, addOpName);
			return ResultUtil.returnResult(count, "资讯审核成功");
		}  catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping("/update/{v}")
	@ApiOperation(value = "更新资讯", httpMethod = "POST", response = ResultBean.class)
	public ResultBean updateInformation(@ModelAttribute SysInformation information) {
		
		try {
			int count = informationService.updateInformation(information);
			return ResultUtil.returnResult(count, "更新资讯成功");
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping("/restore/{v}")
	@ApiOperation(value = "删除资讯", httpMethod = "POST", response = ResultBean.class)
	public ResultBean restoreInformation(@ApiParam("资讯ids") @RequestParam(required = true) String infoIds) {
		
		try {
			int count = informationService.restoreInformation(infoIds);
			return ResultUtil.returnResult(count, "删除资讯成功");
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	}

	@RequestMapping("/remove/{v}")
	@ApiOperation(value = "删除资讯", httpMethod = "POST", response = ResultBean.class)
	public ResultBean removeInformation(@ApiParam("资讯ids") @RequestParam(required = true) String infoIds) {
		
		try {
			int count = informationService.removeInformation(infoIds);
			return ResultUtil.returnResult(count, "删除资讯成功");
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	}
}
