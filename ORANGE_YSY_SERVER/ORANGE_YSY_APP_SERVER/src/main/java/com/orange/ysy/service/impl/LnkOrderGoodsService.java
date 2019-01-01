package com.orange.ysy.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.ysy.entity.PageBean;
import com.orange.ysy.entity.YsyLnkOrderGoods;
import com.orange.ysy.entity.YsyLnkOrderGoodsExample;
import com.orange.ysy.enumerate.RecordStatus;
import com.orange.ysy.exception.OrangeRunTimeException;
import com.orange.ysy.mapper.YsyLnkOrderGoodsMapper;
import com.orange.ysy.service.ILnkOrderGoodsService;
import com.orange.ysy.util.CreateId;

@Service
public class LnkOrderGoodsService implements ILnkOrderGoodsService{

	@Autowired
	private YsyLnkOrderGoodsMapper lnkordergoodsMapper;
	
	@Override
	public Integer deleteById(String id) {
		YsyLnkOrderGoods lnkordergoods = new YsyLnkOrderGoods();
		lnkordergoods.setGoodsId(id);
		return lnkordergoodsMapper.updateByPrimaryKeySelective(lnkordergoods);
	}

	@Override
	public Integer updateLnkOrderGoods(YsyLnkOrderGoods lnkordergoods) {
		lnkordergoods.setCreateTime(null);
		return lnkordergoodsMapper.updateByPrimaryKey(lnkordergoods);
	}

	@Override
	public Integer addLnkOrderGoods(YsyLnkOrderGoods lnkordergoods) {
//		if (StringUtils.isEmpty(lnkordergoods.getLnkOrderGoodsName()) || StringUtils.isEmpty(lnkordergoods.getWx())) {
//			throw new OrangeRunTimeException("参数为空");
//		}
//		
//		YsyLnkOrderGoodsExample lnkordergoodsExample = new YsyLnkOrderGoodsExample();
//		lnkordergoodsExample.createCriteria().andWxEqualTo(lnkordergoods.getWx());
//		lnkordergoodsExample.createCriteria().andLnkOrderGoodsNameEqualTo(lnkordergoods.getLnkOrderGoodsName());
//		List<YsyLnkOrderGoods> lnkordergoodsCheck = lnkordergoodsMapper.selectByExample(lnkordergoodsExample);
//		if (lnkordergoodsCheck.size() > 0) {
//			throw new OrangeRunTimeException("用户名已经存在");
//		}
		lnkordergoods.setGoodsId(CreateId.Uuid());

		return lnkordergoodsMapper.insertSelective(lnkordergoods);
	}

	@Override
	public PageBean<YsyLnkOrderGoods> findLnkOrderGoods(String q, Integer pageNum, Integer pageSize) {
		PageBean<YsyLnkOrderGoods> pageBean = new PageBean<YsyLnkOrderGoods>();
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		YsyLnkOrderGoodsExample lnkordergoodsExample = new YsyLnkOrderGoodsExample();
//		lnkordergoodsExample.createCriteria().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue());
//		if(StringUtils.isNotEmpty(q)) {
//			lnkordergoodsExample.createCriteria().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue()).andWxLike("%" + q + "%");
//			lnkordergoodsExample.or().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue()).andLnkOrderGoodsNameLike("%" + q + "%");
//		}
		lnkordergoodsExample.setLimit(pageSize);
		lnkordergoodsExample.setOffset((pageNum - 1)*pageSize);
	
		Long total = lnkordergoodsMapper.countByExample(lnkordergoodsExample);
		List<YsyLnkOrderGoods> list = lnkordergoodsMapper.selectByExample(lnkordergoodsExample);
		pageBean.setTotalRecords(total);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public YsyLnkOrderGoods detailLnkOrderGoods(String id) {
		return lnkordergoodsMapper.selectByPrimaryKey(id);
	}

}
