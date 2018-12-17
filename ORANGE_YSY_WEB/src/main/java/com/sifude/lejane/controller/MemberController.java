package com.sifude.lejane.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sifude.lejane.entity.UsrArchives;
import com.sifude.lejane.entity.UsrFamily;
import com.sifude.lejane.entity.UsrHabbit;
import com.sifude.lejane.entity.UsrMember;
import com.sifude.lejane.entity.mvo.UsrArchivesDMvo;
import com.sifude.lejane.entity.mvo.UsrArchivesUMvo;
import com.sifude.lejane.entity.mvo.UsrErrorDataLMvo;
import com.sifude.lejane.entity.mvo.UsrFamilyLMvo;
import com.sifude.lejane.entity.mvo.UsrMemberDMvo;
import com.sifude.lejane.entity.mvo.UsrMemberSMvo;
import com.sifude.lejane.service.IMemberService;
import com.sifude.tool.util.entity.PageBean;
import com.sifude.tool.util.entity.ResultBean;
import com.sifude.tool.util.entity.ResultUtil;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @author 梁景皓
 * @version 创建时间：2016年3月28日 下午3:51:55
 * 类说明
 */
@RestController
@RequestMapping("memb")
public class MemberController {
private static Logger log = LogManager.getLogger(MemberController.class);
	
