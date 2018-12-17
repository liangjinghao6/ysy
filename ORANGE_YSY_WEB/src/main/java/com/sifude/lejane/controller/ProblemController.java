package com.sifude.lejane.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

import com.sifude.lejane.entity.SysProblem;
import com.sifude.lejane.entity.SysProblemType;
import com.sifude.lejane.entity.mvo.SysProblemDMvo;
import com.sifude.lejane.entity.mvo.SysProblemLMvo;
import com.sifude.lejane.entity.mvo.SysProblemTypeLMvo;
import com.sifude.lejane.service.IProblemService;
import com.sifude.tool.util.entity.PageBean;
import com.sifude.tool.util.entity.ResultBean;
import com.sifude.tool.util.entity.ResultUtil;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @author 梁景皓
 * @version 创建时间：2016年3月22日 下午4:03:49
 * 类说明
 */

@RestController
@RequestMapping("problem")
public class ProblemController {
	private static Logger log = LogManager.getLogger(ProblemController.class);
	
	@Resource(name = "problemService")
	private IProblemService problemService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}
	
	@RequestMapping("/page/{v}")
	@ApiOperation(value = "查询问题列表", httpMethod = "POST", response = ResultBean.class)
	public ResultBean searchProblemList(@ApiParam("标题") @RequestParam(required = false) String title,
			@ApiParam("应用类型id") @RequestParam(required = false) Long ptId, 
			@ApiParam("添加开始时间") @RequestParam(required = false) Date beginTime, 
			@ApiParam("添加结束时间") @RequestParam(required = false) Date endTime, 
			@ApiParam("登录管理员所在机构id") @RequestParam(required = true) Long addCompId, 
			@RequestParam(defaultValue = "1") Integer pageIndex,
			@RequestParam(defaultValue = "20") Integer pageSize) {
		try {
			PageBean<SysProblemLMvo> problem = problemService.searchProblemList(title, ptId, beginTime, endTime, addCompId, pageIndex, pageSize);
			return ResultUtil.returnResult(problem, "查询问题成功");
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	}

	@RequestMapping("/detail/{v}")
	@ApiOperation(value = "查询问题详细信息", httpMethod = "POST", response = ResultBean.class)
	public ResultBean detailProblem(
			@ApiParam("问题id") @RequestParam(required = true) Long proId) {
		try {
			SysProblemDMvo company = problemService.detailProblem(proId);
			return ResultUtil.returnResult(company, "查询问题详情成功");
		}  catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	}
	

	@RequestMapping("/add/{v}")
	@ApiOperation(value = "添加问题", httpMethod = "POST", response = ResultBean.class)
	public ResultBean addProblem(@ModelAttribute SysProblem problem) {
		try {
			int count = problemService.addProblem(problem);
			return ResultUtil.returnResult(count, "保存问题成功");
		}  catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping("/update/{v}")
	@ApiOperation(value = "更新问题", httpMethod = "POST", response = ResultBean.class)
	public ResultBean updateProblem(@ModelAttribute SysProblem problem) {
		
		try {
			int count = problemService.updateProblem(problem);
			return ResultUtil.returnResult(count, "更新问题成功");
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	}
	

	@RequestMapping("/delete/{v}")
	@ApiOperation(value = "删除问题", httpMethod = "POST", response = ResultBean.class)
	public ResultBean deleteProblem(@ApiParam("问题ids") @RequestParam(required = true) String proIds) {
		
		try {
			int count = problemService.deleteProblem(proIds);
			return ResultUtil.returnResult(count, "删除问题成功");
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping("/exist/{v}")
	@ApiOperation(value = "验证问题名称是否存在", httpMethod = "POST", response = ResultBean.class)
	public ResultBean existProblem(@ApiParam("问题名称") @RequestParam(required = false) String name){
		try {
			int count = problemService.existProblem(name);
			return ResultUtil.returnResult(count, "问题名称不存在");
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping("/type/add/{v}")
	@ApiOperation(value = "添加问题类型", httpMethod = "POST", response = ResultBean.class)
	public ResultBean addProblemType(@ModelAttribute SysProblemType problem){
		try {
			int count = problemService.addProblemType(problem);
			return ResultUtil.returnResult(count, "添加问题类型成功");
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping("/type/list/{v}")
	@ApiOperation(value = "查询问题类型列表", httpMethod = "POST", response = ResultBean.class)
	public ResultBean listProblemType(@ApiParam("问题类型名称") @RequestParam(required = false) String name,
			@RequestParam(defaultValue = "100") Integer size){
		try {
			
			List<SysProblemTypeLMvo> count = problemService.listProblemType(name, size);
			return ResultUtil.returnResult(count, "查询问题类型列表成功");
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	}
}
