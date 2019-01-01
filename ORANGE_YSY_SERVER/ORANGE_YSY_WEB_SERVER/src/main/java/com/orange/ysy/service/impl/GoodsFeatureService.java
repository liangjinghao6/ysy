package com.orange.ysy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.ysy.entity.PageBean;
import com.orange.ysy.entity.YsyGoodsFeature;
import com.orange.ysy.entity.YsyGoodsFeatureExample;
import com.orange.ysy.enumerate.RecordStatus;
import com.orange.ysy.mapper.YsyGoodsFeatureMapper;
import com.orange.ysy.service.IGoodsFeatureService;
import com.orange.ysy.util.CreateId;

@Service
public class GoodsFeatureService implements IGoodsFeatureService{

	@Autowired
	private YsyGoodsFeatureMapper goodsfeatureMapper;
	
	@Override
	public Integer deleteById(String id) {
		YsyGoodsFeature goodsfeature = new YsyGoodsFeature();
		goodsfeature.setFeatureId(id);
		goodsfeature.setRecordStatus(RecordStatus.DELETE.getValue());
		return goodsfeatureMapper.updateByPrimaryKeySelective(goodsfeature);
	}

	@Override
	public Integer updateGoodsFeature(YsyGoodsFeature goodsfeature) {
		goodsfeature.setRecordStatus(null);
		goodsfeature.setCreateTime(null);
		goodsfeature.setUpdateTime(null);
		return goodsfeatureMapper.updateByPrimaryKeySelective(goodsfeature);
	}

	@Override
	public Integer addGoodsFeature(YsyGoodsFeature goodsfeature) {
//		if (StringUtils.isEmpty(goodsfeature.getGoodsFeatureName()) || StringUtils.isEmpty(goodsfeature.getWx())) {
//			throw new OrangeRunTimeException("参数为空");
//		}
//		
//		YsyGoodsFeatureExample goodsfeatureExample = new YsyGoodsFeatureExample();
//		goodsfeatureExample.createCriteria().andWxEqualTo(goodsfeature.getWx());
//		goodsfeatureExample.createCriteria().andGoodsFeatureNameEqualTo(goodsfeature.getGoodsFeatureName());
//		List<YsyGoodsFeature> goodsfeatureCheck = goodsfeatureMapper.selectByExample(goodsfeatureExample);
//		if (goodsfeatureCheck.size() > 0) {
//			throw new OrangeRunTimeException("用户名已经存在");
//		}
		goodsfeature.setFeatureId(CreateId.Uuid());

		goodsfeature.setRecordStatus(RecordStatus.NORMAL.getValue());
		return goodsfeatureMapper.insertSelective(goodsfeature);
	}

	@Override
	public PageBean<YsyGoodsFeature> findGoodsFeature(String q, Integer pageNum, Integer pageSize) {
		PageBean<YsyGoodsFeature> pageBean = new PageBean<YsyGoodsFeature>();
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		YsyGoodsFeatureExample goodsfeatureExample = new YsyGoodsFeatureExample();
		goodsfeatureExample.createCriteria().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue());
//		if(StringUtils.isNotEmpty(q)) {
//			goodsfeatureExample.createCriteria().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue()).andWxLike("%" + q + "%");
//			goodsfeatureExample.or().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue()).andGoodsFeatureNameLike("%" + q + "%");
//		}
		goodsfeatureExample.setLimit(pageSize);
		goodsfeatureExample.setOffset((pageNum - 1)*pageSize);
	
		Long total = goodsfeatureMapper.countByExample(goodsfeatureExample);
		List<YsyGoodsFeature> list = goodsfeatureMapper.selectByExample(goodsfeatureExample);
		pageBean.setTotalRecords(total);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public YsyGoodsFeature detailGoodsFeature(String id) {
		return goodsfeatureMapper.selectByPrimaryKey(id);
	}

}
