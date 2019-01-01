package com.orange.ysy.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.ysy.entity.PageBean;
import com.orange.ysy.entity.YsyLnkGoodsClass;
import com.orange.ysy.entity.YsyLnkGoodsClassExample;
import com.orange.ysy.enumerate.RecordStatus;
import com.orange.ysy.exception.OrangeRunTimeException;
import com.orange.ysy.mapper.YsyLnkGoodsClassMapper;
import com.orange.ysy.service.ILnkGoodsClassService;
import com.orange.ysy.util.CreateId;

@Service
public class LnkGoodsClassService implements ILnkGoodsClassService{

	@Autowired
	private YsyLnkGoodsClassMapper lnkgoodsclassMapper;
	
	@Override
	public Integer deleteById(String id) {
		YsyLnkGoodsClass lnkgoodsclass = new YsyLnkGoodsClass();
		lnkgoodsclass.setClassId(id);
//		lnkgoodsclass.setRecordStatus(RecordStatus.DELETE.getValue());
		return lnkgoodsclassMapper.updateByPrimaryKeySelective(lnkgoodsclass);
	}


	@Override
	public Integer updateLnkGoodsClass(YsyLnkGoodsClass lnkgoodsclass) {
		lnkgoodsclass.setCreateTime(null);
		return lnkgoodsclassMapper.updateByPrimaryKey(lnkgoodsclass);
	}

	@Override
	public Integer addLnkGoodsClass(YsyLnkGoodsClass lnkgoodsclass) {
//		if (StringUtils.isEmpty(lnkgoodsclass.getLnkGoodsClassName()) || StringUtils.isEmpty(lnkgoodsclass.getWx())) {
//			throw new OrangeRunTimeException("参数为空");
//		}
//		
//		YsyLnkGoodsClassExample lnkgoodsclassExample = new YsyLnkGoodsClassExample();
//		lnkgoodsclassExample.createCriteria().andWxEqualTo(lnkgoodsclass.getWx());
//		lnkgoodsclassExample.createCriteria().andLnkGoodsClassNameEqualTo(lnkgoodsclass.getLnkGoodsClassName());
//		List<YsyLnkGoodsClass> lnkgoodsclassCheck = lnkgoodsclassMapper.selectByExample(lnkgoodsclassExample);
//		if (lnkgoodsclassCheck.size() > 0) {
//			throw new OrangeRunTimeException("用户名已经存在");
//		}
		lnkgoodsclass.setClassId(CreateId.Uuid());

		return lnkgoodsclassMapper.insertSelective(lnkgoodsclass);
	}

	@Override
	public PageBean<YsyLnkGoodsClass> findLnkGoodsClass(String q, Integer pageNum, Integer pageSize) {
		PageBean<YsyLnkGoodsClass> pageBean = new PageBean<YsyLnkGoodsClass>();
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		YsyLnkGoodsClassExample lnkgoodsclassExample = new YsyLnkGoodsClassExample();
//		lnkgoodsclassExample.createCriteria().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue());
//		if(StringUtils.isNotEmpty(q)) {
//			lnkgoodsclassExample.createCriteria().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue()).andWxLike("%" + q + "%");
//			lnkgoodsclassExample.or().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue()).andLnkGoodsClassNameLike("%" + q + "%");
//		}
		lnkgoodsclassExample.setLimit(pageSize);
		lnkgoodsclassExample.setOffset((pageNum - 1)*pageSize);
	
		Long total = lnkgoodsclassMapper.countByExample(lnkgoodsclassExample);
		List<YsyLnkGoodsClass> list = lnkgoodsclassMapper.selectByExample(lnkgoodsclassExample);
		pageBean.setTotalRecords(total);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public YsyLnkGoodsClass detailLnkGoodsClass(String id) {
		return lnkgoodsclassMapper.selectByPrimaryKey(id);
	}

}
