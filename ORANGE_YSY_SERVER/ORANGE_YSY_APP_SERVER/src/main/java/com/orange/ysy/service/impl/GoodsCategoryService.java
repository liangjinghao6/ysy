package com.orange.ysy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.ysy.entity.PageBean;
import com.orange.ysy.entity.YsyGoodsCategory;
import com.orange.ysy.entity.YsyGoodsCategoryExample;
import com.orange.ysy.enumerate.RecordStatus;
import com.orange.ysy.mapper.YsyGoodsCategoryMapper;
import com.orange.ysy.service.IGoodsCategoryService;
import com.orange.ysy.util.CreateId;

@Service
public class GoodsCategoryService implements IGoodsCategoryService{

	@Autowired
	private YsyGoodsCategoryMapper goodscategoryMapper;
	
	@Override
	public Integer deleteById(String id) {
		YsyGoodsCategory goodscategory = new YsyGoodsCategory();
		goodscategory.setCategoryId(id);
		goodscategory.setRecordStatus(RecordStatus.DELETE.getValue());
		return goodscategoryMapper.updateByPrimaryKeySelective(goodscategory);
	}


	@Override
	public Integer updateGoodsCategory(YsyGoodsCategory goodscategory) {
		goodscategory.setRecordStatus(null);
		goodscategory.setCreateTime(null);
		goodscategory.setUpdateTime(null);
		return goodscategoryMapper.updateByPrimaryKey(goodscategory);
	}

	@Override
	public Integer addGoodsCategory(YsyGoodsCategory goodscategory) {
//		if (StringUtils.isEmpty(goodscategory.getGoodsCategoryName()) || StringUtils.isEmpty(goodscategory.getWx())) {
//			throw new OrangeRunTimeException("参数为空");
//		}
//		
//		YsyGoodsCategoryExample goodscategoryExample = new YsyGoodsCategoryExample();
//		goodscategoryExample.createCriteria().andWxEqualTo(goodscategory.getWx());
//		goodscategoryExample.createCriteria().andGoodsCategoryNameEqualTo(goodscategory.getGoodsCategoryName());
//		List<YsyGoodsCategory> goodscategoryCheck = goodscategoryMapper.selectByExample(goodscategoryExample);
//		if (goodscategoryCheck.size() > 0) {
//			throw new OrangeRunTimeException("用户名已经存在");
//		}
		goodscategory.setCategoryId(CreateId.Uuid());

		goodscategory.setRecordStatus(RecordStatus.NORMAL.getValue());
		return goodscategoryMapper.insertSelective(goodscategory);
	}

	@Override
	public PageBean<YsyGoodsCategory> findGoodsCategory(String q, Integer pageNum, Integer pageSize) {
		PageBean<YsyGoodsCategory> pageBean = new PageBean<YsyGoodsCategory>();
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		YsyGoodsCategoryExample goodscategoryExample = new YsyGoodsCategoryExample();
		goodscategoryExample.createCriteria().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue());
//		if(StringUtils.isNotEmpty(q)) {
//			goodscategoryExample.createCriteria().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue()).andWxLike("%" + q + "%");
//			goodscategoryExample.or().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue()).andGoodsCategoryNameLike("%" + q + "%");
//		}
		goodscategoryExample.setLimit(pageSize);
		goodscategoryExample.setOffset((pageNum - 1)*pageSize);
	
		Long total = goodscategoryMapper.countByExample(goodscategoryExample);
		List<YsyGoodsCategory> list = goodscategoryMapper.selectByExample(goodscategoryExample);
		pageBean.setTotalRecords(total);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public YsyGoodsCategory detailGoodsCategory(String id) {
		return goodscategoryMapper.selectByPrimaryKey(id);
	}

}
