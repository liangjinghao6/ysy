package com.orange.ysy.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.ysy.entity.PageBean;
import com.orange.ysy.entity.YsySysFile;
import com.orange.ysy.entity.YsySysFileExample;
import com.orange.ysy.enumerate.RecordStatus;
import com.orange.ysy.exception.OrangeRunTimeException;
import com.orange.ysy.mapper.YsySysFileMapper;
import com.orange.ysy.service.ISysFileService;
import com.orange.ysy.util.CreateId;

@Service
public class SysFileService implements ISysFileService{

	@Autowired
	private YsySysFileMapper sysfileMapper;
	
	@Override
	public Integer deleteById(String id) {
		YsySysFile sysfile = new YsySysFile();
		sysfile.setFileId(id);
		sysfile.setRecordStatus(RecordStatus.DELETE.getValue());
		return sysfileMapper.updateByPrimaryKeySelective(sysfile);
	}


	@Override
	public Integer updateSysFile(YsySysFile sysfile) {
		sysfile.setRecordStatus(null);
		sysfile.setCreateTime(null);
		sysfile.setUpdateTime(null);
		return sysfileMapper.updateByPrimaryKey(sysfile);
	}

	@Override
	public Integer addSysFile(YsySysFile sysfile) {
//		if (StringUtils.isEmpty(sysfile.getSysFileName()) || StringUtils.isEmpty(sysfile.getWx())) {
//			throw new OrangeRunTimeException("参数为空");
//		}
//		
//		YsySysFileExample sysfileExample = new YsySysFileExample();
//		sysfileExample.createCriteria().andWxEqualTo(sysfile.getWx());
//		sysfileExample.createCriteria().andSysFileNameEqualTo(sysfile.getSysFileName());
//		List<YsySysFile> sysfileCheck = sysfileMapper.selectByExample(sysfileExample);
//		if (sysfileCheck.size() > 0) {
//			throw new OrangeRunTimeException("用户名已经存在");
//		}
		sysfile.setFileId(CreateId.Uuid());

		sysfile.setRecordStatus(RecordStatus.NORMAL.getValue());
		return sysfileMapper.insertSelective(sysfile);
	}

	@Override
	public PageBean<YsySysFile> findSysFile(String q, Integer pageNum, Integer pageSize) {
		PageBean<YsySysFile> pageBean = new PageBean<YsySysFile>();
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		YsySysFileExample sysfileExample = new YsySysFileExample();
		sysfileExample.createCriteria().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue());
//		if(StringUtils.isNotEmpty(q)) {
//			sysfileExample.createCriteria().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue()).andWxLike("%" + q + "%");
//			sysfileExample.or().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue()).andSysFileNameLike("%" + q + "%");
//		}
		sysfileExample.setLimit(pageSize);
		sysfileExample.setOffset((pageNum - 1)*pageSize);
	
		Long total = sysfileMapper.countByExample(sysfileExample);
		List<YsySysFile> list = sysfileMapper.selectByExample(sysfileExample);
		pageBean.setTotalRecords(total);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public YsySysFile detailSysFile(String id) {
		return sysfileMapper.selectByPrimaryKey(id);
	}

}
