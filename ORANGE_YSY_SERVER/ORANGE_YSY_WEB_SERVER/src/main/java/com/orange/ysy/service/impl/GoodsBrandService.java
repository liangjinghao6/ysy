package com.orange.ysy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.ysy.entity.PageBean;
import com.orange.ysy.entity.YsyGoodsBrand;
import com.orange.ysy.entity.YsyGoodsBrandExample;
import com.orange.ysy.enumerate.RecordStatus;
import com.orange.ysy.mapper.YsyGoodsBrandMapper;
import com.orange.ysy.service.IGoodsBrandService;
import com.orange.ysy.util.CreateId;

@Service
public class GoodsBrandService implements IGoodsBrandService{

	@Autowired
	private YsyGoodsBrandMapper goodsbrandMapper;
	
	@Override
	public Integer deleteById(String id) {
		YsyGoodsBrand goodsbrand = new YsyGoodsBrand();
		goodsbrand.setBrandId(id);
		goodsbrand.setRecordStatus(RecordStatus.DELETE.getValue());
		return goodsbrandMapper.updateByPrimaryKeySelective(goodsbrand);
	}

	@Override
	public Integer updateGoodsBrand(YsyGoodsBrand goodsbrand) {
		goodsbrand.setRecordStatus(null);
		goodsbrand.setCreateTime(null);
		goodsbrand.setUpdateTime(null);
		return goodsbrandMapper.updateByPrimaryKeySelective(goodsbrand);
	}

	@Override
	public Integer addGoodsBrand(YsyGoodsBrand goodsbrand) {
		goodsbrand.setBrandId(CreateId.Uuid());

		goodsbrand.setRecordStatus(RecordStatus.NORMAL.getValue());
		return goodsbrandMapper.insertSelective(goodsbrand);
	}

	@Override
	public PageBean<YsyGoodsBrand> findGoodsBrand(String q, Integer pageNum, Integer pageSize) {
		PageBean<YsyGoodsBrand> pageBean = new PageBean<YsyGoodsBrand>();
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		YsyGoodsBrandExample goodsbrandExample = new YsyGoodsBrandExample();
		goodsbrandExample.createCriteria().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue());
//		if(StringUtils.isNotEmpty(q)) {
//			goodsbrandExample.createCriteria().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue()).andWxLike("%" + q + "%");
//			goodsbrandExample.or().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue()).andGoodsBrandNameLike("%" + q + "%");
//		}
		goodsbrandExample.setLimit(pageSize);
		goodsbrandExample.setOffset((pageNum - 1)*pageSize);
	
		Long total = goodsbrandMapper.countByExample(goodsbrandExample);
		List<YsyGoodsBrand> list = goodsbrandMapper.selectByExample(goodsbrandExample);
		pageBean.setTotalRecords(total);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public YsyGoodsBrand detailGoodsBrand(String id) {
		return goodsbrandMapper.selectByPrimaryKey(id);
	}

}
