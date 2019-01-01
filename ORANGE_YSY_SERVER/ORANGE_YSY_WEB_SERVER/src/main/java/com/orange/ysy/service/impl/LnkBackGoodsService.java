package com.orange.ysy.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.ysy.entity.PageBean;
import com.orange.ysy.entity.YsyLnkBackGoods;
import com.orange.ysy.entity.YsyLnkBackGoodsExample;
import com.orange.ysy.enumerate.RecordStatus;
import com.orange.ysy.exception.OrangeRunTimeException;
import com.orange.ysy.mapper.YsyLnkBackGoodsMapper;
import com.orange.ysy.service.ILnkBackGoodsService;
import com.orange.ysy.util.CreateId;

@Service
public class LnkBackGoodsService implements ILnkBackGoodsService{

	@Autowired
	private YsyLnkBackGoodsMapper lnkbackgoodsMapper;
	
	@Override
	public Integer deleteById(String id) {
		YsyLnkBackGoods lnkbackgoods = new YsyLnkBackGoods();
		lnkbackgoods.setGoodsId(id);
		return lnkbackgoodsMapper.updateByPrimaryKeySelective(lnkbackgoods);
	}

	@Override
	public Integer updateLnkBackGoods(YsyLnkBackGoods lnkbackgoods) {
		lnkbackgoods.setCreateTime(null);
		return lnkbackgoodsMapper.updateByPrimaryKeySelective(lnkbackgoods);
	}

	@Override
	public Integer addLnkBackGoods(YsyLnkBackGoods lnkbackgoods) {
//		if (StringUtils.isEmpty(lnkbackgoods.getLnkBackGoodsName()) || StringUtils.isEmpty(lnkbackgoods.getWx())) {
//			throw new OrangeRunTimeException("参数为空");
//		}
//		
//		YsyLnkBackGoodsExample lnkbackgoodsExample = new YsyLnkBackGoodsExample();
//		lnkbackgoodsExample.createCriteria().andWxEqualTo(lnkbackgoods.getWx());
//		lnkbackgoodsExample.createCriteria().andLnkBackGoodsNameEqualTo(lnkbackgoods.getLnkBackGoodsName());
//		List<YsyLnkBackGoods> lnkbackgoodsCheck = lnkbackgoodsMapper.selectByExample(lnkbackgoodsExample);
//		if (lnkbackgoodsCheck.size() > 0) {
//			throw new OrangeRunTimeException("用户名已经存在");
//		}
		lnkbackgoods.setGoodsId(CreateId.Uuid());

		return lnkbackgoodsMapper.insertSelective(lnkbackgoods);
	}

	@Override
	public PageBean<YsyLnkBackGoods> findLnkBackGoods(String q, Integer pageNum, Integer pageSize) {
		PageBean<YsyLnkBackGoods> pageBean = new PageBean<YsyLnkBackGoods>();
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		YsyLnkBackGoodsExample lnkbackgoodsExample = new YsyLnkBackGoodsExample();
//		lnkbackgoodsExample.createCriteria().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue());
//		if(StringUtils.isNotEmpty(q)) {
//			lnkbackgoodsExample.createCriteria().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue()).andWxLike("%" + q + "%");
//			lnkbackgoodsExample.or().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue()).andLnkBackGoodsNameLike("%" + q + "%");
//		}
		lnkbackgoodsExample.setLimit(pageSize);
		lnkbackgoodsExample.setOffset((pageNum - 1)*pageSize);
	
		Long total = lnkbackgoodsMapper.countByExample(lnkbackgoodsExample);
		List<YsyLnkBackGoods> list = lnkbackgoodsMapper.selectByExample(lnkbackgoodsExample);
		pageBean.setTotalRecords(total);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public YsyLnkBackGoods detailLnkBackGoods(String id) {
		return lnkbackgoodsMapper.selectByPrimaryKey(id);
	}

}
