package com.orange.ysy.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.ysy.entity.PageBean;
import com.orange.ysy.entity.YsyOrderBack;
import com.orange.ysy.entity.YsyOrderBackExample;
import com.orange.ysy.enumerate.RecordStatus;
import com.orange.ysy.exception.OrangeRunTimeException;
import com.orange.ysy.mapper.YsyOrderBackMapper;
import com.orange.ysy.service.IOrderBackService;
import com.orange.ysy.util.CreateId;

@Service
public class OrderBackService implements IOrderBackService{

	@Autowired
	private YsyOrderBackMapper orderbackMapper;
	
	@Override
	public Integer deleteById(String id) {
		YsyOrderBack orderback = new YsyOrderBack();
		orderback.setBackId(id);
		orderback.setRecordStatus(RecordStatus.DELETE.getValue());
		return orderbackMapper.updateByPrimaryKeySelective(orderback);
	}


	@Override
	public Integer updateOrderBack(YsyOrderBack orderback) {
		orderback.setRecordStatus(null);
		orderback.setCreateTime(null);
		orderback.setUpdateTime(null);
		return orderbackMapper.updateByPrimaryKeySelective(orderback);
	}

	@Override
	public Integer addOrderBack(YsyOrderBack orderback) {
//		if (StringUtils.isEmpty(orderback.getOrderBackName()) || StringUtils.isEmpty(orderback.getWx())) {
//			throw new OrangeRunTimeException("参数为空");
//		}
//		
//		YsyOrderBackExample orderbackExample = new YsyOrderBackExample();
//		orderbackExample.createCriteria().andWxEqualTo(orderback.getWx());
//		orderbackExample.createCriteria().andOrderBackNameEqualTo(orderback.getOrderBackName());
//		List<YsyOrderBack> orderbackCheck = orderbackMapper.selectByExample(orderbackExample);
//		if (orderbackCheck.size() > 0) {
//			throw new OrangeRunTimeException("用户名已经存在");
//		}
		orderback.setBackId(CreateId.Uuid());

		orderback.setRecordStatus(RecordStatus.NORMAL.getValue());
		return orderbackMapper.insertSelective(orderback);
	}

	@Override
	public PageBean<YsyOrderBack> findOrderBack(String q, Integer pageNum, Integer pageSize) {
		PageBean<YsyOrderBack> pageBean = new PageBean<YsyOrderBack>();
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		YsyOrderBackExample orderbackExample = new YsyOrderBackExample();
		orderbackExample.createCriteria().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue());
//		if(StringUtils.isNotEmpty(q)) {
//			orderbackExample.createCriteria().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue()).andWxLike("%" + q + "%");
//			orderbackExample.or().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue()).andOrderBackNameLike("%" + q + "%");
//		}
		orderbackExample.setLimit(pageSize);
		orderbackExample.setOffset((pageNum - 1)*pageSize);
	
		Long total = orderbackMapper.countByExample(orderbackExample);
		List<YsyOrderBack> list = orderbackMapper.selectByExample(orderbackExample);
		pageBean.setTotalRecords(total);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public YsyOrderBack detailOrderBack(String id) {
		return orderbackMapper.selectByPrimaryKey(id);
	}

}
