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
import com.orange.ysy.entity.YsySysFile;
import com.orange.ysy.service.ISysFileService;
import com.orange.ysy.util.ResultUtil;

import io.swagger.annotations.Api;

@Controller
// @RestController
@RequestMapping("/sysfile")
@Api(description = "文件信息维护")
public class SysFileController {
	private static Logger log = LoggerFactory.getLogger(SysFileController.class);

	@Resource
	private ISysFileService sysfileService;

	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResultBean addSysFile(@RequestBody YsySysFile sysfile) {
		try {
			sysfileService.addSysFile(sysfile);
			return ResultUtil.returnResult(sysfile, "增加文件成功");
		} catch (Exception e) {
			log.error("增加文件失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	// db_paramer delete
	@ResponseBody
	@RequestMapping(value = "/delete", method = {RequestMethod.GET})
	public ResultBean deleteById(String id) {
		try {
			int count = sysfileService.deleteById(id);
			return ResultUtil.returnResult(count, "删除文件成功");
		} catch (Exception e) {
			log.error("删除文件失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResultBean updateSysFile(@RequestBody YsySysFile sysfile) {
		try {
			int count = sysfileService.updateSysFile(sysfile);
			return ResultUtil.returnResult(count, "更新文件成功");
		} catch (Exception e) {
			log.error("更新文件失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean findSysFile(@RequestParam(value = "page", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "limit", defaultValue = "10") Integer pageSize,
			@RequestParam(value = "q", defaultValue = "") String q) {
		log.debug("开始查询文件" + q);
		try {
			PageBean<YsySysFile> sysfiles = sysfileService.findSysFile(q, pageNum, pageSize);
			return ResultUtil.returnResult(sysfiles, "查询文件成功");
		} catch (Exception e) {
			log.error("查询文件失败", e);
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean findSysFile(@PathVariable String id) {
		log.debug("开始查询文件详情" + id);
		try {
			YsySysFile sysfiles = sysfileService.detailSysFile(id);
			return ResultUtil.returnResult(sysfiles, "查询文件详情成功");
		} catch (Exception e) {
			log.error("查询文件详情失败", e);
			return ResultUtil.returnResult(e);
		}
	}
}
