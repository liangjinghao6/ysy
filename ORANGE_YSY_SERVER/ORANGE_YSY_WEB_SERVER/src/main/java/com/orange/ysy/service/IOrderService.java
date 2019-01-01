package com.orange.ysy.service;

import com.orange.ysy.entity.PageBean;
import com.orange.ysy.entity.YsyOrder;

/**
* @author 梁景皓
* @date 2018-12-24
*/
public interface IOrderService {
	
	Integer deleteById(String id);

	Integer updateOrder(YsyOrder user);

	Integer addOrder(YsyOrder user);

	PageBean<YsyOrder> findOrder(String q, Integer page, Integer limit);

	YsyOrder detailOrder(String id);
}
