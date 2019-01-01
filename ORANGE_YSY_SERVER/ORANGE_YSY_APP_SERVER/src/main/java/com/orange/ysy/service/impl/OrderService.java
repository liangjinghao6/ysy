package com.orange.ysy.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.ysy.entity.PageBean;
import com.orange.ysy.entity.YsyOrder;
import com.orange.ysy.entity.YsyOrderExample;
import com.orange.ysy.enumerate.RecordStatus;
import com.orange.ysy.exception.OrangeRunTimeException;
import com.orange.ysy.mapper.YsyOrderMapper;
import com.orange.ysy.service.IOrderService;
import com.orange.ysy.util.CreateId;

@Service
public class OrderService implements IOrderService{

	@Autowired
	private YsyOrderMapper orderMapper;
	
	@Override
	public Integer deleteById(String id) {
		YsyOrder order = new YsyOrder();
		order.setOrderId(id);
		order.setRecordStatus(RecordStatus.DELETE.getValue());
		return orderMapper.updateByPrimaryKeySelective(order);
	}


	@Override
	public Integer updateOrder(YsyOrder order) {
		order.setRecordStatus(null);
		order.setCreateTime(null);
		order.setUpdateTime(null);
		return orderMapper.updateByPrimaryKey(order);
	}

	@Override
	public Integer addOrder(YsyOrder order) {
//		if (StringUtils.isEmpty(order.getOrderName()) || StringUtils.isEmpty(order.getWx())) {
//			throw new OrangeRunTimeException("参数为空");
//		}
//		
//		YsyOrderExample orderExample = new YsyOrderExample();
//		orderExample.createCriteria().andWxEqualTo(order.getWx());
//		orderExample.createCriteria().andOrderNameEqualTo(order.getOrderName());
//		List<YsyOrder> orderCheck = orderMapper.selectByExample(orderExample);
//		if (orderCheck.size() > 0) {
//			throw new OrangeRunTimeException("用户名已经存在");
//		}
		order.setOrderId(CreateId.Uuid());

		order.setRecordStatus(RecordStatus.NORMAL.getValue());
		return orderMapper.insertSelective(order);
	}

	@Override
	public PageBean<YsyOrder> findOrder(String q, Integer pageNum, Integer pageSize) {
		PageBean<YsyOrder> pageBean = new PageBean<YsyOrder>();
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		YsyOrderExample orderExample = new YsyOrderExample();
		orderExample.createCriteria().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue());
//		if(StringUtils.isNotEmpty(q)) {
//			orderExample.createCriteria().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue()).andWxLike("%" + q + "%");
//			orderExample.or().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue()).andOrderNameLike("%" + q + "%");
//		}
		orderExample.setLimit(pageSize);
		orderExample.setOffset((pageNum - 1)*pageSize);
	
		Long total = orderMapper.countByExample(orderExample);
		List<YsyOrder> list = orderMapper.selectByExample(orderExample);
		pageBean.setTotalRecords(total);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public YsyOrder detailOrder(String id) {
		return orderMapper.selectByPrimaryKey(id);
	}

}