	@Resource(name = "memberService")
	private IMemberService memberService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}
	
	@RequestMapping("/page/{v}")
	@ApiOperation(value = "查询会员列表", httpMethod = "POST", response = ResultBean.class)
	public ResultBean listMember(@ApiParam(value = "会员姓名") @RequestParam(required = false) String name,
			@ApiParam(value = "会员手机号") @RequestParam(required = false) String phone,
			@ApiParam(value = "会员账号") @RequestParam(required = false) String account,
			@ApiParam(value = "健康档案") @RequestParam(required = false) Integer archiveStatus,
			@ApiParam(value = "创建开始时间") @RequestParam(required = false) Date beginTime,
			@ApiParam(value = "创建结束时间") @RequestParam(required = false) Date endTime,
			@ApiParam(value = "是否被分配 0 已分配 1 未分配") @RequestParam(required = false) Integer opStatus,
			@ApiParam(value = "会员所属机构名称") @RequestParam(required = false) String compName,
			@ApiParam(value = "分配员工姓名") @RequestParam(required = false) String opName,
			@ApiParam(value = "登录管理员的ID") @RequestParam(required = false) Long addOpId,
			@ApiParam(value = "登录管理员的级别") @RequestParam(required = false) Long addRoleLevel,
			@ApiParam(value = "登录管理员所在机构级别") @RequestParam(required = false) Long addCompId,
			@RequestParam(defaultValue = "1") Integer pageIndex, 
			@RequestParam(defaultValue = "20") Integer pageSize) {
		try {
			PageBean<UsrMemberSMvo> members = memberService.searchMember(name, phone, account, archiveStatus, beginTime, endTime, opStatus, compName, opName, pageIndex, pageSize, addOpId, addRoleLevel, addCompId);

			return ResultUtil.returnResult(members, "查询会员");
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	}

	@RequestMapping("/detail/{v}")
	@ApiOperation(value = "查询会员详细信息", httpMethod = "POST", response = ResultBean.class)
	public ResultBean detailMember(@ApiParam(value = "会员id") @RequestParam(required = false) Long membId) {
		try {
			UsrMemberDMvo member = memberService.detailMember(membId);

			return ResultUtil.returnResult(member, "查询会员详细信息成功");
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping("/member/total/{v}")
	@ApiOperation(value = "查询会员数量", httpMethod = "POST", response = ResultBean.class)
	public ResultBean totalMember(
			@ApiParam(value = "健康档案") @RequestParam(required = false) Integer archiveStatus,
			@ApiParam(value = "创建开始时间") @RequestParam(required = false) Date beginTime,
			@ApiParam(value = "创建结束时间") @RequestParam(required = false) Date endTime,
			@ApiParam(value = "登录管理员的ID") @RequestParam(required = false) Long addOpId,
			@ApiParam(value = "登录管理员的级别") @RequestParam(required = false) Long addRoleLevel,
			@ApiParam(value = "登录管理员所在机构级别") @RequestParam(required = false) Long addCompId) {
		try {
			int count = memberService.totalMember(archiveStatus, beginTime, endTime, addOpId, addRoleLevel, addCompId);

			return ResultUtil.returnResult(count, "查询会员数量成功");
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping("/add/{v}")
	@ApiOperation(value = "添加会员", httpMethod = "POST", response = ResultBean.class)
	public ResultBean addMember(@ModelAttribute UsrMember member) {

		try {
			int count = memberService.addMember(member);

			return ResultUtil.returnResult(count, "增加会员成功");
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	}

	@RequestMapping("/update/{v}")
	@ApiOperation(value = "修改会员", httpMethod = "POST", response = ResultBean.class)
	public ResultBean updateMember(@ModelAttribute UsrMember member) {

		try {
			int count = memberService.updateMember(member);

			return ResultUtil.returnResult(count, "更新会员成功");
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	}


	@RequestMapping("/archive/upload/{v}")
	@ApiOperation(value = "导入用户档案", httpMethod = "POST", response = ResultBean.class)
	public ResultBean uploadArchive(@RequestParam("file") MultipartFile file, 
			@ApiParam(value = "登录管理员所在机构级别") @RequestParam(required = false) Long addCompId) {
		try {
			UsrArchivesUMvo archive = memberService.uploadArchive(file, addCompId);

			return ResultUtil.returnResult(archive, "导入用户档案成功");
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping("/archive/download/{v}")
	@ApiOperation(value = "下载查询档案", httpMethod = "POST", response = ResultBean.class)
	public ResultBean downloadArchive(@ApiParam(value = "会员姓名") @RequestParam(required = false) String name,
			@ApiParam(value = "会员手机号") @RequestParam(required = false) String phone,
			@ApiParam(value = "会员账号") @RequestParam(required = false) String account,
			@ApiParam(value = "健康档案") @RequestParam(required = false) Integer archiveStatus,
			@ApiParam(value = "创建开始时间") @RequestParam(required = false) Date beginTime,
			@ApiParam(value = "创建结束时间") @RequestParam(required = false) Date endTime,
			@ApiParam(value = "是否被分配 0 已分配 1 未分配") @RequestParam(required = false) Integer opStatus,
			@ApiParam(value = "会员所属机构名称") @RequestParam(required = false) String compName,
			@ApiParam(value = "分配员工姓名") @RequestParam(required = false) String opName,
			@ApiParam(value = "登录管理员的ID") @RequestParam(required = true) Long addOpId,
			@ApiParam(value = "登录管理员的级别") @RequestParam(required = true) Long addRoleLevel,
			@ApiParam(value = "登录管理员所在机构级别") @RequestParam(required = true) Long addCompId) {
		try {
			String fileName = memberService.downloadArchive(name, phone, account, archiveStatus, beginTime, endTime, opStatus, compName, opName, addOpId, addRoleLevel, addCompId);

			return ResultUtil.returnResult(fileName, "导入用户档案成功");
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	
	}
	
	
	@RequestMapping("/archive/search/download/{v}")
	@ApiOperation(value = "下载导入失败档案", httpMethod = "POST", response = ResultBean.class)
	public void downloadSearchArchive(@ApiParam(value = "文件姓名") String fileName,
			HttpServletResponse response) {
		//TODO 防止漏洞注入
		memberService.downloadSearchArchive(fileName, response);
	}
	
	@RequestMapping("/archive/fail/download/{v}")
	@ApiOperation(value = "下载导入失败档案", httpMethod = "POST", response = ResultBean.class)
	public void downloadFailArchive(@ApiParam(value = "文件姓名") String fileName,
			HttpServletResponse response) {
		//TODO 防止漏洞注入
		memberService.downloadFailArchive(fileName, response);
	}
	
	@RequestMapping("/archive/temp/download/{v}")
	@ApiOperation(value = "下载导入失败档案", httpMethod = "POST", response = ResultBean.class)
	public void downloadTempArchive(HttpServletResponse response) {
		//TODO 防止漏洞注入
		memberService.downloadTempArchive(response);
	}
	
	@RequestMapping("/archive/add/{v}")
	@ApiOperation(value = "添加档案", httpMethod = "POST", response = ResultBean.class)
	public ResultBean addArchive(@ModelAttribute UsrArchives archives, @ModelAttribute UsrHabbit habbit) {
		try {
			int count = memberService.addArchive(archives, habbit);

			return ResultUtil.returnResult(count, "添加档案成功");
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping("/archive/update/{v}")
	@ApiOperation(value = "更新档案", httpMethod = "POST", response = ResultBean.class)
	public ResultBean updateArchive(@ModelAttribute UsrArchives archives, @ModelAttribute UsrHabbit habbit) {
		try {
			int count = memberService.updateArchive(archives, habbit);

			return ResultUtil.returnResult(count, "更新档案成功");
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping("/archive/detail/{v}")
	@ApiOperation(value = "查询档案详细信息", httpMethod = "POST", response = ResultBean.class)
	public ResultBean detailArchive(@ApiParam(value = "会员id") @RequestParam(required = false) Long membId) {
		try {
			UsrArchivesDMvo member = memberService.detailArchive(membId);

			return ResultUtil.returnResult(member, "查询档案详细信息成功");
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping("/family/list/{v}")
	@ApiOperation(value = "查询会家庭细信息", httpMethod = "POST", response = ResultBean.class)
	public ResultBean listFamily(@ApiParam(value = "会员id") @RequestParam(required = false) Long membId) {
		try {
			List<UsrFamilyLMvo> member = memberService.listFamily(membId);

			return ResultUtil.returnResult(member, "查询会员详细信息成功");
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping("/family/add/{v}")
	@ApiOperation(value = "添加家庭成员详细信息", httpMethod = "POST", response = ResultBean.class)
	public ResultBean saveFamily(@ModelAttribute UsrFamily family) {
		try {
			int count = memberService.saveFamily(family);

			return ResultUtil.returnResult(count, "添加家庭成员详细信息成功");
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping("/family/update/{v}")
	@ApiOperation(value = "更新家庭成员详细信息", httpMethod = "POST", response = ResultBean.class)
	public ResultBean updateFamily(@ModelAttribute UsrFamily family) {
		try {
			int count = memberService.updateFamily(family);

			return ResultUtil.returnResult(count, "更新家庭成员详细信息成功");
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping("/family/delete/{v}")
	@ApiOperation(value = "删除家庭成员详细信息", httpMethod = "POST", response = ResultBean.class)
	public ResultBean deleteFamily(Long famId) {
		try {
			int count = memberService.deleteFamily(famId);

			return ResultUtil.returnResult(count, "删除家庭成员详细信息成功");
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping("/data/list/{v}")
	@ApiOperation(value = "关注提醒列表", httpMethod = "POST", response = ResultBean.class)
	public ResultBean listMemberData(Long addOpId) {
		try {
			List<UsrErrorDataLMvo> data = memberService.listMemberData(addOpId);

			return ResultUtil.returnResult(data, "查询关注提醒列表成功");
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	}
	
	@RequestMapping("/data/update/{v}")
	@ApiOperation(value = "关注提醒列表", httpMethod = "POST", response = ResultBean.class)
	public ResultBean updateMemberData(Long edId) {
		try {
			int count = memberService.updateMemberStatus(edId);

			return ResultUtil.returnResult(count, "查询关注提醒列表成功");
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResultUtil.returnResult(e);
		}
	}
}
